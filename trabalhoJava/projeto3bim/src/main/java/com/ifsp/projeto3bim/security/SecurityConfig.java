package com.ifsp.projeto3bim.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desabilita CSRF para facilitar testes (em produção rever)
            .authorizeHttpRequests(auth -> auth
                // libera páginas públicas/recursos
                .requestMatchers("/css/**", "/js/**", "/images/**", "/registrar", "/login", "/logout").permitAll()
                // permite todo o resto (você controla acesso via sessão dentro dos controllers)
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
