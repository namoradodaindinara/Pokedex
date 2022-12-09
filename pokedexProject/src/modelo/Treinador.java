package modelo;

import java.util.Date;

public class Treinador extends Ser {
	private int id;
	private String cpf;
	private String dateNasc;
	private String pokFav;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDateNasc() {
		return dateNasc;
	}
	public void setDateNasc(String dateNasc) {
		this.dateNasc = dateNasc;
	}
	public String getPokFav() {
		return pokFav;
	}
	public void setPokFav(String pokFav) {
		this.pokFav = pokFav;
	}
	
}
