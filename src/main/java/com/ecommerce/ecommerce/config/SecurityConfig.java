package com.ecommerce.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour simplifier les tests (réactiver pour la production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Autoriser l'accès public à ces endpoints
                        .anyRequest().authenticated() // Protéger toutes les autres routes
                )
                .httpBasic(Customizer.withDefaults()); // Permettre l'authentification Basic pour les tests

        return http.build();
    }

}
