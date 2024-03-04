package br.com.engineerchallengeapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QueryEnum {
	

		INSERT_QUERY(1, 
				"INSERT INTO corporativo.\"tbGTCExtrato\" " + 
				"( " + 
				"    \"idGTCExtrato\",   " + 
				"    \"cdDocumentoOperacao\",   " + 
				"    \"cdTransacao\",   " + 
				"    \"cdTransacaoAnterior\",   " + 
				"    \"nrCpfCgcCliente\",   " + 
				"    \"nmCliente\",   " + 
				"    \"cdOperacao\",   " + 
				"    \"cdOperacaoAnterior\",   " + 
				"    \"vlTransacao\",   " + 
				"    \"cdDocumentoAnterior\",   " + 
				"    \"dsMovimentacao\",   " + 
				"    \"sqPessoaOrigem\",   " + 
				"    \"dtMovimentacao\",   " + 
				"    \"dsObservacao\",   " + 
				"    \"cdUsuarioAcaoInformacao\",   " + 
				"    \"cdServicoAcaoInformacao\",   " + 
				"    \"dtAcaoInformacao\",   " + 
				"    \"icAcaoInformacao\",   " + 
				"    \"icRegistroAtivo\",   " + 
				"    \"idGtcCredito\",   " + 
				"    sq_pessoa,   " + 
				"    sq_sucursal   " + 
				") " + 
				"VALUES " + 
				"(   ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    now(),   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?,   " + 
				"    ?   " + 
				")")
		;
		
		Integer id;
		String query;
}