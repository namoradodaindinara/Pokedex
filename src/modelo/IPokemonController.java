package modelo;

import java.util.ArrayList;

public interface IPokemonController {

	public boolean inserir(Pokemon p);

	public boolean alterar(Pokemon p, String nome);

	public boolean deletar(Pokemon p, String nome);

	public ArrayList<Pokemon> listaPokemon();

}