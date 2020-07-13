package ru.itis.ashan.security.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.repositories.UserRepository;
import ru.itis.ashan.security.details.UserDetailsImpl;

import java.util.Optional;

@Component("customUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserModel> userModelOptional = userRepository.findByMail(s);
        if (userModelOptional.isPresent()){
            UserModel model = userModelOptional.get();
            return new UserDetailsImpl(model);
        } else {
            throw new UsernameNotFoundException(s);
        }
    }
}
