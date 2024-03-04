package br.com.engineerchallengeapi.repository;

import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.engineerchallengeapi.enums.QueryEnum;
import br.com.engineerchallengeapi.model.QueryParams;
import br.com.engineerchallengeapi.service.CommonService;

@Repository
public class BusinessRepositoryImpl extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(BusinessRepositoryImpl.class);

    public BusinessRepositoryImpl(
    		RestTemplate restTemplate,
    		ObjectMapper mapper,
    		JdbcTemplate jdbcTemplate) {
    	    
    	super(restTemplate, mapper, jdbcTemplate);
    	
	}

	public void save(QueryParams request) {
	    try {

			PreparedStatementCreator preparedStatementCreator = (con) -> {
				PreparedStatement ps = con.prepareStatement(QueryEnum.INSERT_QUERY.getQuery());
				
				//Incluir parâmetros
				/*
				if(movement.getDocument() != null 
						&& movement.getDocument().getOperationDocumentCode() != null) {
					ps.setString(1, movement.getDocument().getOperationDocumentCode());
				} else {
					ps.setNull(1, Types.VARCHAR);
				}
				if(movement.getDocument() != null
						&& movement.getDocument().getType() != null) {
					ps.setBigDecimal(2, movement.getDocument().getType());
				} else {
					ps.setNull(2, Types.INTEGER);
				}
				if(movement.getPreviousDocument() != null
						&& movement.getPreviousDocument().getType() != null) {
					ps.setBigDecimal(3, movement.getPreviousDocument().getType());
				} else {
					ps.setNull(3, Types.INTEGER);
				}
				if(movement.getCustomer() != null && movement.getCustomer().getDocument() != null
						&& movement.getCustomer().getDocument().getNumber() != null) {
					ps.setString(4, movement.getCustomer().getDocument().getNumber());
				} else {
					ps.setNull(4, Types.VARCHAR);
				}
				if(movement.getCustomer() != null && movement.getCustomer().getName() != null) {
					ps.setString(5, movement.getCustomer().getName());
				} else {
					ps.setNull(5, Types.VARCHAR);
				}
				ps.setBigDecimal(6, movement.getOperation().getCode());
				if(movement.getPreviousOperation() != null 
						&& movement.getPreviousOperation().getCode() != null) {
					ps.setBigDecimal(7, movement.getPreviousOperation().getCode());
				} else {
					ps.setNull(7, Types.INTEGER);
				}
				ps.setDouble(8, movement.getValue().getAmount());
				if(movement.getPreviousDocument() != null 
						&& movement.getPreviousDocument().getType() != null
						&& movement.getPreviousDocument().getOperationDocumentCode() != null) {
					ps.setString(9, movement.getPreviousDocument().getOperationDocumentCode());
				} else {
					ps.setNull(9, Types.INTEGER);
				}
				ps.setString(10, movement.getOperation().getDescription());
				if(movement.getSourceBroker() != null
						&& movement.getSourceBroker().getId() != null) {
					ps.setBigDecimal(11, movement.getSourceBroker().getId());
				} else {
					ps.setNull(11, Types.INTEGER);
				}
				ps.setDate(12, date);
				ps.setString(13, movement.getDescription());
				ps.setString(14, movement.getUserActionInformationCode());
				ps.setString(15, movement.getServiceActionInformationCode());
				ps.setString(16, CheckingAccountConstants.IC_INFORMATION_ACTION_INSERT);
				ps.setString(17, CheckingAccountConstants.IC_ACTIVE_REGISTER);
				ps.setBigDecimal(18, movement.getCreditId());
				if(movement.getBroker() != null
						&& movement.getBroker().getId() != null) {
					ps.setBigDecimal(19, movement.getBroker().getId());
				} else {
					ps.setNull(19, Types.INTEGER);
				}
				if(movement.getBroker().getBranch() != null
						&& movement.getBroker().getId() != null) {
					ps.setInt(20, branch);
				} else {
					ps.setNull(20, Types.INTEGER);
				}
				
				 */
				return ps;
			};
			
			jdbcTemplate.update(preparedStatementCreator);

		} catch (Exception e) {
			final String msgError =  " \n ERROR :: saveExtractMovement() : trying to receive a message :" + e.getCause().getMessage();
			super.sendMessageTeamsIntegration(msgError);
			log.error(" CauseMessage : " + msgError);
		}
	}
}