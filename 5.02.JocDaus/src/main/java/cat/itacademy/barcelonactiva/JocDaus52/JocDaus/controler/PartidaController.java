package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service.IJugadorService;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service.IPartidaService;


@RestController
@RequestMapping
public class PartidaController {
	
	@Autowired
	private IPartidaService partidaService;
	
	@Autowired
	private IJugadorService jugadorService;
	
	//Listado de jugadas de jugador 
	@GetMapping("/players/{id}/games")
	public ResponseEntity<?> listadoPartidas(@PathVariable("id") Long id){
		//List<Partida> partidas=;
		
		return  ResponseEntity.status(HttpStatus.OK).body(partidaService.FindPartidaById(id));
	}
	
	@PostMapping("{id}/games")
	public ResponseEntity<?> jugarPartida(@PathVariable(value = "id") Long id) {

		return ResponseEntity.ok().body(partidaService.hacerTirada(id));
	}
	@DeleteMapping("{id}/games")
	public ResponseEntity<?> deletePartidas(@PathVariable(value = "id") Long id) {

		Optional<Jugador> ojugador =jugadorService.findById(id);
		if(! ojugador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		partidaService.EliminarPartidasJugador(id);
		return ResponseEntity.ok().build();
		
		
	}

}
