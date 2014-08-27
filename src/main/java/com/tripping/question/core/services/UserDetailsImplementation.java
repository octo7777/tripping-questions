package com.tripping.question.core.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by krzysztofsa on 8/27/14.
 */

public class UserDetailsImplementation implements UserDetails {
    private String username, password;
    private Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

    public UserDetailsImplementation(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
