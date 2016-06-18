package br.com.curso.soap_services.ws;

import javax.jws.WebService;

import br.com.curso.soap_services.dao.PessoaDao;
import br.com.curso.soap_services.dao.PessoaEmMemoria;
import br.com.curso.soap_services.modelo.Pessoa;

@WebService
public class PessoaWsImpl implements PessoaWs{

	private final PessoaDao pessoaDao = new PessoaEmMemoria();
	
	@Override
	public Pessoa consultaPorCpf(String cpf) {
		
		return pessoaDao.busca(cpf);
	}

	@Override
	public Boolean cadastra(Pessoa pessoa) {
		return pessoaDao.cadastra(pessoa);
	}

}
