package com.example.exception;

import com.example.enums.REnum;
import com.example.utils.RUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

    /**
     * 缺少权限异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e) {
        log.error(REnum.NOT_PERMISSION.getMessage());
        return RUtil.error(REnum.NOT_PERMISSION.getCode(), REnum.NOT_PERMISSION.getMessage());
    }
}
