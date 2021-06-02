package com.advance_academy_final.recipes.service;

import com.advance_academy_final.recipes.dto.UserDto;
import com.advance_academy_final.recipes.exception.RecordNotFoundException;
import com.advance_academy_final.recipes.model.User;
import com.advance_academy_final.recipes.repository.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(@NonNull String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()->new RecordNotFoundException(String.format("User %s not found", username)));
    }

    public void save(@NonNull User user) {

        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

    }

    public Set<UserDto> returnAllUsers() {
        List<User> users = userRepository.findAll();
        Set<UserDto> userDtos = new HashSet<>();
        for (User user:users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setCreatedAt(user.getCreatedAt());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getFirstName());
 //           userDto.setRecipes(user.getRecipe().getName()); Тук искам да сложя да ми излизат всички рецепти на този потребител разбирам каква е грешката но немога да я направя по правилния начин

            userDtos.add(userDto);
        }
        return userDtos;

    }

}
