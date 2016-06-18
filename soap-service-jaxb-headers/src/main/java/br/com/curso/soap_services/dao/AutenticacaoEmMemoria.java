package br.com.curso.soap_services.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.soap_services.modelo.Autenticacao;


public class AutenticacaoEmMemoria implements AutenticacaoDao{

	private static List<Autenticacao> autenticacoes;
	
	static {
		autenticacoes = new ArrayList<Autenticacao>();
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.setUser("username");
		autenticacao.setPass("123mudar");
		autenticacoes.add(autenticacao);
	}
	
	
	@Override
	public boolean validaAutenticacao(Autenticacao auth) {
		return autenticacoes.stream()
					 .filter(c -> c.getUser().equals(auth.getUser()) && 
							 c.getPass().equals(auth.getPass()))
					 .findAny()
					 .isPresent();
	}

}
