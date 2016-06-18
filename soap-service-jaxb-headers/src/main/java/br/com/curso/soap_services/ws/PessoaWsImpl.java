package br.com.curso.soap_services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.curso.soap_services.dao.AutenticacaoDao;
import br.com.curso.soap_services.dao.AutenticacaoEmMemoria;
import br.com.curso.soap_services.dao.PessoaDao;
import br.com.curso.soap_services.dao.PessoaEmMemoria;
import br.com.curso.soap_services.modelo.Autenticacao;
import br.com.curso.soap_services.modelo.Pessoa;
import br.com.curso.soap_services.modelo.Pessoas;
import br.com.curso.soap_services.ws.exception.AutenticacaoInvalidaException;

@WebService
public class PessoaWsImpl implements PessoaWs{

	private final PessoaDao pessoaDao = new PessoaEmMemoria();
	private final AutenticacaoDao authDao = new AutenticacaoEmMemoria();
	
	@Override
	@WebMethod(operationName="consultaPorCpf")
	@WebResult(name="pessoa")
	public Pessoa consultaPorCpf(@WebParam(header=true,name="autenticacao") Autenticacao auth, @WebParam(name="cpf")String cpf) throws AutenticacaoInvalidaException {
		if(authDao.validaAutenticacao(auth)){
			return pessoaDao.busca(cpf);
		}
		AutenticacaoInvalidaException ex = new AutenticacaoInvalidaException("Erro na autorizacao");
		ex.setFaultInfo("Usuario "+auth.getUser()+" ou senha invalidos");
		throw ex;
	}

	@Override
	@WebMethod(operationName="cadastraPessoa")
	@WebResult(name="sucesso")
	public Boolean cadastra(Pessoa pessoa) {
		return pessoaDao.cadastra(pessoa);
	}

	@Override
	@WebMethod(operationName="buscaTodas")
	@WebResult(name="pessoaResponse")
	public Pessoas buscaTodas() {
		// TODO Auto-generated method stub
		Pessoas pessoas = new Pessoas();
		pessoas.setPessoas(pessoaDao.buscaTodas());
		return pessoas;
	}

}
