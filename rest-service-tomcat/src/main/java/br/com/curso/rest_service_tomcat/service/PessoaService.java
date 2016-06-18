package br.com.curso.rest_service_tomcat.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.curso.rest_service_tomcat.dao.PessoaDao;
import br.com.curso.rest_service_tomcat.dao.PessoaEmMemoria;
import br.com.curso.rest_service_tomcat.modelo.Pessoa;

@Path(value="pessoa")
public class PessoaService {
	
	PessoaDao pessoaDao = new PessoaEmMemoria();
	
	@GET
	@Path(value="{cpf}")
	@Produces(value={"application/json","application/xml"})
	public Response busca(@PathParam(value="cpf")String cpf){
		Pessoa pessoa = pessoaDao.busca(cpf);
		if(pessoa.getNome() == null){
			return Response.status(404).build();
		}
		return Response.ok().entity(pessoa).build();
	}
	
	@POST
	@Consumes(value={"application/json","application/xml"})
	public Response cadastra(Pessoa pessoa) throws URISyntaxException{
		if(pessoaDao.cadastra(pessoa)){
			return Response.created(new URI("http://localhost:8080/rest-service-tomcat/rest/pessoa/"+pessoa.getCpf()))
					       .build();
		}
		else{
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Consumes(value={"application/json","application/xml"})
	@Path(value="{cpf}")
	public Response atualiza(Pessoa pessoa){
		if(pessoaDao.atualiza(pessoa)){
			return Response.status(204).build();
		}
		else{
			return Response.status(500).build();
		}
	}
	
	@DELETE
	@Consumes(value={"application/json","application/xml"})
	@Path(value="{cpf}")
	public Response apaga(@PathParam(value="cpf")String cpf){
		if(pessoaDao.remove(cpf)){
			return Response.status(204).build();
		}
		else{
			return Response.status(500).build();
		}
	}
	

}
