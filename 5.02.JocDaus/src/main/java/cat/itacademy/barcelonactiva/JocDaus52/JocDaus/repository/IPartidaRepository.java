package cat.itacademy.barcelonactiva.JocDaus52.JocDaus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.JocDaus52.JocDaus.model.domain.Partida;

@Repository
public interface IPartidaRepository extends JpaRepository<Partida, Long> {

}
