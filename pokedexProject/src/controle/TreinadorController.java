package controle;

import java.util.ArrayList;

import modelo.ITreinadorController;
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
}
