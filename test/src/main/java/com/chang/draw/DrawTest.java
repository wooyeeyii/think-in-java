package com.chang.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class DrawTest {

    private final String preSellBackgroundUrl = "/preSellCircle.png";
    //    String emoji = "\uD83C\uDF40";    // 树叶
    String emoji = "\uD83D\uDC34";  //🐴

    public void generatePreSellImage() {
        String url = null;
        try {
            InputStream input = this.getClass().getResourceAsStream(preSellBackgroundUrl);
            BufferedImage imageOne = ImageIO.read(input);
            System.out.println(emoji);
            constructImage(imageOne, "emoji", emoji);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void constructImage(BufferedImage bgImage, String up, String bottom) throws Exception {
        int w = bgImage.getWidth();
        int h = bgImage.getHeight();
        int middleX = w / 2;
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();

        // 作图
        g.drawImage(bgImage, 0, 0, null);
        Font t = new Font("OpenSansEmoji", Font.PLAIN, 30);
        FontMetrics tm = sun.font.FontDesignMetrics.getMetrics(t);

        g.setFont(t);
        Color titleColor = new Color(226, 167, 61);
        g.setPaint(titleColor);

        g.drawString(bottom, middleX - (tm.stringWidth(bottom) / 2) + 12, 168);

        File outFile = new File("output.png");
        ImageIO.write(bi, "png", outFile);
    }

    public static void main(String[] args) {
        DrawTest drawTest = new DrawTest();
        drawTest.generatePreSellImage();
    }
}
