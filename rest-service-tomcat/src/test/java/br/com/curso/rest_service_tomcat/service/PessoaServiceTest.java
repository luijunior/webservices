package br.com.curso.rest_service_tomcat.service;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PessoaServiceTest extends TemplateTest{
	
	@Test
	public void deve_retornar_luiz_como_pessoa(){
	
		given()
			.param("cpf", "12312312345")
			.get("pessoa")
		.then()
			.assertThat()
			.statusCode(200)
			.body("nome", equalTo("Luiz"))
			.body("cpf", equalTo("12312312345"));
	}
	
	@Test
	public void deve_retornar_404_caso_cliente_nao_exista(){
		given()
		.param("cpf", "12")
		.get("pessoa")
	.then()
		.assertThat()
		.statusCode(404);
	}

}
