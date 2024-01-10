package org.demointernetshop.services.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.demointernetshop.services.exceptions.InvalidJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.lifetime}")
    private long jwtLifeTime;

    public String createToken(String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtLifeTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }


    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            // Invalid JWT signature
            throw new InvalidJwtException("Invalid JWT signature");
        } catch (MalformedJwtException e){
            // Invalid JWT token
            throw new InvalidJwtException("Invalid JWT token");
        } catch (UnsupportedJwtException e){
            // Unsupported JWT token
            throw new InvalidJwtException("Unsupported JWT token");
        } catch (ExpiredJwtException e){
            // ExpiredJwtException JWT token
            throw new InvalidJwtException("Expired JWT token");
        } catch (IllegalArgumentException e){
            // JWT claims string is empty
            throw new IllegalArgumentException("JWT claims string is empty");
        }
    }

}
