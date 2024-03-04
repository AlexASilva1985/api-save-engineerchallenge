package br.com.engineerchallengeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposalFilter {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
