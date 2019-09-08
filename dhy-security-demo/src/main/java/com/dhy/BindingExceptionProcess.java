package com.dhy;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BindingExceptionProcess {

    /**
     * 用来处理没有加@RequestBody的binding
     * @param e e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object validExceptionHandler(BindException e) {
        StringBuilder s = new StringBuilder();
        e.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(msg -> {
                    s.append(msg).append(";");
                    log.info(msg);
                });

        return s.toString();
    }

    /**
     * 用来处理加了@RequestBody的binding
     * @param e e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder s = new StringBuilder();
        e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(msg -> {
                    s.append(msg).append(";");
                    log.info(msg);
                });

        return s.toString();
    }
}
