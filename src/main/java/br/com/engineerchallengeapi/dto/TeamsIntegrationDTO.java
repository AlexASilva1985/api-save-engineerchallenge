package br.com.engineerchallengeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamsIntegrationDTO {
	
	private String title;
	private String text;
	private String themeColour;

}
