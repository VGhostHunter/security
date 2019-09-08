package com.dhy.code;

import com.dhy.security.core.validate.code.ImageCode;
import com.dhy.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author VGhostHunter
 */
// @Component("imageCodeGenerator")
public class DemoImageGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("高级的图形验证码生成器");
        return null;
    }
}
