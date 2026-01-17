package com.beisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beisi.common.Result;
import com.beisi.dto.LoginRequest;
import com.beisi.dto.LoginResponse;
import com.beisi.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.login(loginRequest);
        if (loginResponse != null) {
            return Result.success(loginResponse);
        }
        return Result.error();
    }

}