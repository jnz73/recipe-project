package it.gianni.recipeproject.services;

import it.gianni.recipeproject.commands.RecipeCommand;
import it.gianni.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long intToDelete);
}
