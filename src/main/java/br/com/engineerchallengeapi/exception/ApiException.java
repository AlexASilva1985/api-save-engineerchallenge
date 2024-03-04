package br.com.engineerchallengeapi.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.engineerchallengeapi.model.exception.ApiErrorResponse;
import br.com.engineerchallengeapi.model.exception.ObjectError;


public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ApiErrorResponse apiErrorResponse = null;

	public ApiException(Integer code, String message, String nativeMessage, Exception ex) {
		super(nativeMessage, ex);
		ex.printStackTrace();
		setApiErrorResponse(code, message);
	}

	public ApiException(Integer code, String message, String nativeMessage, ObjectError error) {
		this.apiErrorResponse = new ApiErrorResponse(String.valueOf(code), message, nativeMessage,
				Arrays.asList(error));
	}

	public ApiException(Integer code, String message, String nativeMessage, List<ObjectError> errors) {
		this.apiErrorResponse = new ApiErrorResponse(String.valueOf(code), message, nativeMessage, errors);
	}

	public ApiException(Integer code, String message, ApiErrorResponse innerErrorResponse) {
		this.apiErrorResponse = new ApiErrorResponse(String.valueOf(code), message, innerErrorResponse);
	}

	/*
	 * public ApiException(Integer code, String message, RestClientResponseException
	 * responseException) {
	 * 
	 * ApiErrorResponse apiErrorResponse =
	 * JsonUtil.deserialize(responseException.getResponseBodyAsString(),
	 * ApiErrorResponse.class);
	 * 
	 * ObjectError mainError = new ObjectError(apiErrorResponse.getCode(),
	 * apiErrorResponse.getMessage(), apiErrorResponse.getDescription());
	 * List<ObjectError> errors = apiErrorResponse.getErrors(); errors.add(0,
	 * mainError);
	 * 
	 * this.apiErrorResponse = new ApiErrorResponse(String.valueOf(code), message,
	 * mainError.getNativeMessage(), errors); }
	 */
	public ApiErrorResponse getApiErrorResponse() {
		return apiErrorResponse;
	}

	public void setApiErrorResponse(ApiErrorResponse apiErrorResponse) {
		this.apiErrorResponse = apiErrorResponse;
	}

	private void setApiErrorResponse(Integer code, String message) {

		List<ObjectError> errors = new ArrayList<>();

		StringBuilder description = new StringBuilder();
		description.append(this.getMessage() + ": ");
		for (StackTraceElement var : this.getStackTrace()) {
			description.append(var.getFileName()).append(" - ").append(var.getClassName()).append(" (")
					.append(var.getMethodName()).append(":").append(var.getLineNumber()).append(")");
		}

		errors.add(new ObjectError(String.valueOf(this.hashCode()), this.getMessage(), description.toString()));

		Throwable cause = this.getCause();
		while (cause != null) {
			StringBuilder description1 = new StringBuilder();
			description.append(this.getMessage() + ": ");
			for (StackTraceElement var : this.getStackTrace()) {
				description1.append(var.getFileName()).append(" - ").append(var.getClassName()).append(" (")
						.append(var.getMethodName()).append(":").append(var.getLineNumber()).append(")\n");
			}

			errors.add(new ObjectError(String.valueOf(cause.hashCode()), cause.getMessage(), description1.toString()));
			cause = cause.getCause();
		}

		apiErrorResponse = new ApiErrorResponse(String.valueOf(code), message, this.getMessage(), errors);
	}

}