package br.com.engineerchallengeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import br.com.engineerchallengeapi.model.exception.ApiErrorResponse;



@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
		return new ResponseEntity<ApiErrorResponse>(ex.getApiErrorResponse(),
				HttpStatus.valueOf(Integer.parseInt(ex.getApiErrorResponse().getCode())));
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiErrorResponse> handleApiException(Exception ex) {
		ApiException apiException = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(),
				ex.getLocalizedMessage(), ex);

		return new ResponseEntity<ApiErrorResponse>(apiException.getApiErrorResponse(),
				HttpStatus.valueOf(Integer.parseInt(apiException.getApiErrorResponse().getCode())));
	}
	
	@ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<ApiErrorResponse> handleApiException(ResponseStatusException ex) {
		ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
				ex.getLocalizedMessage(), ex);

		return new ResponseEntity<ApiErrorResponse>(apiException.getApiErrorResponse(),
				HttpStatus.valueOf(Integer.parseInt(apiException.getApiErrorResponse().getCode())));
	}
		
}
