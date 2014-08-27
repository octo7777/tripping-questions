package com.tripping.question.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.tripping.question.core.domain.User;
import com.tripping.question.core.repository.UserRepository;
import com.tripping.question.core.services.UserDetailsServiceImplementation;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(new User("Bolek", "bolek@tripper.com", "pass", Roles.ADMIN));
        }
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImplementation);
        //daoAuthenticationProvider.setPasswordEncoder(new StandardPasswordEncoder());

        auth.authenticationProvider(daoAuthenticationProvider);

//    auth.inMemoryAuthentication()
//        .withUser("Bolek").password("pass").roles("USER").and()
//            .withUser("Lolek").password("pass").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeUrls()
            .antMatchers("/protected.html").hasAuthority(Roles.ADMIN)
            .anyRequest().permitAll()
            .and()
            .formLogin().failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                AuthenticationException exception) throws IOException, ServletException {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not logged in");
            }
        }).successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {
                response.sendError(HttpServletResponse.SC_OK);
            }
        });
    }
}
