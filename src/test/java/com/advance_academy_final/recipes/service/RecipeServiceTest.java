package com.advance_academy_final.recipes.service;

import com.advance_academy_final.recipes.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    private RecipeService recipeService;

    @BeforeEach
    public void init() {
        recipeService = new RecipeService(recipeRepository);
    }

    @Test
    public void expectNullPointerExceptionException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
                    recipeService.findById(null);
                });
    }
}
