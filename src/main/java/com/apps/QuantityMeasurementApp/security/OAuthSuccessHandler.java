package com.apps.QuantityMeasurementApp.security;

import com.apps.QuantityMeasurementApp.entity.User;
import com.apps.QuantityMeasurementApp.repository.UserRepository;
import jakarta.servlet.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public OAuthSuccessHandler(UserRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String picture = user.getAttribute("picture");
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        repo.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setProvider("GOOGLE");
            return repo.save(newUser);
        });

        String token = jwtUtil.generateToken(email, name, picture);

        response.sendRedirect("http://127.0.0.1:5500/frontend/login-success.html?token=" + token);
    }
}