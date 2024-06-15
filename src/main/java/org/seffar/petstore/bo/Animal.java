package org.seffar.petstore.bo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birth;
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "pet_store_id")
    private PetStore petStore;

    // Constructeur par défaut
    public Animal() {
    }

    // Constructeur avec paramètres
    public Animal(String name, Date birth, String couleur, PetStore petStore) {
        this.name = name;
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    // Méthode toString pour afficher les informations de l'animal
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
