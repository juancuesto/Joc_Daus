package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.controler;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service.IJugadorService;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service.JugadorServiceImpl;
import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service.PartidaServiceImpl;

@RestController
@RequestMapping("/players")
public class JugadorController{
	
	@Autowired
	private IJugadorService jugadorService;
	
	@PostMapping
	public ResponseEntity<?> Crear(@RequestBody Jugador jugador) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(jugadorService.Save(jugador));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable (value="id") Long jugadorId){
		Optional<Jugador> ojugador=jugadorService.findById(jugadorId);
		
		if(! ojugador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ojugador);
		
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Jugador jugadorDetails ,@PathVariable (value="id") Long jugadorId) {
		
		Optional<Jugador> ojugador=jugadorService.findById(jugadorId);
		if(! ojugador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ojugador.get().setNombre(jugadorDetails.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jugadorService.Save(ojugador.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable (value="id") Long jugadorId){
		
		if(! jugadorService.findById(jugadorId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
	
		jugadorService.eliminarById(jugadorId);
		return ResponseEntity.ok().build();
		
	}
	
		
	

}
