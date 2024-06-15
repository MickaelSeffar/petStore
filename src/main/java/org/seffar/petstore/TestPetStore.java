package org.seffar.petstore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.seffar.petstore.bo.*;

import java.util.Date;
import java.util.List;

public class TestPetStore {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        // Créer une instance de EntityManagerFactory pour l'unité de persistance "petStore"
        emf = Persistence.createEntityManagerFactory("petStore");
        // Créer une instance de EntityManager
        em = emf.createEntityManager();
        // Commencer une transaction
        em.getTransaction().begin();

        // Créer des PetStores
        PetStore petStore1 = new PetStore();
        petStore1.setName("Pet Paradise");
        petStore1.setManagerName("John Doe");

        PetStore petStore2 = new PetStore();
        petStore2.setName("Animal Kingdom");
        petStore2.setManagerName("Jane Smith");

        PetStore petStore3 = new PetStore();
        petStore3.setName("Critter Corner");
        petStore3.setManagerName("Alice Johnson");

        // Persister les PetStores dans la base de données
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        // Créer des Adresses et les associer aux PetStores
        Address address1 = new Address("12", "Rue Alain Colas", "44200", "Nantes", petStore1);
        Address address2 = new Address("34", "Boulevard de Magenta", "75010", "Paris", petStore2);
        Address address3 = new Address("56", "Rue de la République", "69002", "Lyon", petStore3);

        petStore1.setAddress(address1);
        petStore2.setAddress(address2);
        petStore3.setAddress(address3);

        // Persister les Adresses dans la base de données
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        // Créer des Animaux et les associer aux PetStores
        Cat cat1 = new Cat("Whiskers", "12345", new Date(), "Brown", petStore1);
        Cat cat2 = new Cat("Felix", "67890", new Date(), "Black", petStore2);
        Cat cat3 = new Cat("Garfield", "54321", new Date(), "Orange", petStore3);

        Fish fish1 = new Fish("Goldie", new Date(), "Gold", FishLivEnv.FRESH_WATER, petStore1);
        Fish fish2 = new Fish("Bubbles", new Date(), "Blue", FishLivEnv.SEA_WATER, petStore2);
        Fish fish3 = new Fish("Finny", new Date(), "Red", FishLivEnv.FRESH_WATER, petStore3);

        // Persister les Chats dans la base de données
        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);

        // Persister les Poissons dans la base de données
        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);

        // Créer des Produits et les associer à plusieurs PetStores
        Product product1 = new Product("P001", "Dog Food", ProdType.FOOD, 10.99, List.of(petStore1, petStore2));
        Product product2 = new Product("P002", "Cat Toy", ProdType.ACCESSORY, 5.99, List.of(petStore2, petStore3));
        Product product3 = new Product("P003", "Fish Tank Cleaner", ProdType.CLEANING, 15.99, List.of(petStore1, petStore3));

        // Persister les Produits dans la base de données
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        // Committer la transaction pour enregistrer toutes les entités créées dans la base de données
        em.getTransaction().commit();

        // Requête pour récupérer les animaux d'un PetStore donné (par exemple, petStore1)
        em.getTransaction().begin();
        List<Animal> animals = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :petStoreId", Animal.class)
                .setParameter("petStoreId", petStore1.getId())
                .getResultList();

        // Afficher les informations des animaux récupérés
        for (Animal animal : animals) {
            System.out.println("Animal Name: " + animal.getName() + ", Pet Store: " + animal.getPetStore().getName());
        }

        // Committer la transaction et fermer l'EntityManager
        em.getTransaction().commit();
        em.close();
    }
}
