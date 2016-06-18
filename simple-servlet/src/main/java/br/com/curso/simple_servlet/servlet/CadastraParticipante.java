package br.com.curso.simple_servlet.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.simple_servlet.dao.PessoaDao;
import br.com.curso.simple_servlet.dao.PessoaEmMemoria;
import br.com.curso.simple_servlet.modelo.Pessoa;

public class CadastraParticipante implements Tarefa{

	PessoaDao pessoaDao =new PessoaEmMemoria();
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(req.getParameter("cpf"));
		pessoa.setNome(req.getParameter("nome"));
		pessoaDao.cadastra(pessoa);
		return "index.jsp";
	}

}
