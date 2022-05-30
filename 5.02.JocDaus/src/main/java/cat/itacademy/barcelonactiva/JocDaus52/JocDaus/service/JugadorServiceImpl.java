package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.repository.IJugadorRepository;


@Service
public class JugadorServiceImpl implements IJugadorService {
	
	@Autowired
	private IJugadorRepository jugadorRepo;

	@Override
	public List<Jugador> ListadoJugadores() {
		return jugadorRepo.findAll();
	}

	@Override
	@Transactional
	public Jugador Save(Jugador jugador) {
		/*List<Jugador> lista = jugadorRepo.findAll();
		for (Jugador elemento : lista) {
			if ((elemento.getNombre().equalsIgnoreCase(jugador.getNombre())) || (jugador.getNombre()=="")) {
				System.out.println("El nombre esta registrado");
				jugador.setNombre("Anónimo");
			}
		}*/

		return jugadorRepo.save(jugador);
	}

	@Override
	public Optional<Jugador> getJugadorById(Long id) {

		return jugadorRepo.findById(id);
	}

	@Override
	public boolean eliminarJugadorById(Long id) {

		Boolean result=false;
		if(jugadorRepo.findById(id)==null) {
			return result;
		}else {
			result=true;
			jugadorRepo.deleteById(id);
			return result;
		}
	}

	@Override
	public Optional<Jugador> MejorJugador() {
		List<Jugador> listaJugadores = jugadorRepo.findAll();

		if (listaJugadores.isEmpty()) {

			System.out.println("No hay Jugadores.");
		}
		

		Collections.sort(listaJugadores, new comparadorJugador());
		
		System.out.println("The best player is: " + listaJugadores.get(0).toString());

		return Optional.of(listaJugadores.get(0));
	}
	
	 

	

	

}
