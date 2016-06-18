package br.com.curso.rest_service_tomcat.service;

import com.jayway.restassured.RestAssured;

public class TemplateTest {
	public TemplateTest(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/rest-service-tomcat/rest";
	}

}
