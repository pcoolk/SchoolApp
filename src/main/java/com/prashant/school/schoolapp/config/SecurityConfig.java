package com.prashant.school.schoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilter(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/holiday","/saveMsg","/assets/**").permitAll()
                        .requestMatchers("/","/home").authenticated()
                        .requestMatchers("/contact").authenticated()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(("admin"))
                .password("12345")
                .roles("user")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("admin")
                .build();
    return new InMemoryUserDetailsManager(user, admin);
    }

}
