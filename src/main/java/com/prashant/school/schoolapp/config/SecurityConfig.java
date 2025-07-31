package com.prashant.school.schoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/","/home","/holiday","/saveMsg","/assets/**").permitAll()
                        .requestMatchers("/contact").authenticated()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
