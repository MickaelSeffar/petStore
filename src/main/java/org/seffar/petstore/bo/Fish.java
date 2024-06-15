package org.seffar.petstore.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Fish extends Animal {

    @Column(name = "env", columnDefinition = "int4")
    private FishLivEnv livingEnv;

    // Constructeur par défaut
    public Fish() {
    }

    // Constructeur avec paramètres
    public Fish(String name, Date birth, String couleur, FishLivEnv livingEnv, PetStore petStore) {
        super(name, birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    // Getters et Setters
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    // Méthode toString pour afficher les informations du poisson
    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                "} " + super.toString();
    }
}
