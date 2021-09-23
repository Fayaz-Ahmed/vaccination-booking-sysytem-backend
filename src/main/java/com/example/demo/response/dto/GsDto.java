package com.example.demo.response.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GsDto {
    private int gsid;
    private String username;
    private String password;
    private String email;
    private String gsdivision;
    private String location;
    private String NIC;
}
