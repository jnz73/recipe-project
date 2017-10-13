package it.gianni.recipeproject.controllers;

import it.gianni.recipeproject.domain.Category;
import it.gianni.recipeproject.domain.UnitOfMeasure;
import it.gianni.recipeproject.repositories.CategoryRepository;
import it.gianni.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");
        System.out.println("Category Id: " + categoryOptional.get().getId());
        System.out.println("UOM Id: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
