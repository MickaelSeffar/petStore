package org.seffar.petstore.bo;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Cat extends Animal {

    private String chipId;

    // Constructeur par défaut
    public Cat() {
    }

    // Constructeur avec paramètres
    public Cat(String name, String chipId, Date birth, String couleur, PetStore petStore) {
        super(name, birth, couleur, petStore);
        this.chipId = chipId;
    }

    // Getters et Setters
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    // Méthode toString pour afficher les informations du chat
    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                "} " + super.toString();
    }
}
