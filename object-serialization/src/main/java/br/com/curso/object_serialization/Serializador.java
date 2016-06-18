package br.com.curso.object_serialization;

import java.io.OutputStream;



public interface Serializador {
	
	void setObjeto(Object objeto);
	OutputStream serializa(Object context) throws Exception;
	Object deserializa(Object context, Class<?> returnObject)
			throws Exception;

}
