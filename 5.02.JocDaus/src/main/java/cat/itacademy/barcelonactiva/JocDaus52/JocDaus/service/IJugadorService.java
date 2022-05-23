package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;

public interface IJugadorService {
	
public List<Jugador> ListadoJugadores();
	
	public Jugador Save(Jugador jugador);
	public Optional<Jugador> findById(Long id);
	public void eliminarById(Long id);
	public Optional<Jugador> MejorJugador();
	

}
