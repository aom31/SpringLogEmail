package com.example.securityemailverify.registration;

import com.example.securityemailverify.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;

    @RequestMapping("/api/registration/confirm?token=")
    public String homeDisplay() throws Exception{
        return "index.html";
    }

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request){
        return  registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

}
