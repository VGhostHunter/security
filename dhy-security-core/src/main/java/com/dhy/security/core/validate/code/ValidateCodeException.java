package com.dhy.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author VGhostHunter
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 2899170762549003922L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
