package br.com.engineerchallengeapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.engineerchallengeapi.entity.Proposal;
import br.com.engineerchallengeapi.model.ProposalFilter;
import br.com.engineerchallengeapi.service.impl.ProposalRepositoryImpl;

@RestController
@RequestMapping("/proposal")
public class ApiController {
	
		@Autowired
	    private ProposalRepositoryImpl proposalRepositoryImpl;
		
		@Autowired
	    private ModelMapper modelMapper;

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Proposal salvar(@RequestBody Proposal proposal){
	        return proposalRepositoryImpl.salve(proposal);
	    }
	    
	    @GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public Page<Proposal> listProposal(ProposalFilter clienteFiltro, Pageable pageable){
	        return proposalRepositoryImpl.listProposal(clienteFiltro, pageable);
	    }

	    @GetMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public Proposal buscarClientePorId(@PathVariable("id") Long id){
	        return proposalRepositoryImpl.findById(id)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
	    }

	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void removerCliente(@PathVariable("id") Long id){
	        proposalRepositoryImpl.findById(id)
	                .map(cliente -> {
	                    proposalRepositoryImpl.removeById(cliente.getId());
	                    return Void.TYPE;
	                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
	    }

	    @PutMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void atualizarCliente(@PathVariable("id") Long id, @RequestBody Proposal cliente){
	        proposalRepositoryImpl.findById(id)
	                .map(clienteBase -> {
	                    modelMapper.map(cliente, clienteBase);
	                    proposalRepositoryImpl.salve(clienteBase);
	                    return Void.TYPE;
	                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
	    }
}
