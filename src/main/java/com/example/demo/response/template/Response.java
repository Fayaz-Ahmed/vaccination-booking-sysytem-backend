package com.example.demo.response.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter                                                   
@Setter
@Builder
public class Response<T> {
	
	 private T data;
	 private com.example.demo.response.template.MetaDto meta;
	 @JsonInclude(Include.NON_NULL)
	  private ErrorDto errors;
	 
	 private static final Integer STATUS_CODE_SUCCESS = 1;
	  private static final String STATUS_SUCCESS = "Success";
	  private static final Integer STATUS_CODE_ERROR = 0;
	  private static final String STATUS_ERROR = "Error";
	  
	  
	  
	  public static <T> ResponseEntity<Response<T>> success (T data, HttpStatus status) {
		  com.example.demo.response.template.MetaDto metaDto = com.example.demo.response.template.MetaDto.builder()
				  .status(STATUS_CODE_SUCCESS)
				  .detail(STATUS_SUCCESS)
				  .build();
		  Response<T> responseDto = Response.<T>builder()
				  .data(data)
				  .meta(metaDto)
				  .build();
		  return new ResponseEntity<>(responseDto, null, status);
	  }
	  
	  public static <T> ResponseEntity<Response<T>> error(T data, String errorMsg, HttpStatus status) {
		    com.example.demo.response.template.MetaDto metaDto = com.example.demo.response.template.MetaDto.builder()
		        .status(STATUS_CODE_ERROR)
		        .detail(STATUS_ERROR)
		        .build();
		    Response<T> responseDto = Response.<T>builder()
		        .data(data)
		        .meta(metaDto)
		        .errors(new ErrorDto(ErrorDto.GENERAL_ERROR, errorMsg))
		        .build();
		    return new ResponseEntity<>(responseDto, null, status);
		  }
}
