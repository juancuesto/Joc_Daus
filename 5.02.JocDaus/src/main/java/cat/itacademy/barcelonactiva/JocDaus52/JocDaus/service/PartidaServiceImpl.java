package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.repository.IJugadorRepository;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.repository.IPartidaRepository;

@Service
public class PartidaServiceImpl implements IPartidaService {

	@Autowired
	private IPartidaRepository partidaRepository;
	@Autowired
	private IJugadorRepository jugadorRepo;

	

	@Override
	public void EliminarPartidasJugador(Long id) {
		jugadorRepo.getById(id);
		partidaRepository.deleteAll();

	}

	@Override
	public Partida save(Partida partida) {
		return partidaRepository.save(partida);
	}

	@Override
	public List<Partida> FindPartidaByJugadorId(Long id) {
		
		Jugador jugador=jugadorRepo.getById(id);
		return jugador.getResultados();
	}

	@Override
	public Partida hacerTirada(Long id) {
		
		Partida partida=new Partida(jugadorRepo.getById(id));
		partida.jugarPartida(jugadorRepo.getById(id));
		
		return partidaRepository.save(partida);
	}

	

}
