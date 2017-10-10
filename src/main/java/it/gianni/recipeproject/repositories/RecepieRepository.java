package it.gianni.recipeproject.repositories;

import it.gianni.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecepieRepository extends CrudRepository<Recipe, Long> {
}
