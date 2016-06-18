package br.com.curso.soap_services;

import javax.xml.ws.Endpoint;

public class PublicadorDeServico {
	
	public static void main(String[] args) {
		
		ICalculator servicoSoap = new CalculatorServiceImpl();
		String url = "http://localhost:9090/calculatorWs";
		Endpoint.publish(url, servicoSoap);
		
	}

}
