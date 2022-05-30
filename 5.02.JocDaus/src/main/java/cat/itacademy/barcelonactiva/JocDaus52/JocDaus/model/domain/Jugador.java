package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jugadores")
public class Jugador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jugadorId")
	private Long jugadorId;
	@Column(name = "Nombre", length = 100, nullable = false)
	private String nombre;
	@Column(name = "fecha_registro")
	private LocalDate fecha_registro;
	@Column(name = "Porcentaje_Exito")
	private double porcentajeExito;
	
	@OneToMany(mappedBy = "jugador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Resultados")
	List<Partida> resultados=new ArrayList<>();
	
	
	
	public Long getJugadorId() {
		return jugadorId;
	}

	public void setJugadorId(Long jugadorId) {
		this.jugadorId = jugadorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDate fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public double getPorcentajeExito() {
		return porcentajeExito;
	}

	public double setPorcentajeExito() {
		int partGanada = 0;
		int totalPartidas = 0;
		double res;
		for (Partida elemento : resultados) {
			if (elemento.isGanar()) {
				partGanada++;
				totalPartidas++;
			} else {
				totalPartidas++;
			}
		}
		res = (partGanada / totalPartidas) * 100;
		return res;
	}

	public List<Partida> getResultados() {
		return resultados;
	}

	public void setResultados(Partida partida) {
		resultados.add(partida);
	}
	

}
