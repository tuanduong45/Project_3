package com.example.Project_3.security.jwt;

import com.example.Project_3.entities.role.Role;
import com.example.Project_3.entities.users.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.function.Function;


@Component
@Getter
@Slf4j
public class JwtUtils {

   @Value("${jwt.secretKey}")
   private String SECRET_KEY;
   @Value("${jwt.duration}")
   private Long DURATION ;

    public String generateJwt(User user ) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",user.getUserName());
        return Jwts.builder().subject(user.getUserName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * DURATION))
                .signWith(SignatureAlgorithm.HS256, getSignKey())
                .compact();

    }
    private Key getSignKey(){
        byte[] keys = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keys);
    }

    public Boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) /*&& !isTokenExpired(token) )*/;

    }

    public String extractUsername(String token) {
        try {
            return extractClaims(token, Claims::getSubject);
        } catch (Exception e) {
            log.error("Get username from token error");
            e.printStackTrace();
            return null;
        }

    }


    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).after(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            log.error("Get claims from jwt error");
            ex.printStackTrace();
            return null;
        }
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        return authHeader.substring(7);

    }


    public String generateRefreshToken(Map<String, Object> extractClaims, User user) {
        return Jwts.builder().claims(extractClaims).subject(user.getUserName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * DURATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
