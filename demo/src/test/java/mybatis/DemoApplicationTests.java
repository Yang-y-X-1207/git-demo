package mybatis;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mybatis.mapper.userMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void jwtCreate(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "admin");
        claims.put("password", "123456");
        String jwt =Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "v8y/B?E(H+MbQeThWmZq4t7w!z%C*F-J".getBytes(StandardCharsets.UTF_8))
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 ))
                .compact();
        System.out.println(jwt);
    }

    @Test
    void jwtParse(){
        String token   = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE3NjI1MjY0OTh9.EcoTWNe1KfCmfuxby4gDXg5imlTh4z4MppVH_E2ACRE";
        Claims claims = Jwts.parserBuilder()
                .setSigningKey("v8y/B?E(H+MbQeThWmZq4t7w!z%C*F-J".getBytes(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims.get("username"));
    }
}
