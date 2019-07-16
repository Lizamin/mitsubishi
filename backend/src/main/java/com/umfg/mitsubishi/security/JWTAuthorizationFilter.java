package com.umfg.mitsubishi.security;

import com.umfg.mitsubishi.service.MitsubishiUserDetailsService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.umfg.mitsubishi.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final MitsubishiUserDetailsService mitsubishiUserDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  MitsubishiUserDetailsService mitsubishiUserDetailsService) {
        super(authenticationManager);
        this.mitsubishiUserDetailsService = mitsubishiUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);
        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuth = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuth);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request){
        String token = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "");
        String username = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody().getSubject();
        UserDetails userDetails = mitsubishiUserDetailsService.loadUserByUsername(username);
        return userDetails != null
                ? new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities())
                : null;
    }
}
