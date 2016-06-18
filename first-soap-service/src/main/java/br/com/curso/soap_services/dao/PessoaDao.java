package br.com.curso.soap_services.dao;

import br.com.curso.soap_services.modelo.Pessoa;

public interface PessoaDao {
	
	Pessoa busca(String cpf);
	Boolean cadastra(Pessoa pessoa);

}
