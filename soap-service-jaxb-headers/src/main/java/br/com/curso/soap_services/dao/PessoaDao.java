package br.com.curso.soap_services.dao;

import java.util.List;

import br.com.curso.soap_services.modelo.Pessoa;

public interface PessoaDao {
	
	Pessoa busca(String cpf);
	Boolean cadastra(Pessoa pessoa);
	List<Pessoa> buscaTodas();

}
