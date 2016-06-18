package br.com.curso.soap_services.ws;

import br.com.curso.soap_services.modelo.Autenticacao;
import br.com.curso.soap_services.modelo.Pessoa;
import br.com.curso.soap_services.modelo.Pessoas;
import br.com.curso.soap_services.ws.exception.AutenticacaoInvalidaException;

public interface PessoaWs {
	
	public Boolean cadastra(Pessoa pessoa);
	public Pessoas buscaTodas();
	Pessoa consultaPorCpf(Autenticacao auth, String cpf) throws AutenticacaoInvalidaException;

}
