package com.ecommerce.security;

import com.ecommerce.dto.request.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtService {

    final String PEM_START = "-----BEGIN PRIVATE KEY-----";
    final String PEM_END = "-----END PRIVATE KEY-----";
    private static final String secretKey = "test";

    public String createToken(LoginRequest loginRequest) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("/privatekey.pem");
        InputStream is = resource.getInputStream();
        return Jwts.builder()
                .setSubject(loginRequest.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 23500))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
