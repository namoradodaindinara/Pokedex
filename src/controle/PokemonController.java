package controle;
import java.util.ArrayList;

import modelo.Pokemon;

public class PokemonController {
	public ArrayList<Pokemon> pokemonList = new ArrayList<>();
	
	public void addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
	}
	
	 public void imprimePokemon() {
	        for(int i = 0; i < pokemonList.size(); i++) {
	        	System.out.println("Pokemon: " + pokemonList.get(i).getNome() +" \n" + 
	        "Peso " + pokemonList.get(i).getPeso() + 
	        "\nAltura: " + pokemonList.get(i).getAltura() + 
	        "\nTipo: " + pokemonList.get(i).getTipo()  + 
	        "\nRegião: " + pokemonList.get(i).getRegiao());
	        }
	    }
}