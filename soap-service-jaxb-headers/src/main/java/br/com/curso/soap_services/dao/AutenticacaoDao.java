package br.com.curso.soap_services.dao;

import br.com.curso.soap_services.modelo.Autenticacao;

public interface AutenticacaoDao {
	
	boolean validaAutenticacao(Autenticacao auth);

}
