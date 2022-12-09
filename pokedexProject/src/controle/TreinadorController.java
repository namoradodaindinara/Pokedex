package controle;

import java.util.ArrayList;

import modelo.ITreinadorController;
import modelo.Pokemon;
import modelo.Treinador;

public class TreinadorController implements ITreinadorController {

	private static ArrayList<Treinador> tabelaTreinador;
	private static TreinadorController instancia;

	public TreinadorController() {
	}


	public static TreinadorController getInstancia() {

		if (instancia == null) {
			instancia = new TreinadorController();
			tabelaTreinador = new ArrayList<>();
		}

		return instancia;
	}

	// INSERT
	public boolean inserir(Treinador t) {
		if (t != null) {
			tabelaTreinador.add(t);
			return true;
		}
		return false;
	}


	// DELETE
	public boolean deletar(Treinador t, String nome) {

		for (Treinador tre : tabelaTreinador) {
			if (tre.getNome() == nome) {
				tabelaTreinador.remove(tre);
				return true;
			}
		}

		return false;
	}

	// SELECT ALL
	public ArrayList<Treinador> listaTreinador() {
		return tabelaTreinador;
	}


	public boolean alterar(Treinador t, int id) {
		for (Treinador tre : tabelaTreinador) {

			if (t.getId() == id) {
				tre.setNome(tre.getNome());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Treinador buscarTreinadorPorId(Integer id) {
		for (Treinador treinador : tabelaTreinador) {
			if (treinador.getId() == id) {
				return treinador;
			}
		}
		return null;
	}
}
