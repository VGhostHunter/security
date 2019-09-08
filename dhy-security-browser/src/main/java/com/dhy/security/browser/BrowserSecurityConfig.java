package com.dhy.security.browser;

import com.dhy.security.core.properties.SecurityProperties;
import com.dhy.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author VGhostHunter
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler dhyAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler dhyAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        //也可以自己定义一个类 实现encode 和 matches 方法 使用自己的加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(dhyAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                    .loginPage("/authentication/require")
                    .loginProcessingUrl("/authentication/form")
                    .successHandler(dhyAuthenticationSuccessHandler)
                    .failureHandler(dhyAuthenticationFailureHandler)
                .and()
                .authorizeRequests()    //下面的都是授权的配置
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()//这个页面不需要授权
                .anyRequest()           //任何请求
                .authenticated()
                .and()
                .csrf().disable();       //都需要身份认证
    }
}
