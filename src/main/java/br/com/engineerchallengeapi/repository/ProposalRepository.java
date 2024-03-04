package br.com.engineerchallengeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.engineerchallengeapi.entity.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long>{

}