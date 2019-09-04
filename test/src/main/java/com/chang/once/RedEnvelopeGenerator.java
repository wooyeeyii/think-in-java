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
        double moneyNear = money.doubleValue();
        double minMoneyNear = minMoneyPerRedEnvelope.doubleValue();
        List<BigDecimal> result = new ArrayList<>();

        double max = moneyNear - minMoneyNear * number;
        double[] values = new double[number];
        for(int i = 0; i < number - 1; i++) {
            values[i] = max * generateUniformDistribution();
        }
        values[number - 1] = max;
        Arrays.sort(values);
        BigDecimal pre = BigDecimal.ZERO;
        for(int i = 0; i < number; i++) {
            BigDecimal next = new BigDecimal(values[i]).setScale(unit, BigDecimal.ROUND_HALF_DOWN);
            result.add(next.subtract(pre).add(minMoneyPerRedEnvelope));
            pre = next;
        }

        return result;
    }

    private List<BigDecimal> genGaussianRedEnvelopes(BigDecimal money, int number, BigDecimal minMoneyPerRedEnvelope, int unit) {
        double moneyNear = money.doubleValue();
        double minMoneyNear = minMoneyPerRedEnvelope.doubleValue();

        // 大于.75平均值的概率为0.95
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
        BigDecimal total = new BigDecimal("100000");

        gen.form = GAUSSIAN_DISDTIBUTION;
        List<BigDecimal> result = gen.genRedEnvelopes(total, 1000, new BigDecimal("60"), 2);

        BigDecimal to = BigDecimal.ZERO;
        for (BigDecimal b : result) {
            to = to.add(b);
            System.out.println(b);
        }
        System.out.println(total.compareTo(to) == 0);
    }

}
