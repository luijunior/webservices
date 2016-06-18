package br.com.curso.simple_servlet.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.simple_servlet.dao.PessoaDao;
import br.com.curso.simple_servlet.dao.PessoaEmMemoria;

public class BuscaParticipante implements Tarefa{

	PessoaDao pessoaDao =new PessoaEmMemoria();
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("pessoas", pessoaDao.listaTodas());
		pessoaDao.listaTodas().stream().forEach(c -> System.out.println(c.getNome()));
		return "/WEB-INF/paginas/busca.jsp";
	}

}
