package com.example.demo.response.dto;

import com.example.demo.entity.Roles;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserDto {
	
	private int userid;
	private String username;
	private String password;
	private String email;
	private String nic;
	private Set<Roles> roles;
}
