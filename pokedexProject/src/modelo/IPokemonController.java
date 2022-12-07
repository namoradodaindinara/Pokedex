package modelo;

import java.util.ArrayList;

public interface IPokemonController {

	public boolean inserir(Pokemon p);

	public boolean deletar(Pokemon p, String nome);

	public ArrayList<Pokemon> listaPokemon();
	
	public Pokemon buscarPokemonPorId(Integer id);

}