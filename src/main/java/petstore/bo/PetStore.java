package petstore.bo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pet_store")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;
    @OneToMany(mappedBy = "pet_store")
    private List<Animal> animals = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    public PetStore() {
    }

    public PetStore(String name, String managerName, List<Animal> animals, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.animals = animals;
        this.address = address;
    }

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", animals=" + animals +
                ", address=" + address +
                '}';
    }
}
