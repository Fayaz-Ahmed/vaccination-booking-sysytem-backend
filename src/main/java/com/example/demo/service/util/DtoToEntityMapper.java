package com.example.demo.service.util;

import com.example.demo.entity.Gs;
import com.example.demo.entity.Moh;
import com.example.demo.entity.User;
import com.example.demo.request.dto.GsRequest;
import com.example.demo.request.dto.MohRequest;
import com.example.demo.request.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User convertToUser(UserRequest user, String password) {
        System.out.println(user.getUsername());
        System.out.println(password);
        return User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(passwordEncoder.encode(password))
                .nic(user.getNic())
                .build();
    }

//    public Moh convertToMoh(MohRequest moh, String password) {
//        System.out.println(moh.getUsername());
//        System.out.println(password);
//        return Moh.builder()
//                .username(moh.getUsername())
//                .gsdivision(moh.getGsdivision())
//                .location(moh.getLocation())
//                .mohdivision(moh.getMohdivision())
//                .email(moh.getEmail())
//                .password(passwordEncoder.encode(password))
//                .nic(moh.getNic())
//                .build();
//    }
//
//    public Gs convertToGs(GsRequest gs, String password) {
//        System.out.println(gs.getUsername());
//        System.out.println(password);
//        return Gs.builder()
//                .username(gs.getUsername())
//                .email(gs.getEmail())
//                .gsdivision(gs.getDivision())
//                .build();
//    }
}
