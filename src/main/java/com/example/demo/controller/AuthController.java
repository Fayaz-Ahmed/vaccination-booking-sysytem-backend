package com.example.demo.controller;


import com.example.demo.exceptions.ChartVException;
import com.example.demo.request.dto.MohRequest;
import com.example.demo.request.dto.UserRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.dto.MohDto;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.template.Response;
import com.example.demo.service.AuthService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/signup/user")
    @ApiOperation("save new user")
    public ResponseEntity<Response<UserDto>> saveUser(@RequestBody UserRequest userRequest) throws ChartVException {
        return authService.saveUser(userRequest);
    }

    @PostMapping("/signup/moh")
    @ApiOperation("save new moh user")
    public ResponseEntity<Response<MohDto>> saveMoh(@RequestBody MohRequest mohRequest) throws ChartVException {
        return authService.saveMoh(mohRequest);
    }
}
