package br.com.engineerchallengeapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.engineerchallengeapi.model.QueryParams;
import br.com.engineerchallengeapi.service.ServiceApi;

@RestController
public class ApiController {

	@Autowired	
	ServiceApi service;

	@RequestMapping(method = RequestMethod.GET, value = "/save/proposal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> postCheckingAccount(
	    		@Valid @RequestBody QueryParams request){
		        
		    	service.insertingMovement(request);
		    	
		    	return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
