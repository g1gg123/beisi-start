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

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    // 硬编码
    private String username = "admin";
    private String password = "123456";

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        // 验证用户名和密码
        if (!loginRequest.getUsername().equals(username) || !loginRequest.getPassword().equals(password)) {
            return Result.error();
        }
        LoginResponse loginResponse = loginService.login(loginRequest);
        if (loginResponse != null) {
            return Result.success(loginResponse);
        }
        return Result.error();
    }

}