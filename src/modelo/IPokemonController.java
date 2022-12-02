package modelo;

import java.util.ArrayList;

public interface IPokemonController {

	public boolean inserir(Pokemon p);

	public boolean alterar(Pokemon p, int id);

	public boolean deletar(Pokemon p, int id);

	public ArrayList<Pokemon> listaPokemons();

}