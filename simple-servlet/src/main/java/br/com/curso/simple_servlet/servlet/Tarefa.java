package br.com.curso.simple_servlet.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {

	String executa(HttpServletRequest req,HttpServletResponse resp);
	
}
