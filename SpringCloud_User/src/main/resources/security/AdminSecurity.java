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

@Order(1)
@EnableWebSecurity
@Configuration
public class AdminSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUserDetailService adminUserDetailService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不开启登录验证
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();

        // 以下无效
        http.antMatcher("/admin/**")
                .authorizeRequests()
                .antMatchers("/admin/home/{adminID}").access("@adminUserDetailService.checkUserID(authentication, #adminID)")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/adminloginpage")
                .loginProcessingUrl("/admin/login")
                .successHandler(new AdminAuthenticationSuccessHandler())
                .failureHandler(new AdminAuthenticationFailureHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/adminloginpage")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserDetailService).passwordEncoder(passwordEncoder2());
    }
    @Bean
    public PasswordEncoder passwordEncoder2() {
        return new BCryptPasswordEncoder();
    }

}
