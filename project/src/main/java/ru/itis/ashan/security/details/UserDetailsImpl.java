package ru.itis.ashan.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.ashan.entities.user.UserModel;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private UserModel user;

    public UserDetailsImpl(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = user.getRole().toString();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        return Collections.singleton(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getMail();
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
        return user.isEmailIsConfirmed();
    }
}
