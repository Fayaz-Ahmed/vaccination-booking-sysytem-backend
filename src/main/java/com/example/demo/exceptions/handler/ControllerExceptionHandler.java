package com.example.demo.exceptions.handler;

import com.example.demo.exceptions.ChartVException;
import com.example.demo.response.template.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({ChartVException.class})
    public ResponseEntity<Response<Object>> handlChartVException(ChartVException ex) {
        //Log.error(LOG_MESSAGE, ex);
        String message = ex.getMessage();
        //String message = ex.getCause().getMessage();
        if (message == null && ex.getCause() != null) {
            message = ex.getCause().getMessage();
        }
        return Response.error(null, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
