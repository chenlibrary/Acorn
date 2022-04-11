package com.www.acorn.tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * token生成工具类
 */
@Component
public class JwtUtils {

    // 过期时间
    private static long expire = 604800;
    // 秘钥 HSyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9
    private static String secret = "HSyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1CjH9";

    /**
     * 创建一个token
     *
     * @param userId
     * @return
     */
    public String generateToken(String userId) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expire);
        return Jwts.builder().setHeaderParam("type", "JWT").setSubject(userId).setIssuedAt(now)
                .setExpiration(expireDate).signWith(
                        SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 解析token
     */
    public Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            System.out.println("validate is token error");
            return null;
        }
    }

    /**
     * 判断 token 是否过期
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }

}

