package edu.htc.gamedata.repositories;

import edu.htc.gamedata.entities.Game;
import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository extends CrudRepository<Game, Integer> {
}
