package it.gianni.recipeproject.services;

import it.gianni.recipeproject.domain.Recipe;
import it.gianni.recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {

        try {
            Recipe recipe = recipeRepository.findById(id).get();

            Byte[] byteobjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteobjects[i++] = b;
            }

            recipe.setImage(byteobjects);

            recipeRepository.save(recipe);

        } catch (IOException e) {
            log.error("Error: " + e);
            e.printStackTrace();
        }
    }
}
