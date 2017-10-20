package it.gianni.recipeproject.services;

import it.gianni.recipeproject.commands.RecipeCommand;
import it.gianni.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
