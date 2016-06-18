package br.com.curso.simple_servlet.dao;

import java.util.List;

import br.com.curso.simple_servlet.modelo.Pessoa;

public interface PessoaDao {
	
	Pessoa busca(String cpf);
	Boolean cadastra(Pessoa pessoa);
	List<Pessoa> listaTodas();

}
