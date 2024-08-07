package com.example.Project_3.security.config;


import com.example.Project_3.enums.role.RoleEnum;
import com.example.Project_3.security.constants.SecurityConstantPath;
import com.example.Project_3.security.exceptionHandlers.AuthEntryPoint;
import com.example.Project_3.security.filters.JwtAuthenticationFilter;
import com.example.Project_3.security.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@Component
@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = true , jsr250Enabled = true)
public class SecurityConfig  {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private AuthEntryPoint authEntryPoint;






     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.csrf().disable().cors().and()
                 .authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/department/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/api/user/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/api/role/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/api/drug-group/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/api/drug/**").authenticated()
                 .and().authorizeHttpRequests().requestMatchers("/api/import-receipt/**").authenticated()
                 .and().authorizeHttpRequests().requestMatchers("/api/request-receipt/**").authenticated()
                 .and() .authorizeHttpRequests().requestMatchers("/api/inventory/**").authenticated()
                 .and().authorizeHttpRequests().requestMatchers("/api/statistics/**").authenticated()
                 .and().authorizeHttpRequests().requestMatchers("/swagger-ui/**").permitAll()
                 .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                 .anyRequest().permitAll()
                 .and()
                 .exceptionHandling()
                 .authenticationEntryPoint(authEntryPoint)
                 .and()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
                 .authenticationProvider(authenticationProvider)
                 .addFilterBefore( jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
         return http.build();
     }


}
