package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.service;

import java.util.Comparator;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Jugador;

public class comparadorJugador implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o1, Jugador o2) {
		return o1.getPorcentajeExito() < o2.getPorcentajeExito() ? -1 :  o1.getPorcentajeExito()== o2.getPorcentajeExito() ? 0 : 1;
	}

}
