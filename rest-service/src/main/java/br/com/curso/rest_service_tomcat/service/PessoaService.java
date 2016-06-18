package br.com.curso.rest_service_tomcat.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.curso.rest_service_tomcat.dao.PessoaDao;
import br.com.curso.rest_service_tomcat.dao.PessoaEmMemoria;
import br.com.curso.rest_service_tomcat.modelo.Pessoa;

@Path(value="pessoa")
public class PessoaService {
	
	PessoaDao pessoaDao = new PessoaEmMemoria();
	
	@GET
	@Produces(value={"application/json","application/xml"})
	public Response busca(@QueryParam(value="cpf")String cpf){
		Pessoa pessoa = pessoaDao.busca(cpf);
		if(pessoa.getNome() == null){
			return Response.status(404).build();
		}
		return Response.ok().entity(pessoa).build();
	}

}
