package com.bandlanguage.bandlanguagesite.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类，生成JWT和认证
 *
 * @author xiaov
 * @since 2021-05-22 10:11
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "bandlanguagesite.jwt")
public class JwtUtil {

    /**
     * 密钥
     */
    private String secret;

    /**
     * 过期时间
     */
    private long expire;

    /**
     * 请求头
     */
    private String header;

    /**
     * 过期时间
     *
     * @param userId 用户ID
     * @return token字符串
     */
    public String createToken(long userId) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000);

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS512");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)    // 添加头部
                .withClaim("id", userId) // //可以将基本信息放到claims中
                .withExpiresAt(expireDate)  //超时设置,设置过期的日期
                .withIssuedAt(new Date())   //签发时间
                .sign(Algorithm.HMAC512(secret));   //SECRET加密
        return token;
    }

    /**
     * 校验token并解析token
     *
     * @param token token字符串
     * @return 关于Claim的map
     */
    public Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt;

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.debug("validate is token error ", e);
            //解码异常则抛出异常
            return null;
        }
        return jwt.getClaims();
    }
}
