package com.sahil.dahe.hospitalManegment.Controller;

import com.sahil.dahe.hospitalManegment.dto.AuthResponse;
import com.sahil.dahe.hospitalManegment.dto.LoginRequest;
import com.sahil.dahe.hospitalManegment.dto.RegisterRequest;
import com.sahil.dahe.hospitalManegment.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request){

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request){

        return authService.login(request);
    }

}
