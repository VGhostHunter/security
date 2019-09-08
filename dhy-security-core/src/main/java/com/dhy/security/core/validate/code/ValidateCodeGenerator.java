package com.dhy.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author VGhostHunter
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);
}
