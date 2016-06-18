package br.com.curso.simple_servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException{
		
		
		try {
			String tarefa = request.getParameter("tarefa");
			String nomeDaClasse = "br.com.curso.simple_servlet.servlet." + tarefa;
			@SuppressWarnings("rawtypes")
			Class type = Class.forName(nomeDaClasse);
			Tarefa tarefaExecutada = (Tarefa) type.newInstance();
			String pagina = tarefaExecutada.executa(request,response);
			request.getRequestDispatcher(pagina).forward(request, response);
		
        }
		catch(Exception e){
			throw new ServletException(e);
		}
		
	}

}
