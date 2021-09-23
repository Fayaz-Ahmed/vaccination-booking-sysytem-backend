package com.example.demo.request.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UserRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String email;
	@NotEmpty
	private String nic;

}
