package com.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @Author: weizujie
 * @Date: 2020/8/21
 * @Github: https://github.com/weizujie
 */
public class JWTUtil {

    private static final String SING = "!Q@W3e4R%^&";

    /**
     * 生成 token
     *
     * @param map
     * @return
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); // 默认7天不过期

        // 创建 jwt builder
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())  // 指定token过期时间
                .sign(Algorithm.HMAC256(SING)); // sing

        return token;
    }

    /**
     * 验证 token 合法性
     *
     * @param token
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }
}