package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;



public interface IPartidaService {
	
	
	public void EliminarPartidasJugador(Long id);
	
	public Partida save(Partida partida);
	
	public List<Partida> FindPartidaById(Long id);
	public Partida hacerTirada(Long id);
	

}
