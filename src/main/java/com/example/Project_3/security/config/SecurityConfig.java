package com.example.Project_3.security.config;


import com.example.Project_3.enums.role.RoleEnum;
import com.example.Project_3.security.constants.SecurityConstantPath;
import com.example.Project_3.security.exceptionHandlers.AuthEntryPoint;
import com.example.Project_3.security.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.stereotype.Component;



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
         http.csrf().disable()
                 .authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/department/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/user/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/userRole/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/drugGroup/**").permitAll()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/drug/**").authenticated()
                 .and()
                 .authorizeHttpRequests().requestMatchers("/swagger-ui/**").permitAll()
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
