package com.dhy.security.core.validate.code;

import com.dhy.security.core.validate.code.image.ImageCodeGenerator;
import com.dhy.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.dhy.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author VGhostHunter
 */
@Configuration
public class ValidateCodeBeanConfig {


    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        return new ImageCodeGenerator();
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
