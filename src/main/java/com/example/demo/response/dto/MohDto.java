package com.example.demo.response.dto;


import com.example.demo.entity.Roles;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class MohDto {
	
	private int mohid;
	private String username;
	private String password;
	private String email;
	private String nic;
	private Set<Roles> roles;
	private String location;
	private String gsdivision;
	private String mohdivision;
}
