package modelo;

import java.time.LocalDate;

public class Treinador extends Ser {
	private String cpf;
	private LocalDate dateNasc;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDateNasc() {
		return dateNasc;
	}
	public void setDateNasc(LocalDate dateNasc) {
		this.dateNasc = dateNasc;
	}
	
	
}
