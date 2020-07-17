package ru.itis.ashan.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.signIn.SignInDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.repositories.UserRepository;
import ru.itis.ashan.services.SignInRestService;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignInRestService restService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<UserModel> userModelOptional = userRepository.findUserModelByMail(mail);
        if (userModelOptional.isPresent()){
            UserModel userModel = userModelOptional.get();
            userModel.setToken(restService.signInWithHashPassword(
                    new SignInDto(userModel.getMail(), userModel.getHashPassword())).getToken());

            return new UserDetailsImpl(userModel);
        }
        throw new UsernameNotFoundException("user not found");
    }
}
