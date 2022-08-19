package com.company.microservice3gateway.controller;

import com.company.microservice3gateway.dto.CreateUserRequest;
import com.company.microservice3gateway.dto.SignInRequest;
import com.company.microservice3gateway.dto.UserDto;
import com.company.microservice3gateway.service.AuthenticationService;
import com.company.microservice3gateway.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<UserDto> signUp(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest user){
        return new ResponseEntity<>(authenticationService.singInAndReturnJWT(user), HttpStatus.OK);
    }
}
