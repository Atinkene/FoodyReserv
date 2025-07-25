package com.foodyback.modele;

import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entité représentant un article du menu.
 */
@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est requis")
    @Size(max = 100, message = "Le nom doit avoir moins de 100 caractères")
    private String nom;

    @Size(max = 50, message = "La catégorie doit avoir moins de 50 caractères")
    private String categorie;

    @NotNull(message = "Le prix est requis")
    @Positive(message = "Le prix doit être positif")
    private Double prix;

    private String description;

    @Column(name = "est_actif")
    private Boolean estActif = true;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonManagedReference 
    private List<MenuImage> images = new ArrayList<>();
}