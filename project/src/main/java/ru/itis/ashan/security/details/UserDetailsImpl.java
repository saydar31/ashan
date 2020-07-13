package ru.itis.ashan.security.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.entities.user.UserModel;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    @Getter
    private UserModel userModel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authorityName = userModel.getRole().name();
        return Collections.singleton(new SimpleGrantedAuthority(authorityName));
    }

    @Override
    public String getPassword() {
        return userModel.getHashPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getMail();
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
        return userModel.getState().equals(State.CONFIRMED);
    }
}
