package com.example.demo.service.util;

import com.example.demo.entity.*;
import com.example.demo.response.dto.*;
import org.springframework.stereotype.Component;

@Component
public class EntityToDtoMapper {

    public UserDto convertUserDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .nic(user.getNic())
                .build();
    }

    public MohDto convertMohDto(Moh moh) {
        return MohDto.builder()
                .mohid(moh.getMohid())
                .username(moh.getUsername())
                .password(moh.getPassword())
                .email(moh.getEmail())
                .nic(moh.getNic())
                .mohdivision(moh.getMohdivision())
                .location(moh.getLocation())
                .gsdivision(moh.getGsdivision())
                .build();
    }
}
