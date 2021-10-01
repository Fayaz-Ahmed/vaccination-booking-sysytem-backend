package com.example.demo.service;

import com.example.demo.exceptions.ChartVException;
import com.example.demo.request.dto.MohRequest;
import com.example.demo.request.dto.UserRequest;
import com.example.demo.response.dto.MohDto;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.template.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    ResponseEntity<Response<UserDto>> saveUser(UserRequest userRequest) throws ChartVException;

    ResponseEntity<Response<MohDto>> saveMoh(MohRequest mohRequest) throws ChartVException;
}
