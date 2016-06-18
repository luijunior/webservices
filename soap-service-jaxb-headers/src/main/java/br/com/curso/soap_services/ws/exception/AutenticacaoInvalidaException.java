package br.com.curso.soap_services.ws.exception;

import javax.xml.ws.WebFault;

@WebFault(name="autorizacaoFault")
public class AutenticacaoInvalidaException extends Exception {
	
	private String faultInfo;
	

	public AutenticacaoInvalidaException(String string) {
		super(string);
	}
	
	public AutenticacaoInvalidaException(String string,Exception ex) {
		super(string,ex);
	}
	
	public String getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(String faultInfo) {
		this.faultInfo = faultInfo;
	}
	
	

	public String getFaultcode() {
		return "001";
	}



	private static final long serialVersionUID = 1L;
	

}
