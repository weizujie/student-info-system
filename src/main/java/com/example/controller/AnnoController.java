package com.example.controller;

import com.example.enums.REnum;
import com.example.utils.Assert;
import com.example.utils.RUtil;
import com.example.utils.ShiroUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/anno")
@Slf4j
public class AnnoController {

    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> map) {

        Assert.isBlank(map.get("account"), "账号不能为空");
        Assert.isBlank(map.get("password"), "密码不能为空");


        try {
            Subject subject = ShiroUtil.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(map.get("account"), map.get("password"));
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return RUtil.error(REnum.USERNAME_OR_PASSWORD_ERROR.getCode(), REnum.USERNAME_OR_PASSWORD_ERROR.getMessage());
        } catch (DisabledAccountException e) {
            return RUtil.error(REnum.ACCOUNT_DISABLE.getCode(), REnum.ACCOUNT_DISABLE.getMessage());
        } catch (AuthenticationException e) {
            return RUtil.error(REnum.AUTH_ERROR.getCode(), REnum.AUTH_ERROR.getMessage());
        }

        return RUtil.success();
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/logout")
    public R logout() {
        ShiroUtil.logout();
        return RUtil.success();
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("/notLogin")
    public R notLogin() {
        return RUtil.error(REnum.NOT_LOGIN.getCode(), REnum.NOT_LOGIN.getMessage());
    }
}
