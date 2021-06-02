package com.advance_academy_final.recipes.dto;


import com.advance_academy_final.recipes.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDateTime createdAt;

    private Set<Recipe> recipes;
}
