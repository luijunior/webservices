package br.com.curso.rest_service_tomcat.service;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PessoaServiceTest extends TemplateTest{
	
	@Test
	public void deve_retornar_luiz_como_pessoa(){
		
		given()
		    .header("Content-Type","application/json")
			.body("{\"nome\": \"Luiz\",\"cpf\": \"12312312345\"}")
			.put("pessoa/12312312345")
		.then()
			.assertThat()
			.statusCode(204);

		given()
			.get("pessoa/12312312345")
		.then()
			.assertThat()
			.statusCode(200)
			.body("nome", equalTo("Luiz"))
			.body("cpf", equalTo("12312312345"));
	}
	
	@Test
	public void deve_atualizar_e_consultar_alteracao_com_sucesso(){
		given()
		    .header("Content-Type","application/json")
			.body("{\"nome\": \"Luiz Antonio\",\"cpf\": \"12312312345\"}")
			.put("pessoa/12312312345")
		.then()
			.assertThat()
			.statusCode(204);
		
		given()
			.get("pessoa/12312312345")
		.then()
			.assertThat()
			.statusCode(200)
			.body("nome", equalTo("Luiz Antonio"))
			.body("cpf", equalTo("12312312345"));
			
	}
	
	@Test
	public void deve_retornar_404_caso_cliente_nao_exista(){
		given()
			.get("pessoa/12")
		.then()
			.assertThat()
			.statusCode(404);
	}
	
	@Test
	public void deve_cadastrar_pessoa_em_json_no_servico_com_sucesso(){
		given()
			.header("Content-Type","application/json")
			.body("{\"nome\": \"Julio\",\"cpf\": \"12312312312\"}")
			.post("pessoa")
		.then()
			.assertThat()
			.statusCode(201)
			.header("Location", "http://localhost:8080/rest-service-tomcat/rest/pessoa/12312312312");
		
	}
	
	@Test
	public void deve_cadastrar_pessoa_em_json_e_depois_remover_com_sucesso(){
		given()
			.header("Content-Type","application/json")
			.body("{\"nome\": \"Julio Esquerdo\",\"cpf\": \"12312389077\"}")
			.post("pessoa")
		.then()
			.assertThat()
			.statusCode(201)
			.header("Location", "http://localhost:8080/rest-service-tomcat/rest/pessoa/12312389077");
		
		given()
			.header("Content-Type","application/json")
			.delete("pessoa/12312389077")
		.then()
			.assertThat()
			.statusCode(204);
			
	}
	
	@Test
	public void deve_cadastrar_pessoa_em_xml_no_servico_com_sucesso(){
		given()
			.header("Content-Type","application/xml")
			.body("<pessoa><nome>Fernando</nome><cpf>1234567891</cpf></pessoa>")
			.post("pessoa")
		.then()
			.assertThat()
			.statusCode(201)
			.header("Location", "http://localhost:8080/rest-service-tomcat/rest/pessoa/1234567891");
		
	}

}
