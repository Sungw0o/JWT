package com.wayback.loginsystem;

import com.wayback.loginsystem.dto.LoginRequest;
import com.wayback.loginsystem.dto.SignupRequest;
import com.wayback.loginsystem.dto.TokenRequest;
import com.wayback.loginsystem.entity.Account;
import com.wayback.loginsystem.entity.Authority;
import com.wayback.loginsystem.entity.RefreshToken;
import com.wayback.loginsystem.jwt.JwtTokenProvider;
import com.wayback.loginsystem.repository.AccountRepository;
import com.wayback.loginsystem.repository.RefreshTokenRepository;
import com.wayback.loginsystem.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void SignUpTest() {
        //given
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUserid("ghdrlfehd");
        signupRequest.setName("홍길동");
        signupRequest.setPassword("1234");
        signupRequest.setEmail("ghdrlfehd@naver.com");
        signupRequest.setNickname("길동");
        //when
        authService.signup(signupRequest);
        System.out.println("Signup success" + signupRequest);
        //then

        assertThat(signupRequest.getUserid()).isEqualTo("ghdrlfehd");
        assertThat(signupRequest.getNickname()).isEqualTo("길동");



    }

    @Test
    @DisplayName("로그인 테스트")
    public void LoginTest() {

    }

    @Test
    public void ReissueTest(){

    }

}
