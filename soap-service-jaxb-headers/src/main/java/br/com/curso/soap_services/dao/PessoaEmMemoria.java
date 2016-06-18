package br.com.curso.soap_services.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.curso.soap_services.modelo.Pessoa;

public class PessoaEmMemoria implements PessoaDao{
	
	private static List<Pessoa> pessoas;
	
	static {
		pessoas = new ArrayList<Pessoa>();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Luiz");
		pessoa.setCpf("12312312345");
		pessoas.add(pessoa);
	}

	@Override
	public Pessoa busca(String cpf) {
	    try{
	    	Pessoa pessoa = pessoas
							   .stream()
							   .filter(c -> c.getCpf().equals(cpf))
							   .collect(Collectors.toList()).get(0);
	    	return pessoa;
	    }
	    catch(IndexOutOfBoundsException out){
	    	return new Pessoa();
	    }
		
	}

	@Override
	public Boolean cadastra(Pessoa pessoa) {
		return pessoas.add(pessoa);
	}

	@Override
	public List<Pessoa> buscaTodas() {
		// TODO Auto-generated method stub
		return pessoas;
	}
	

}
