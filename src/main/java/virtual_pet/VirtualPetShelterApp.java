package virtual_pet;

import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {

        VirtualPetShelter pets = new VirtualPetShelter();

        pets.addPet("Mali", "The monkey", 10, 20, 30, 40, 50);
        pets.addPet("Akita", "Hybrid Wolf", 50, 40, 30, 20, 10);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Status of your pets: ");
        while (pets.areValuesLessThan100()) {
            System.out.println("Name     |Hunger   |Thrist   |Tiredness|Boredom  |Sickness |");
            System.out.println("---------|---------|---------|---------|---------|---------|");
            System.out.println(pets.displayStatsAll());
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Give food to Mali");
            System.out.println("2. Give water to Mali");
            System.out.println("3. Make Mali rest");
            System.out.println("4. Play with Mali");
            System.out.println("5. Cure Mali");
            System.out.println("6. Do nothing");
            System.out.println("Enter any number except 1 to 6 to quit the game.");
            System.out.println();
            System.out.print("> ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                System.out.print("> ");
                scanner.next();
            }

            int toDo = scanner.nextInt();
            System.out.println();
            if (toDo == 1) {
                System.out.println("Choose food you want to feed Mali.");
                System.out.println("1. Bananas");
                System.out.println("2. Insects");
                System.out.println("3. Snails");
                System.out.println("Press any number except 1 to 3 to change what you want to do.");
                System.out.println();
                System.out.print("> ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    System.out.print("> ");
                    scanner.next();
                }

                int food = scanner.nextInt();
                System.out.println();
                if (food == 1) {
                    System.out.println("Bananas are Mali's favorite food.");
                    System.out.println(pets.feedAll(30));
                } else if (food == 2) {
                    System.out.println("Insects are Mali's 2nd favorite food.");
                    System.out.println(pets.feedAll(20));
                } else if (food == 3) {
                    System.out.println("Snails are Mali's worst food. Mali refused to eat it.");
                } else
                    continue;
            } else if (toDo == 2)
                System.out.println(pets.hydrateAll());
            else if (toDo == 3)
                System.out.println(pets.restAll());
            else if (toDo == 4)
                System.out.println(pets.playAll());
            else if (toDo == 5)
                System.out.println(pets.healAll());
            else if (toDo == 6)
                System.out.println("Did nothing.");
            else {
                System.out.println("The game has been closed!");
                break;
            }
            pets.tickAll();
            System.out.println(pets.performPriorityNeedAll());
        }

        System.out.println(pets.displayMessage());

        System.out.println(pets.displayPet());
        scanner.close();
    }
}
