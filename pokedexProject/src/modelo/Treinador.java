package modelo;

import java.util.Date;

public class Treinador extends Ser {
	private String cpf;
	private String dateNasc;
	private String pokFav;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDateNasc() {
		return dateNasc;
	}
	public void setDateNasc(String date) {
		this.dateNasc = date;
	}
	public String getPokFav() {
		return pokFav;
	}
	public void setPokFav(String pokFav) {
		this.pokFav = pokFav;
	}
}
