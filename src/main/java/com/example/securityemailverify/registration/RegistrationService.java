package com.example.securityemailverify.registration;

import com.example.securityemailverify.appuser.AppUser;
import com.example.securityemailverify.appuser.AppUserRole;
import com.example.securityemailverify.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidateEmail = emailValidator.test(request.getEmail());
        if(!isValidateEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.singUpUser( new AppUser( request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(), AppUserRole.USER));
    }
}
