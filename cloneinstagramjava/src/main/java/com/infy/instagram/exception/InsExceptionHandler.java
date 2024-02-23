package com.infy.instagram.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infy.instagram.dto.InsResponseCode;
import com.infy.instagram.dto.InsResponseEntity;

import java.util.Date;

@RestControllerAdvice
public class InsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> illegalArgumentException(Exception ex) {
		String exceptionMessageDesc = ex.getLocalizedMessage();
		if (exceptionMessageDesc == null)
			exceptionMessageDesc = ex.toString();

		InsErrorMessage errorMessage = new InsErrorMessage(new Date(), exceptionMessageDesc, null);
		return InsResponseEntity.response(InsResponseCode.BAD_REQUEST.getCode(),
				InsResponseCode.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST, errorMessage);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> generalException(Exception ex) {
		String exceptionMessageDesc = ex.getLocalizedMessage();
		if (exceptionMessageDesc == null)
			exceptionMessageDesc = ex.toString();

		InsErrorMessage errorMessage = new InsErrorMessage(new Date(), exceptionMessageDesc, null);
		return InsResponseEntity.response(InsResponseCode.SYSTEM_ERROR.getCode(),
				InsResponseCode.SYSTEM_ERROR.getMessage(), HttpStatus.BAD_REQUEST, errorMessage);
	}
}
