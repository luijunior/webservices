package br.com.curso.rest_service_tomcat.dao;

import br.com.curso.rest_service_tomcat.modelo.Pessoa;

public interface PessoaDao {
	
	Pessoa busca(String cpf);
	Boolean cadastra(Pessoa pessoa);

}
