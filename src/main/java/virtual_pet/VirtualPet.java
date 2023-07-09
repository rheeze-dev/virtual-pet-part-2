package virtual_pet;

import java.util.Random;

public class VirtualPet {
    private int hunger = 30;
    private int thirst = 30;
    private int tiredness = 20;
    private int boredom = 20;
    private int sickness = 10;
    Random random = new Random();

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
        performPriorityNeed();
    }

    public void feed(int value) {
        if (value == 30 || value == 20) {
            if (getBoredom() >= random.nextInt(150))
                System.out.println("Mali is bored and refused to eat.");
            else {
                System.out.println("You fed Mali.");
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + 20);
            }
        } else {
            if (getHunger() <= 100) {
                System.out.println("Mali ate on his own.");
                System.out.println();
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + value);
            }
        }
    }

    public void hydrate(int value) {
        if (value == 20) {
            System.out.println("You gave water to Mali.");
        } else {
            if (getThirst() <= 100) {
                System.out.println("Mali drank water on his own.");
                System.out.println();
            }
        }
        setThirst(getThirst() - value < 0 ? 0 : getThirst() - value);
    }

    public void rest(int value) {
        if (value == 20) {
            if (getHunger() >= random.nextInt(150))
                System.out.println("Mali is hungry and refused to sleep.");
            else {
                System.out.println("You put Mali to sleep.");
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
            }
        } else {
            if (getTiredness() <= 100) {
                System.out.println("Mali took a nap on his own.");
                System.out.println();
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
            }
        }
    }

    public void play(int value) {
        if (value == 20) {
            if (getSickness() >= random.nextInt(150))
                System.out.println("Mali is sick and refused to play.");
            else {
                System.out.println("You played with Mali.");
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
            }
        } else {
            if (getBoredom() <= 100) {
                System.out.println("Mali played on his own.");
                System.out.println();
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
            }
        }
    }

    public void heal(int value) {
        if (value == 20)
            System.out.println("You made Mali feel better.");
        else {
            if (getSickness() <= 100) {
                System.out.println("Mali self medicated.");
                System.out.println();
            }
        }
        setTiredness(getTiredness() - value > 0 ? getTiredness() - value : 0);
        setHunger(getHunger() - value > 0 ? getHunger() - value : 0);
        setThirst(getThirst() - value > 0 ? getThirst() - value : 0);
        setBoredom(getBoredom() - value > 0 ? getBoredom() - value : 0);
        setSickness(getSickness() - value > 0 ? getSickness() - value : 0);
    }

    public void displayStats() {
        System.out.print("Hunger: " + getHunger() + "%     ");
        System.out.print("Thirst: " + getThirst() + "%     ");
        System.out.print("Tiredness: " + getTiredness() + "%     ");
        System.out.print("Boredom: " + getBoredom() + "%     ");
        System.out.print("Sickness: " + getSickness() + "%     ");
        System.out.println();
    }

    private void performPriorityNeed() {
        int[] arr = { getHunger(), getThirst(), getTiredness(), getBoredom(), getSickness() };
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == 0) {
            feed(5);
        } else if (index == 1) {
            hydrate(5);
        } else if (index == 2) {
            rest(5);
        } else if (index == 3) {
            play(5);
        } else {
            heal(5);
        }
    }
}
