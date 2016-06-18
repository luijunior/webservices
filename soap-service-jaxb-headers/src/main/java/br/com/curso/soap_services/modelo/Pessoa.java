package br.com.curso.soap_services.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pessoa")
public class Pessoa {
	
	private String nome;
	private String cpf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
