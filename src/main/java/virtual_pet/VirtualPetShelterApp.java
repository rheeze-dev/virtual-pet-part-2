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
            System.out.println("What do you want to do?");
            System.out.println("1. Give food to pets");
            System.out.println("2. Give water to pets");
            System.out.println("3. Make pets rest");
            System.out.println("4. Play with pets");
            System.out.println("5. Cure pets");
            System.out.println("6. Do nothing");
            System.out.println("7. Rescue a pet");
            System.out.println("8. Adopt a pet");
            System.out.println("Enter any number except 1 to 8 to quit the game.");
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
                System.out.println("Choose food you want to feed the pets.");
                System.out.println("1. Pet foods");
                System.out.println("2. Treats");
                System.out.println("3. Left-overs");
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
                    System.out.println("Pet food are pets favorite food.");
                    System.out.println(pets.feedAll(30));
                } else if (food == 2) {
                    System.out.println("Treats are pets 2nd favorite food.");
                    System.out.println(pets.feedAll(20));
                } else if (food == 3) {
                    System.out.println("Left-overs are pets worst food. Pet refused to eat it.");
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
            else if (toDo == 7) {
                System.out.print("Please enter Pet's name: ");
                String name = scanner.next();
                String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                System.out.print("Please enter Pet's description: ");
                String description = scanner.next();
                System.out.print("Please enter Pet's hunger level (any number from 0 to 99): ");
                int hunger = scanner.nextInt();
                System.out.print("Please enter Pet's thirst level (any number from 0 to 99): ");
                int thirst = scanner.nextInt();
                System.out.print("Please enter Pet's tiredness level (any number from 0 to 99): ");
                int tiredness = scanner.nextInt();
                System.out.print("Please enter Pet's boredom level (any number from 0 to 99): ");
                int boredom = scanner.nextInt();
                System.out.print("Please enter Pet's sickness level (any number from 0 to 99): ");
                int sickness = scanner.nextInt();
                System.out.println();
                pets.addPet(formattedName, description, hunger, thirst, tiredness, boredom, sickness);
            } else if (toDo == 8) {
                for (VirtualPet pet : pets.getAllPets()) {
                    System.out
                            .println("Pet name: " + pet.getName() + ", Pet description: " + pet.getDescription());
                }
                System.out.print("Please enter the name of the pet you want to adopt: ");
                String name = scanner.next();
                String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                pets.adoptPet(formattedName);
                System.out.println("You have adopted " + formattedName + "\n");
            }

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
