package it.gianni.recipeproject.services;

import it.gianni.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}