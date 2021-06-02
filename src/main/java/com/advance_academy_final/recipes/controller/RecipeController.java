package com.advance_academy_final.recipes.controller;

import com.advance_academy_final.recipes.model.Recipe;
import com.advance_academy_final.recipes.service.RecipeService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/recipes")
    public Set<Recipe> findAll() {
        return recipeService.findAll();
    }

    @PostMapping
    public ResponseEntity<HttpEntity> save(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<HttpStatus> deleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok().build();
    }
}
