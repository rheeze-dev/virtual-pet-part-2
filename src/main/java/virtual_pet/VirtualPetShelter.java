package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {

    Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public Set<String> getAllPetNames() {
        return pets.keySet();
    }

    public void rescuePet(VirtualPet newPet) {
        pets.put(newPet.getName(), newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

    public String feedAll(int value) {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.feed(value) + "\n");
        }
        return str.toString();
    }

    public String hydrateAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.hydrate(20) + "\n");
        }
        return str.toString();
    }

    public String restAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.rest(20) + "\n");
        }
        return str.toString();
    }

    public String playAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.play(20) + "\n");
        }
        return str.toString();
    }

    public String playPet(String name) {
        return getPet(name).play(20) + "\n";
    }

    public String healAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.heal(20) + "\n");
        }
        return str.toString();
    }

    public boolean hasPetName(String name) {
        if (pets.containsKey(name)) {
            return true;
        }
        return false;
    }

    public void tickAll() {
        for (VirtualPet pet : getAllPets()) {
            pet.tick();
        }
    }

    public boolean areValuesLessThan100() {
        for (VirtualPet pet : getAllPets()) {
            if (pet.getHunger() >= 100 || pet.getThirst() >= 100 || pet.getTiredness() >= 100 || pet.getBoredom() >= 100
                    || pet.getSickness() >= 100) {
                return false;
            }
        }
        return true;
    }

    public String displayMessage() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet.getHunger() >= 100)
                str.append(pet.getName() + " starved!\n");
            if (pet.getThirst() >= 100)
                str.append(pet.getName() + " got dehydrated!\n");
            if (pet.getTiredness() >= 100)
                str.append(pet.getName() + " got soo tired!\n");
            if (pet.getBoredom() >= 100)
                str.append(pet.getName() + " got soo bored!\n");
            if (pet.getSickness() >= 100)
                str.append(pet.getName() + " got soo sick!\n");
        }
        return str.toString();
    }

    public String performPriorityNeedAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.performPriorityNeed() + "\n");
        }
        return str.toString();
    }

    public String displayAllStats() {
        StringBuilder str = new StringBuilder();
        str.append("Name\t\t|Hunger\t\t|Thirst\t\t|Tiredness\t|Boredom\t|Sickness\t|\n"
                + "----------------|---------------|---------------|---------------|---------------|---------------|\n");
        for (VirtualPet pet : getAllPets()) {
            str.append(pet.displayStats() + "\n");
        }
        return str.toString();
    }

    public String displayPet() {
        String pet = "      __\n" +
                " w  c(..)o   (\n" +
                "  \\__(-)    __)\n" +
                "      /\\   (\n" +
                "     /(_)___)\n" +
                "    w /|\n" +
                "      | \\\n" +
                "      m  m";
        return pet;
    }
}
