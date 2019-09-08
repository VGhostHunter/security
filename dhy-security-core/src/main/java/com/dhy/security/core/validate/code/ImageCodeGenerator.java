package com.dhy.security.core.validate.code;

import com.dhy.security.core.properties.ImageCodeProperties;
import com.dhy.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author VGhostHunter
 */
public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletWebRequest request) {
        StringBuffer sb = new StringBuffer();
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", securityProperties.getCode().getImage().getHeight());
        int num = securityProperties.getCode().getImage().getNum();
        int fontSize = securityProperties.getCode().getImage().getFontSize();
        int lines = securityProperties.getCode().getImage().getLines();
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);
        // 2.获取图片画笔
        Graphics graphic = image.getGraphics();
        // 3.设置画笔颜色
        graphic.setColor(new Color(255, 125, 37));
        // 4.绘制矩形背景
        graphic.fillRect(0, 0, width, height);
        // 5.画随机字符
        Random ran = new Random();
        for (int i = 0; i < num; i++) {
            // 取随机字符索引
            int n = ran.nextInt(ImageCodeProperties.chars.length);
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 设置字体大小
            graphic.setFont(new Font(
                    null, Font.BOLD + Font.ITALIC, fontSize));
            // 画字符
            graphic.drawString(
                    ImageCodeProperties.chars[n] + "", i * width / num, height*4/5);
            // 记录字符
            sb.append(ImageCodeProperties.chars[n]);
        }
        // 6.画干扰线
        for (int i = 0; i < lines; i++) {
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 随机画线
            graphic.drawLine(ran.nextInt(width), ran.nextInt(height),
                    ran.nextInt(width), ran.nextInt(height));
        }
        graphic.dispose();
        // 7.返回验证码和图片
        return new ImageCode(image, sb.toString(), securityProperties.getCode().getImage().getExpireIn());
    }

    /**
     * 随机取色
     */
    private Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
