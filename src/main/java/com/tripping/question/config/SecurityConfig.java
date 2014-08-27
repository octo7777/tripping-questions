package com.tripping.question.config;

import com.tripping.question.core.services.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

  @Override
  protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
      daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImplementation);

      auth.authenticationProvider(daoAuthenticationProvider);

//    auth.inMemoryAuthentication()
//        .withUser("Bolek").password("pass").roles("USER").and()
//            .withUser("Lolek").password("pass").roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeUrls()
        .anyRequest().anonymous()
        .and()
        .httpBasic();
  }
}
