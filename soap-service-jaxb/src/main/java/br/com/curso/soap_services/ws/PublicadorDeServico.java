package br.com.curso.soap_services.ws;

import javax.xml.ws.Endpoint;

public class PublicadorDeServico {
	
	public static void main(String[] args) {
		
		PessoaWs servicoSoap = new PessoaWsImpl();
		String url = "http://localhost:9090/pessoaWs";
		Endpoint.publish(url, servicoSoap);
		
	}

}
