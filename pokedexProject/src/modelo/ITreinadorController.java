package modelo;

import java.util.ArrayList;

public interface ITreinadorController {
	
	public boolean inserir(Treinador t);

	public boolean deletar(Treinador t, String nome);

	public ArrayList<Treinador> listaTreinador();
	
	public Treinador buscarTreinadorPorId(Integer id);

}
