package it.gianni.recipeproject.services;

import it.gianni.recipeproject.commands.IngredientCommand;
import it.gianni.recipeproject.converters.IngredientToIngredientCommand;
import it.gianni.recipeproject.domain.Recipe;
import it.gianni.recipeproject.repositories.RecipeRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //TODO Error Handling
            log.debug("Recipe Not Found!");
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream().filter(ingredient ->
                ingredient.getId().equals(ingredientId)).map(ingredient -> ingredientToIngredientCommand.convert
                (ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //TODO Error Handling
            log.error("Ingredient not found:" + ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
