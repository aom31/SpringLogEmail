package com.example.securityemailverify.appuser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private  final static String USER_NOT_FOUND_MSG = "user with this email %s not found";

    private final AppUserRepository appUserRepository;

    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String singUpUser(AppUser appUser){
        //check user exist
        boolean userExist =  appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if ( userExist){
            throw  new IllegalStateException("email already have!!! ");
        }
        String encoderPassword =  bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encoderPassword);
        appUserRepository.save(appUser);
        //send confirtmation token

        return "it work";
    }
}
