package com.takush.bank.config;

import com.takush.bank.entities.Role;
import com.takush.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;

    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()

                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .loginProcessingUrl("/auth")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();

//        http.authorizeRequests()
//                .antMatchers("/ws").permitAll()
//                .antMatchers("/users").hasAnyAuthority(Role.ADMIN.name(), Role.OPER.name())
//                .antMatchers("/users/new").hasAuthority(Role.ADMIN.name())
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login-error")
//                .loginProcessingUrl("/auth")
//                .permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true)
//                .and()
//                .csrf().disable();
    }
}


