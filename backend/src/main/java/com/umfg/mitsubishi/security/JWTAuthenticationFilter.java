package com.umfg.mitsubishi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umfg.mitsubishi.persistence.entity.Role;
import com.umfg.mitsubishi.persistence.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.umfg.mitsubishi.security.SecurityConstants.EXPIRATION_TIME;
import static com.umfg.mitsubishi.security.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
                                                                                                          AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter(
                "username"), request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        ZonedDateTime expirationTimeUTC = ZonedDateTime.now(ZoneOffset.UTC)
                                                       .plus(EXPIRATION_TIME, ChronoUnit.MILLIS);
        User user = (User) authResult.getPrincipal();
        String token = Jwts.builder()
                           .setSubject(user.getUsername())
                           .setExpiration(Date.from(expirationTimeUTC.toInstant()))
                           .signWith(SignatureAlgorithm.HS256, SECRET)
                           .compact();

        List<String> roles = user.getRoles()
                                 .stream()
                                 .map(Role::getRole)
                                 .collect(Collectors.toList());

        response.getWriter()
                .write(new ObjectMapper().writeValueAsString(new AuthorizationDTO(token, roles)));
    }
}
