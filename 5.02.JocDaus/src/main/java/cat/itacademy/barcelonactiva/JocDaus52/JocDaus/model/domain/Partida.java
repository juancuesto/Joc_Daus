package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Partidas")
public class Partida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partidaId")
	private Long partidaId;
	@Column(name = "Dado1")
	private int dado1;
	@Column(name = "Dado2")
	private int dado2;
	@Column(name = "Ganar")
	private boolean ganar;
	
	
	
	@JoinColumn(name = "Jugador_Id")
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Jugador jugador;
	
	public Partida(Jugador jugador) {
		this.jugador=jugador;
	}
	
	
	public Long getPartidaId() {
		return partidaId;
	}
	public void setPartidaId(Long partidaId) {
		this.partidaId = partidaId;
	}
	public void setDado1(int d) {
		this.dado1=d;
	}
	public void setDado2(int d) {
		this.dado2=d;
	}

	public int getDado1() {
		return dado1;
	}

	public int getDado2() {
		return dado2;
	}
	
	public boolean isGanar() {
		return ganar;
	}


	public void setGanar(boolean ganar) {
		this.ganar = ganar;
	}


	public Partida jugarPartida(Jugador jugador) {
		Partida partida=new Partida(jugador);
		boolean ganar=false;
		int dado1=(int) (Math.random()*8);
		partida.setDado1(dado1);
		int dado2=(int) (Math.random()*8);
		partida.setDado2(dado2);
		int resultado=dado1+dado2;
	
		if(resultado==7) {
			partida.setGanar(true);
		}else {
			partida.setGanar(false);
		}
		return partida;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void dameResultdoJugador(Jugador jugador) {
		
	}
	
	
}

