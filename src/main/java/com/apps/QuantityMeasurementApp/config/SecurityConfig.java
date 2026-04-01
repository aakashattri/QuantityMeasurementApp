package com.apps.QuantityMeasurementApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apps.QuantityMeasurementApp.security.JwtAuthFilter;
import com.apps.QuantityMeasurementApp.security.OAuthSuccessHandler;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final OAuthSuccessHandler successHandler;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(OAuthSuccessHandler successHandler,
                          JwtAuthFilter jwtAuthFilter) {
        this.successHandler = successHandler;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/oauth2/**").permitAll()
                .requestMatchers("/quantity/**").authenticated()
                .anyRequest().permitAll()
            )

            .oauth2Login(oauth -> oauth
                .successHandler(successHandler)
            )

            // 🔥 VERY IMPORTANT
            .addFilterBefore(jwtAuthFilter,
                    UsernamePasswordAuthenticationFilter.class)

            // 🔥 PREVENT REDIRECT TO GOOGLE
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((req, res, e) ->
                        res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            );

        return http.build();
    }
}