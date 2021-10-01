package com.example.demo.service.util;

import com.example.demo.entity.*;
import com.example.demo.repository.RolesRepository;
import com.example.demo.request.dto.GsRequest;
import com.example.demo.request.dto.MohRequest;
import com.example.demo.request.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DtoToEntityMapper {

    private static final String USER = "ROLE_USER";
    private static final String MOH = "ROLE_MOH";

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepository roleRepo;

    public User convertToUser(UserRequest user, String password) {
        Set<Roles> roles = new HashSet<>();
        Roles ROLEUSER = roleRepo.findByRoles(USER);
        roles.add(ROLEUSER);

        System.out.println(user.getUsername());
        System.out.println(password);
        return User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(passwordEncoder.encode(password))
                .nic(user.getNic())
                .roles(roles)
                .build();
    }

    public Moh convertToMoh(MohRequest moh, String password) {
        Set<Roles> roles = new HashSet<>();
        Roles ROLEMOH = roleRepo.findByRoles(MOH);
        roles.add(ROLEMOH);

        System.out.println(moh.getUsername());
        System.out.println(password);
        return Moh.builder()
                .username(moh.getUsername())
                .gsdivision(moh.getGsdivision())
                .location(moh.getLocation())
                .mohdivision(moh.getMohdivision())
                .email(moh.getEmail())
                .password(passwordEncoder.encode(password))
                .nic(moh.getNic())
                .roles(roles)
                .build();
    }
}