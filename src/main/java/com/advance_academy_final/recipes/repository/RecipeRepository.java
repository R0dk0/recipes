package com.advance_academy_final.recipes.repository;

import com.advance_academy_final.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Long> {

    Optional<Recipe> findByName (String name);

    void deleteByName(String name);
}
