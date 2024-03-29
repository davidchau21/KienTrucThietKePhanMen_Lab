package com.example.springboot_api_jwt_ad.filter;

import com.example.springboot_api_jwt_ad.authen.UserPrincipal;
import com.example.springboot_api_jwt_ad.entity.Token;
import com.example.springboot_api_jwt_ad.service.TokenService;
import com.example.springboot_api_jwt_ad.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService verificationTokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        UserPrincipal user = null;
        Token token = null;

        if(StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Token")){
            String jwt = authorizationHeader.substring(6);

            user = jwtUtil.getUserFromToken(jwt);
            token = verificationTokenService.findByToken(jwt);
        }

        if(null != user && null != token && token.getTokenExpDate().after(new Date())){
            Set<GrantedAuthority> authorities = new HashSet<>();

            user.getAuthorities().forEach(
                    p -> authorities.add(new SimpleGrantedAuthority((String) p)));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
