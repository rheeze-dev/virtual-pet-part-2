package virtual_pet;

import java.util.Random;

public class VirtualPet {
    private int hunger = 30;
    private int thirst = 30;
    private int tiredness = 20;
    private int boredom = 20;
    private int sickness = 10;
    private String name;
    private String description;
    Random random = new Random();

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VirtualPet(String name, String description, int hunger, int thirst, int tiredness, int boredom,
            int sickness) {
        this.name = name;
        this.description = description;
        this.hunger = hunger;
        this.thirst = thirst;
        this.tiredness = tiredness;
        this.boredom = boredom;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public int getSickness() {
        return this.sickness;
    }

    public void setSickness(int sickness) {
        this.sickness = sickness;
    }

    public void tick() {
        setHunger(getHunger() + 3);
        setThirst(getThirst() + 3);
        setTiredness(getTiredness() + 3);
        setBoredom(getBoredom() + 3);
        setSickness(getSickness() + 3);
    }

    public String feed(int value) {
        if (value == 30 || value == 20) {
            if (getBoredom() >= random.nextInt(150))
                return "Mali is bored and refused to eat.";
            else {
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + 20);
                return "You fed Mali.";
            }
        } else {
            if (getHunger() <= 100) {
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + value);
                return "Mali ate on his own.\n";
            }
            return "";
        }
    }

    public String hydrate(int value) {
        setThirst(getThirst() - value < 0 ? 0 : getThirst() - value);
        if (value == 20)
            return "You gave water to Mali.";
        else {
            if (getThirst() <= 100)
                return "Mali drank water on his own.\n";
            return "";
        }
    }

    public String rest(int value) {
        if (value == 20) {
            if (getHunger() >= random.nextInt(150))
                return "Mali is hungry and refused to sleep.";
            else {
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
                return "You put Mali to sleep.";
            }
        } else {
            if (getTiredness() <= 100) {
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
                return "Mali took a nap on his own.\n";
            }
            return "";
        }
    }

    public String play(int value) {
        if (value == 20) {
            if (getSickness() >= random.nextInt(150))
                return "Mali is sick and refused to play.";
            else {
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
                return "You played with Mali.";
            }
        } else {
            if (getBoredom() <= 100) {
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
                return "Mali played on his own.\n";
            }
            return "";

        }
    }

    public String heal(int value) {
        setTiredness(getTiredness() - value > 0 ? getTiredness() - value : 0);
        setHunger(getHunger() - value > 0 ? getHunger() - value : 0);
        setThirst(getThirst() - value > 0 ? getThirst() - value : 0);
        setBoredom(getBoredom() - value > 0 ? getBoredom() - value : 0);
        setSickness(getSickness() - value > 0 ? getSickness() - value : 0);
        if (value == 20)
            return "You made Mali feel better.";
        else {
            if (getSickness() <= 100)
                return "Mali self medicated.\n";
            return "";
        }
    }

    public String displayStats() {
        return "Hunger: " + getHunger() + "%     " + "Thirst: " + getThirst() + "%     " +
                "Tiredness: " + getTiredness() + "%     " + "Boredom: " + getBoredom() +
                "%     " + "Sickness: " + getSickness() + "%\n";
    }

    public String performPriorityNeed() {
        int[] arr = { getHunger(), getThirst(), getTiredness(), getBoredom(), getSickness() };
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == 0)
            return feed(5);
        else if (index == 1)
            return hydrate(5);
        else if (index == 2)
            return rest(5);
        else if (index == 3)
            return play(5);
        else
            return heal(5);
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
