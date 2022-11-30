package controle;
import java.util.ArrayList;

import modelo.Pokemon;

public class PokemonController {
	ArrayList<Pokemon> pokemonList = new ArrayList<>();
	
	public void addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
	}
}