package controle;

import java.util.ArrayList;

import modelo.Pokemon;

public class PokemonController {

	private ArrayList<Pokemon> tabelaPokemon;

	public PokemonController() {
		this.tabelaPokemon = new ArrayList<>();
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
	public boolean alterar(Pokemon p, Long cpfPessoa) {

		for (Pokemon pessoa : tabelaPokemon) {

			if (pessoa.getCpf() == cpfPessoa) {
				pessoa.setNome(p.getNome());
				return true;
			}
		}
		return false;
	}

	// DELETE
	public boolean deletar(Pessoa p, Long cpfPessoa) {

		for (Pessoa pessoa : tabelaPessoas) {
			if (pessoa.getCpf() == cpfPessoa) {
				tabelaPessoas.remove(pessoa);
				return true;
			}
		}

		return false;
	}

	// SELECT ALL
	public ArrayList<Pessoa> listaPessoas() {
		return this.tabelaPessoas;
	}

}