package com.example.Project_3.security.filters;

import com.example.Project_3.entities.users.User;
import com.example.Project_3.security.jwt.JwtUtils;
import com.example.Project_3.security.service.CustomUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtils jwtUtils ;
    @Autowired
    private final CustomUserDetailService customUserDetailService ;



    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws  IOException, ServletException {
        final String authHeader = request.getHeader("Authorization");

        if(StringUtils.isEmpty(authHeader) || !StringUtils.startsWithIgnoreCase(authHeader,"Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        try {
             String token = jwtUtils.getTokenFromRequest(request);
//        final String userName = jwtUtils.extractUsername(token);
//        if(StringUtils.isNotEmpty(userName) && SecurityContextHolder.getContext().getAuthentication() == null){
            if(Objects.nonNull(token) && StringUtils.hasText(token) && jwtUtils.isTokenExpired(token)) {
                String userName = jwtUtils.extractUsername(token);
                User user = (User) customUserDetailService.loadUserByUsername(userName);

                if(Objects.nonNull(user)){

                    UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            user,null,user.getAuthorities());

                    passwordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);


                }
            }
        } catch (Exception ex){
            log.error("Unable to authenticate the user");
            ex.printStackTrace();
        }

        filterChain.doFilter(request,response);

    }

}
