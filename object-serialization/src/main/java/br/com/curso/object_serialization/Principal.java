package br.com.curso.object_serialization;

import javax.xml.bind.JAXBContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.curso.object_serialization.modelo.Pessoa;

public class Principal {
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance("br.com.curso.object_serialization.modelo");
		Serializador ser = new SerializadorXml();
		Pessoa pess = new Pessoa();
		pess.setNome("Luiz");
		ser.setObjeto(pess);
		System.out.println(ser.serializa(context));
		
		String XML = "<pessoa><nome>Julio</nome></pessoa>";
		ser.setObjeto(XML);
		System.out.println(ser.deserializa(context, Pessoa.class));
		
		
		ObjectMapper mapper = new ObjectMapper();
		String JSON = "{\"nome\": \"Fernando\"}";
		Pessoa fernando = mapper.readValue(JSON.getBytes(), Pessoa.class);
		System.out.println(fernando);
		
		mapper.writeValue(System.out,fernando );
		
	}
}
