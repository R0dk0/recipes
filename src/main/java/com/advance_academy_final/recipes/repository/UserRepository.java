package com.advance_academy_final.recipes.repository;


import com.advance_academy_final.recipes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

    Optional<User> findByUsername(String username);


}
