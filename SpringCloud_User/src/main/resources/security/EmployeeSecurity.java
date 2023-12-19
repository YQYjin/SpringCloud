package com.example.distributedhomework2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(2)
@EnableWebSecurity
@Configuration
public class EmployeeSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeUserDetailSerivce employeeUserDetailSerivce;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/employee/**")

                .authorizeRequests()

                .antMatchers("/employee/home/{userID}").access("@employeeUserDetailSerivce.checkUserID(authentication, #userID)")
                .antMatchers("/employee/info/{userID}").access("@employeeUserDetailSerivce.checkUserID(authentication, #userID)")
                .antMatchers("/employee/addorder/{userID}").access("@employeeUserDetailSerivce.checkUserID(authentication, #userID)")
                .antMatchers("/employee/**").hasRole("USER")

                .and()
                .formLogin()
                .loginPage("/loginpage")
                .loginProcessingUrl("/employee/login")
                .successHandler(new CustomAuthenticationSuccessHandler())
                .failureHandler(new CustomAuthenticationFailureHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/employee/logout")
                .logoutSuccessUrl("/loginpage")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .csrf().disable();

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeUserDetailSerivce).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
