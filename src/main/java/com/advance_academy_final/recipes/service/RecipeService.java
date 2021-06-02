package com.advance_academy_final.recipes.service;

import com.advance_academy_final.recipes.exception.RecordNotFoundException;
import com.advance_academy_final.recipes.model.Recipe;
import com.advance_academy_final.recipes.repository.RecipeRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService {

    public final RecipeRepository recipeRepository;


    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> findAll() {
        return new HashSet<>(recipeRepository.findAll());
    }

    public void save(@NonNull Recipe recipe) {
        recipeRepository.save(recipe);
    }
    public Recipe findById(@NotNull Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
//                .orElseThrow(()-> new RecordNotFoundException(String.format("Recipe not found with this; %s", id)));
    }

    public Recipe findByName(@NonNull String recipeName) {
        return recipeRepository.findByName(recipeName)
                .orElseThrow(()-> new RecordNotFoundException(String.format("Recipe not found with this: %s ",recipeName)));
    }

    public Recipe update(Long id, Recipe recipe) {
        Recipe foundRecipe = recipeRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException(String.format("Recipe not found with this; %s", id)));
        foundRecipe.setName(recipe.getName());
        foundRecipe.setDescription(recipe.getDescription());
        foundRecipe.setProducts(recipe.getProducts());
        Recipe savedRecipe = recipeRepository.save(foundRecipe);
        return savedRecipe;
    }

}
