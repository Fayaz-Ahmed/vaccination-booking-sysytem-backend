package com.example.demo.util;

import com.example.demo.exceptions.ChartVException;

public interface EmailUtil {
	void sendEmail(String ToAddress,String subject,String body)throws  ChartVException;
}
