package com.kilic.hrproject.Configuration;

import com.kilic.hrproject.Security.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     private final MemberDetailService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/register","/register/**","/","/apply","/job").permitAll().and().
                authorizeRequests().antMatchers("/profile","/update").hasRole("USER").and().
               authorizeRequests().antMatchers("/create","/save").hasRole("ADMIN").and()
                .formLogin().
        loginPage("/login").loginProcessingUrl("/access").usernameParameter("email").
            passwordParameter("password").permitAll().and().logout().permitAll();
    }


     @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
