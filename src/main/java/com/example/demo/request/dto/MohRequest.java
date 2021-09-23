package com.example.demo.request.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class MohRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String mohdivision;
    @NotEmpty
    private String gsdivision;
    @NotEmpty
    private String location;
    @NotEmpty
    private String nic;
}
