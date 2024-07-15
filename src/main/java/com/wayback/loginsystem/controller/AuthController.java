package com.wayback.loginsystem.controller;

import com.wayback.loginsystem.dto.LoginRequest;
import com.wayback.loginsystem.dto.ReissueRequest;
import com.wayback.loginsystem.dto.SignupRequest;
import com.wayback.loginsystem.dto.TokenRequest;
import com.wayback.loginsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/home")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenRequest> login(@RequestBody LoginRequest request) {
        TokenRequest token = authService.login(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenRequest> reissue(@RequestBody ReissueRequest request) {
        return ResponseEntity.ok(authService.reissue(request));
    }


}