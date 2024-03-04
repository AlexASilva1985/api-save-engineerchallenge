package br.com.engineerchallengeapi.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Header {
	
	private final String xCompanyId;
	private final String xApplicationId;
	private final String xUserId;
	private final String xTraceId;

	public HttpHeaders generateHttpHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("X-Company-Id", this.getXCompanyId());
		httpHeaders.set("X-Application-Id", this.getXApplicationId());
		httpHeaders.set("X-User-Id", this.getXUserId());
		httpHeaders.set("X-Trace-Id", this.getXTraceId());
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return httpHeaders;
	}
}
