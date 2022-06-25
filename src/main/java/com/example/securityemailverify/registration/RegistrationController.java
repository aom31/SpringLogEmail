package com.example.securityemailverify.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request){
        return  registrationService.register(request);
    }


}
