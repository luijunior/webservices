package br.com.curso.object_serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializadorXml implements Serializador{
	
	private Object objeto;

	@Override
	public OutputStream serializa(Object context) throws JAXBException {
		ByteArrayOutputStream resultado = new ByteArrayOutputStream();
		Marshaller marshall = retornaContext(context).createMarshaller();
		marshall.marshal(this.objeto, resultado);
		
		return resultado;
	}

	@Override
	public Object deserializa(Object context,Class<?> returnObject) throws JAXBException {
		ByteArrayInputStream input = new ByteArrayInputStream(this.objeto.toString().getBytes());
		Unmarshaller unmarshall = retornaContext(context).createUnmarshaller();
		
		
		return unmarshall.unmarshal(input);
	}
	
	private JAXBContext retornaContext(Object context){
		if(context instanceof JAXBContext){
			return (JAXBContext) context;
		}
		else{
			return null;
		}
	}

	@Override
	public void setObjeto(Object objeto) {
		this.objeto = objeto;	
	}

}
