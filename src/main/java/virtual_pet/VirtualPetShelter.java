package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    Map<String, String> petData = new HashMap<>();
    Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String petName) {
        return pets.get(petName);
    }

    public void addPet(String name, String description) {
        VirtualPet newPet = new VirtualPet(name, description);
        pets.put(name, newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

    public void feedAll() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.feed(30));
        }
    }

    public void hydrateAll() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.hydrate(20));
        }
    }

    public void restAll() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.rest(20));
        }
    }

    public void playAll() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.play(20));
        }
    }

    public void playPet(String name) {
        for (VirtualPet pet : pets.values()) {
            if (pet.getName().equalsIgnoreCase(name))
                System.out.println(pet.play(20));
        }
    }

    public void healAll() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.heal(20));
        }
    }
}
