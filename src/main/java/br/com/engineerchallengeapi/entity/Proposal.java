package br.com.engineerchallengeapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Proposal {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @Column(name = "nome")
	    private String nome;
	    
	    @Column(name = "cpf")
	    private String cpf;
	    
	    @Column(name = "propostaId")
	    private Long proposalId;
	
	    @Column(name = "cotizacionId")
	    private Long quotationId;
	
	    @Column(name = "datadaProposta")
	    private String proposalDate;
	
	    @Column(name = "idProduto")
	    private Long productId;
	
	    @Column(name = "nacionalidade")
	    private String nationality;
	
	    @Column(name = "cidade")
	    private String city;
	
	    @Column(name = "cep")
	    private Long zipCode;
	
	    @Column(name = "endereco")
	    private String address;
	
	    @Column(name = "enderecoNumero")
	    private String addressNumber;
	
	    @Column(name = "celular")
	    private String cellPhone;
	
	    @Column(name = "email")
	    private String email;
}