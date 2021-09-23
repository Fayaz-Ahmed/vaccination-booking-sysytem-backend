package com.example.demo.response.dto;


import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class MohDto {
	
	private int mohid;
	private String username;
	private String password;
	private String email;
	private String nic;
	private String location;
	private String gsdivision;
	private String mohdivision;
}
