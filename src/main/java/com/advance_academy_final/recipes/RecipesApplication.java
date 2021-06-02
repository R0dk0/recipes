package com.advance_academy_final.recipes;

import com.advance_academy_final.recipes.model.Recipe;
import com.advance_academy_final.recipes.model.User;
import com.advance_academy_final.recipes.service.RecipeService;
import com.advance_academy_final.recipes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RecipesApplication {

	@Autowired
	private UserService userService;
	@Autowired
	private RecipeService recipeService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}

	@PostConstruct
	public void execute() {

		userService.save(User.builder()
				.username("Rodko")
				.firstName("Radoslav")
				.lastName("Dimitrov")
				.build());
		recipeService.save(Recipe.builder()
				.name("Салата - домати и краставици")
				.description("Нарязани на дребно")
				.products("10кг-Домати и Краставици")
				.build());
	}


}
