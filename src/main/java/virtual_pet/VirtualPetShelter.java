package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public void addPet(String name, String description, int hunger, int thirst, int tiredness, int boredom,
            int sickness) {
        VirtualPet newPet = new VirtualPet(name, description, hunger, thirst, tiredness, boredom, sickness);
        pets.put(name, newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

    public String feedAll(int value) {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.feed(value) + "\n");
        }
        return str.toString();
    }

    public String hydrateAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.hydrate(20) + "\n");
        }
        return str.toString();
    }

    public String restAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.rest(20) + "\n");
        }
        return str.toString();
    }

    public String playAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.play(20) + "\n");
        }
        return str.toString();
    }

    public String playPet(String name) {
        return getPet(name).play(20);
    }

    public String healAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.heal(20) + "\n");
        }
        return str.toString();
    }

    public void tickAll() {
        for (VirtualPet pet : pets.values()) {
            pet.tick();
        }
    }

    public boolean areValuesLessThan100() {
        for (VirtualPet pet : pets.values()) {
            if (pet.getHunger() >= 100 || pet.getThirst() >= 100 ||
                    pet.getTiredness() >= 100 || pet.getBoredom() >= 100 || pet.getSickness() >= 100) {
                return false;
            }
        }
        return true;
    }

    public String displayMessage() {
        for (VirtualPet pet : pets.values()) {
            if (pet.getHunger() >= 100)
                return "Mali starved!";
            else if (pet.getThirst() >= 100)
                return "Mali got dehydrated!";
            else if (pet.getTiredness() >= 100)
                return "Mali got soo tired!";
            else if (pet.getBoredom() >= 100)
                return "Mali got soo bored!";
            else if (pet.getSickness() >= 100)
                return "Mali got soo sick!";
        }
        return "";
    }

    public String performPriorityNeedAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
            str.append(pet.performPriorityNeed() + "\n");
        }
        return str.toString();
    }

    public String displayStatsAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : pets.values()) {
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
