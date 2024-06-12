package petstore.bo;

import jakarta.persistence.Column;

public class Fish extends Animal{

    @Column(name = "env", columnDefinition = "int4")
    private FishLivEnv livingEnv;

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
