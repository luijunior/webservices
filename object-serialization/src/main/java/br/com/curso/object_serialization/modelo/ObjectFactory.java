package br.com.curso.object_serialization.modelo;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public Pessoa createPessoa() { 
		return new Pessoa();
	}
	
}
