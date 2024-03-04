package br.com.engineerchallengeapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.engineerchallengeapi.entity.Proposal;
import br.com.engineerchallengeapi.model.ProposalFilter;


public interface ApiService {
	
    Proposal salve(Proposal cliente);
    
    Page<Proposal> listProposal(ProposalFilter proposalFilter, Pageable pageable);

    Optional<Proposal> findById(Long id);

    void removeById(Long id);

}