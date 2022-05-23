package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public Jugador Save(Jugador jugador) {
		String aux = jugador.getNombre();
		List<Jugador> lista = jugadorRepo.findAll();
		for (Jugador elemento : lista) {
			if ((elemento.getNombre().equalsIgnoreCase(aux)) && !(aux.equalsIgnoreCase("anonimo"))) {
				System.out.println("El nombre esta registrado");
				jugador.setNombre("Anónimo");
			}
		}

		return jugadorRepo.save(jugador);
	}

	@Override
	public Optional<Jugador> findById(Long id) {

		return jugadorRepo.findById(id);
	}

	@Override
	public void eliminarById(Long id) {

		jugadorRepo.deleteById(id);
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
