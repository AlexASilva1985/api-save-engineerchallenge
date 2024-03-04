package br.com.engineerchallengeapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.engineerchallengeapi.dto.TeamsIntegrationDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonService {
	
	protected RestTemplate restTemplate;
	protected ObjectMapper mapper;
	protected JdbcTemplate jdbcTemplate;
	
	@Value("${teams.integration.url}")
	private String teamsIntegrationUrl;

	
	public CommonService(
			RestTemplate restTemplate, 
			ObjectMapper mapper,
			JdbcTemplate jdbcTemplate) {
		this.restTemplate = restTemplate;
		this.mapper = mapper;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	protected void sendMessageTeamsIntegration(String text) {
		
		try {
			final TeamsIntegrationDTO teamsIntegrationDTO = 
					new TeamsIntegrationDTO("Emissão da Proposta", text, "Emissao");
			
			 this.restTemplate.postForEntity(this.teamsIntegrationUrl, teamsIntegrationDTO, String.class);	
			
		} catch (Exception e) {
			 log.error("Erro na emissão da proposta", e);
		}
	}
}
