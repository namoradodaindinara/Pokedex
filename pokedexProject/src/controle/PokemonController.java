package controle;

import java.util.ArrayList;

import modelo.IPokemonController;
import modelo.Pokemon;

public class PokemonController implements IPokemonController {

	private static ArrayList<Pokemon> tabelaPokemon;
	private static PokemonController instancia;

	public PokemonController() {
	}

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

	// DELETE
	public boolean deletar(Pokemon p, String nome) {

		for (Pokemon pok : tabelaPokemon) {
			if (pok.getNome() == nome) {
				tabelaPokemon.remove(pok);
				return true;
			}
		}

		return false;
	}

	// SELECT ALL
	public ArrayList<Pokemon> listaPokemon() {
		return tabelaPokemon;
	}

	public boolean alterar(Pokemon p, int id) {
		for (Pokemon pok : tabelaPokemon) {

			if (p.getId() == id) {
				pok.setNome(p.getNome());
				return true;
			}
		}
		return false;
	}

	@Override
	public Pokemon buscarPokemonPorId(Integer id) {
		for (Pokemon pokemon : tabelaPokemon) {
			if (pokemon.getId() == id) {
				return pokemon;
			}
		}
		return null;
	}

}
