package com.advance_academy_final.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes" )

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = false)
    private String name;

    @Lob
    @Column(unique = false,nullable = false)
    private String description;

    @Column(unique = false,nullable = false,length = 1020)
    private String products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
