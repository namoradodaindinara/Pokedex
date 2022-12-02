package controle;

import java.util.ArrayList;

import modelo.IPokemonController;
import modelo.Pokemon;

public class PokemonController implements IPokemonController {

	private static ArrayList<Pokemon> tabelaPokemon;
	private static PokemonController instancia;

	/**
	 * PADRAO SINGLETON
	 */
	private PokemonController() {
	}

	/**
	 * METODO QUE POSSIBILITA INSTANCIAR A CLASSE SEM QUE CRIE NOVOS OBJETOS NA
	 * MEMORIA.
	 * 
	 * OU SEJA, SEMPRE MANIPULANDO O MESMO ESPACO/OBJETO/VARIAVEL NA MEMORIA RAM
	 * 
	 * @return
	 */
	public static PokemonController getInstancia() {

		if (instancia == null) {
			instancia = new PokemonController();
			tabelaPokemon = new ArrayList<>();
		}

		return instancia;
	}

	// INSERT
	public boolean inserir(Pokemon p) {
		if (p != null) {
			tabelaPokemon.add(p);
			return true;
		}
		return false;
	}

	// UPDATE
	public boolean alterar(Pokemon p, int id) {

		for (Pokemon pok : tabelaPokemon) {

			if (p.getId() == id) {
				p.setNome(p.getNome());

				// TODO finalizar o alterar
				return true;
			}
		}
		return false;
	}

	// DELETE
	public boolean deletar(Pokemon p, int id) {

		for (Pokemon pok : tabelaPokemon) {
			if (p.getId() == id) {
				tabelaPokemon.remove(p);
				return true;
			}
		}

		return false;
	}

	// SELECT ALL
	public ArrayList<Pokemon> listaPokemon() {
		return tabelaPokemon;
	}

	@Override
	public ArrayList<Pokemon> listaPokemons() {
		// TODO Auto-generated method stub
		return null;
	}

}
