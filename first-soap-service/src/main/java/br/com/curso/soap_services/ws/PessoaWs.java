package br.com.curso.soap_services.ws;

import br.com.curso.soap_services.modelo.Pessoa;

public interface PessoaWs {
	
	public Pessoa consultaPorCpf(String cpf);
	public Boolean cadastra(Pessoa pessoa);

}
