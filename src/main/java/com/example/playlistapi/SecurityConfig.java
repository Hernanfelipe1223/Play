package com.example.playlistapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Definir los usuarios en memoria
    @Bean
    public UserDetailsService userDetailsService() {
        var admin = User.withUsername("admin")
                .password(passwordEncoder().encode("12345"))  // Contraseña "12345"
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);  // Solo el usuario admin
    }

    // Definir el PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad usando SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF para facilitar la interacción con la API
                .authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers("/lists/**").authenticated()  // Proteger rutas que comienzan con "/lists/"
                                .anyRequest().permitAll()  // Permitir el acceso sin autenticación a otras rutas
                )
                .httpBasic(withDefaults()); // Habilitar autenticación básica de una manera correcta en Spring Security 6.

        return http.build();  // Retorna la configuración de seguridad
    }
}
