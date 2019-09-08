package com.dhy.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author VGhostHunter
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
