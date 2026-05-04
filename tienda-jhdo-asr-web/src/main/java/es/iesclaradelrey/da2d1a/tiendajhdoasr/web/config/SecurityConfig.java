package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        var admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Recursos estáticos de Spring Boot (css, js, images, webjars...)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // Recursos estáticos propios
                .requestMatchers("/imagenes/**", "/css/**", "/js/**", "/webjars/**").permitAll()
                // Consola H2
                .requestMatchers("/h2-console/**").permitAll()
                // Login siempre público — ANTES de la regla /admin/**
                .requestMatchers("/admin/login").permitAll()
                // Todo lo demás bajo /admin requiere ADMIN
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // Toda la tienda pública
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin", true)
                .failureUrl("/admin/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            .headers(headers -> headers
                .frameOptions(fo -> fo.sameOrigin())
            );

        return http.build();
    }
}
