package com.chang.once;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RedEnvelopeGenerator {

    private static final String UNIFORM_DISDTIBUTION = "uniform_distribution";
    private static final String GAUSSIAN_DISDTIBUTION = "gaussian_distribution";

    Random random = new Random();

    private static final int MAX_TRY_COUNT = 20;

    private String form = "";

    public List<BigDecimal> genRedEnvelopes(BigDecimal money, int number, BigDecimal minMoneyPerRedEnvelope, int unit) {
        double moneyNear = money.doubleValue();
        double minMoneyNear = minMoneyPerRedEnvelope.doubleValue();
        if (moneyNear < minMoneyNear * number) {
            System.out.printf("total amount is not enough. money = %d, minMoney = %d, number = %d", minMoneyNear, minMoneyNear, number);
            throw new RuntimeException();
        }

        List<BigDecimal> result = null;
        switch (this.form) {
            case UNIFORM_DISDTIBUTION:
                result = genUniformRedEnvelopes(money, number, minMoneyPerRedEnvelope, unit);
                break;
            case GAUSSIAN_DISDTIBUTION:
            default:
                result = genGaussianRedEnvelopes(money, number, minMoneyPerRedEnvelope, unit);
                break;
        }
        return result;
    }

    private List<BigDecimal> genUniformRedEnvelopes(BigDecimal money, int number, BigDecimal minMoneyPerRedEnvelope, int unit) {
        List<BigDecimal> result = new ArrayList<>();

        // 每个人能抢到的金额服从minMoneyPerRedEnvelope到2倍剩余均值之间的均匀分布。
        BigDecimal left = money.subtract(minMoneyPerRedEnvelope.multiply(new BigDecimal(number)));
        for(int i = 0; i < number - 1; i++) {
            double aveLeft = left.doubleValue() / (number - i);
            double value = 2 * aveLeft * generateUniformDistribution();
            BigDecimal enve = new BigDecimal(value).setScale(unit, BigDecimal.ROUND_HALF_DOWN);
            result.add(enve.add(minMoneyPerRedEnvelope));
            left = left.subtract(enve);
        }
        result.add(left.add(minMoneyPerRedEnvelope));

        return result;
    }

    private List<BigDecimal> genGaussianRedEnvelopes(BigDecimal money, int number, BigDecimal minMoneyPerRedEnvelope, int unit) {
        double moneyNear = money.doubleValue();
        double minMoneyNear = minMoneyPerRedEnvelope.doubleValue();

        // 大于.75平均值的概率为0.95
        // 随机生成number-1个高斯随机数(舍弃小于0的)，若number-1个数的和大于红包总金额，舍弃此组数据重新生成
        double ave = moneyNear/ number - minMoneyNear;
        double lowThreshold = 0.75;
        double C = 1.96;
        double sigma = Math.pow((ave * (1 - lowThreshold)) / C, 2);
        List<BigDecimal> result = new ArrayList<>();
        int count = 0;
        while(result.size() < number && count < MAX_TRY_COUNT) {
            result.clear();
            BigDecimal used = BigDecimal.ZERO;
            for(int i = 0; i < number - 1 && used.compareTo(money) < 0; i++) {
                double valD = generateGaussianDistribution(ave, sigma);
                BigDecimal valB = BigDecimal.ZERO;
                do {
                    valB = new BigDecimal(valD).setScale(unit, BigDecimal.ROUND_HALF_DOWN);
                } while(valB.compareTo(BigDecimal.ZERO) < 0);
                valB = valB.add(minMoneyPerRedEnvelope);
                result.add(valB);
                used = used.add(valB);
            }
            if(used.add(minMoneyPerRedEnvelope).compareTo(money) < 0) {
                result.add(money.subtract(used));
            }
        }
        return result.size() == number ? result : null;
    }

    /**
     * 均匀分布
     */
    private double generateUniformDistribution() {
        return random.nextDouble();
    }

    /**
     * 产生高斯分布的随机数，均值为average， 方差为sigma
     */
    private double generateGaussianDistribution(double average, double sigma) {
        double value = Math.sqrt(sigma) * random.nextGaussian() + average;
        return value;
    }


    public static void main(String[] args) {
        RedEnvelopeGenerator gen = new RedEnvelopeGenerator();
        BigDecimal total = new BigDecimal("0.01");

        gen.form = UNIFORM_DISDTIBUTION;
//        gen.form = GAUSSIAN_DISDTIBUTION;
        List<BigDecimal> result = gen.genRedEnvelopes(total, 200, new BigDecimal("0.000001"), 6);

        BigDecimal to = BigDecimal.ZERO;
        for (BigDecimal b : result) {
            to = to.add(b);
            System.out.println(b);
        }
        System.out.println(total.compareTo(to) == 0);
    }

}
