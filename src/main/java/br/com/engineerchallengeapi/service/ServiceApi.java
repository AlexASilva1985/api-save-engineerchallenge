package br.com.engineerchallengeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engineerchallengeapi.model.QueryParams;
import br.com.engineerchallengeapi.repository.BusinessRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceApi {
	
	@Autowired
	private BusinessRepositoryImpl businessRepositoryImpl;
	
    public ServiceApi(
    		BusinessRepositoryImpl businessRepositoryImpl) {  
    	
		this.businessRepositoryImpl = businessRepositoryImpl;
	}	

		public void insertingMovement(QueryParams request) {
		
		try {			

			this.businessRepositoryImpl.save(request);

		} catch (Exception e) {
			log.error(e.getCause().getMessage());
		}
	}
}