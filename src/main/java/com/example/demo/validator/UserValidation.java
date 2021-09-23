package com.example.demo.validator;

import com.example.demo.entity.User;
import com.example.demo.exceptions.ChartVDataValidationException;
import com.example.demo.exceptions.ChartVException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
	@Autowired
	private UserRepository userRepository;
	
	public static final String USER ="ROLE_USER";
	public static final String ADMIN ="ROLE_ADMIN";

	public void validateUser(String username)throws ChartVException {
		boolean valid = userRepository.existsByUsername(username);
		System.out.println("test username :" + valid);
		if (valid) {
			throw new ChartVDataValidationException("Username Already Exists ", username);
		}
	}
	
	public void validateUserEmail(String email)throws ChartVException {
		boolean valid = userRepository.existsByEmail(email);
		System.out.println("test email: "+valid);
		if (valid) {
			throw new ChartVDataValidationException("Email Already Exists ", email);
		}
	}

	public void validateUserNic(String nic)throws ChartVException {
		boolean valid = userRepository.existsByNic(nic);
		System.out.println("test nic: "+valid);
		if (valid) {
			throw new ChartVDataValidationException("NIC Already Exists ", nic);
		}
	}
	public void validateUsername(String username)throws ChartVException {
		boolean valid = userRepository.existsByUsername(username);
		System.out.println("test username :" + valid);
		if (!valid) {
			throw new ChartVDataValidationException("Username Not Found ", username);
		}
	}

	public void validateUserRole(String role)throws ChartVException {
		if(false == USER.equals(role) && false == ADMIN.equals(role)) {
			throw new ChartVDataValidationException("User role should be "+ USER + " or " + ADMIN);
		}
		
	}

}
