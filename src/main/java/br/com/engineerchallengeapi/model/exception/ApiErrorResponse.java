package br.com.engineerchallengeapi.model.exception;

import java.util.List;

public class ApiErrorResponse {

	private String code;
	private String message;
	private String description;
	private List<ObjectError> errors;

	public ApiErrorResponse() {
	}

	public ApiErrorResponse(String code, String message, ApiErrorResponse innerApiErrorResponse) {
		this.code = code;
		this.message = message;
		ObjectError mainError = new ObjectError(innerApiErrorResponse.getCode(), innerApiErrorResponse.getMessage(),
				innerApiErrorResponse.getDescription());
		this.description = mainError.getNativeMessage();
		this.errors = innerApiErrorResponse.getErrors();
		this.errors.add(0, mainError);
	}

	public ApiErrorResponse(String code, String message, String description, List<ObjectError> errors) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.errors = errors;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiErrorResponse other = (ApiErrorResponse) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse [code=" + code + ", description=" + description + ", errors=" + errors + ", message="
				+ message + "]";
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}