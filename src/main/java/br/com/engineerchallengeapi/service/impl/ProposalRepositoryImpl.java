package br.com.engineerchallengeapi.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.engineerchallengeapi.entity.Proposal;
import br.com.engineerchallengeapi.model.ProposalFilter;
import br.com.engineerchallengeapi.repository.ProposalRepository;
import br.com.engineerchallengeapi.service.ApiService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProposalRepositoryImpl implements ApiService{
	
	private ProposalRepository proposalRepository;
	
    public Proposal salve(Proposal proposal){
        return proposalRepository.save(proposal);
    }
    
    public Page<Proposal> listProposal(ProposalFilter proposalFilter, Pageable pageable){
        Proposal proposal = Proposal.builder()
                .id(proposalFilter.getId())
                .nome(proposalFilter.getNome())
                .email(proposalFilter.getEmail())
                .cpf(proposalFilter.getCpf())
                .build();

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(proposal, exampleMatcher);

        return proposalRepository.findAll(example, pageable);
    }

    public Optional<Proposal> findById(Long id){
        return proposalRepository.findById(id);
    }

    public void removeById(Long id){
        proposalRepository.deleteById(id);
    }
}