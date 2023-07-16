package virtual_pet;

import java.util.Scanner;

public class VirtualPetShelterApp {

    static Scanner scanner = new Scanner(System.in);
    static VirtualPetShelter pets = new VirtualPetShelter();

    public static void main(String[] args) {

        initialPets();

        System.out.println("Status of your pets: ");
        while (pets.areValuesLessThan100()) {
            System.out.println("Name        |Hunger      |Thrist      |Tiredness   |Boredom     |Sickness    |");
            System.out.println("------------|------------|------------|------------|------------|------------|");
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

            inputChecker();

            int toDo = scanner.nextInt();
            System.out.println();
            if (toDo == 1) {
                System.out.println("Choose food you want to feed the pets.");
                System.out.println("1. Pet food");
                System.out.println("2. Treats");
                System.out.println("3. Left-overs");
                System.out.println("Press any number except 1 to 3 to change what you want to do.");
                System.out.println();
                System.out.print("> ");
                inputChecker();
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
            else if (toDo == 4) {
                System.out.print(
                        "Press 1 to play with a single pet. Press 2 to play with all the pets. Press any number except 1 and 2 to change what you want to do: ");
                inputChecker();
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1)
                    playSinglePet();
                else if (input == 2)
                    System.out.println(pets.playAll());
                else {
                    System.out.println("");
                    continue;
                }
            } else if (toDo == 5)
                System.out.println(pets.healAll());
            else if (toDo == 6)
                System.out.println("Did nothing.");
            else if (toDo == 7) {
                System.out.print(
                        "Press 1 to specify all stats, press 0 to discontinue the rescue process or press any number except 1 and 0 to use default stats: ");
                inputChecker();
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 0) {
                    System.out.println("You have discontinued the rescue process.\n");
                    continue;
                }
                System.out.print("Please enter Pet's name: ");
                String petName = petNameChecker();
                System.out.print("Please enter Pet's description: ");
                String description = scanner.nextLine();
                if (input == 1) {
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
                    pets.addPet(new VirtualPet(petName, description, hunger, thirst, tiredness, boredom, sickness));
                } else {
                    pets.addPet(new VirtualPet(petName, description));
                }
            } else if (toDo == 8) {
                for (VirtualPet pet : pets.getAllPets()) {
                    System.out.println("Pet name: " + pet.getName() + ", Pet description: " + pet.getDescription());
                }
                System.out.print(
                        "Please enter the name of the pet you want to adopt or press 0 to exit adoption process: ");
                String formattedName;
                scanner.nextLine();
                while (true) {
                    String name = scanner.nextLine();
                    formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                    if (pets.hasPetName(formattedName)) {
                        pets.adoptPet(formattedName);
                        System.out.println("You have adopted " + formattedName + "\n");
                        break;
                    } else if (formattedName.equalsIgnoreCase("0")) {
                        System.out.println("You discontinued the adoption process.\n");
                        break;
                    }
                    System.out.print("Pet name you entered does not exist! Please type it correctly: ");
                }
            } else {
                System.out.println("The game has been closed!");
                break;
            }
            if (pets.getAllPets().isEmpty()) {
                System.out.println("Congratulations! All pets have been adopted.");
                break;
            }
            pets.tickAll();
            System.out.println(pets.performPriorityNeedAll());
        }

        System.out.println(pets.displayMessage());

        System.out.println(pets.displayPet());
        scanner.close();
    }

    private static void inputChecker() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            System.out.print("> ");
            scanner.next();
        }
    }

    public static String petNameChecker() {
        while (true) {
            String name = scanner.nextLine();
            String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            if (!pets.hasPetName(formattedName))
                return formattedName;
            System.out.print("Pet name already exist! Please enter a different name: ");
        }
    }

    public static void playSinglePet() {
        while (true) {
            System.out.print("Enter name of the pet you want to play with: ");
            String petName = scanner.nextLine();
            String formattedName = petName.substring(0, 1).toUpperCase()
                    + petName.substring(1).toLowerCase();
            if (pets.hasPetName(formattedName)) {
                System.out.println(pets.playPet(formattedName));
                break;
            } else {
                System.out.println("Entered pet name does not exist!");
            }
        }
    }

    public static void initialPets() {
        pets.addPet(new VirtualPet("Mali", "The monkey", 10, 20, 30, 40, 50));
        pets.addPet(new VirtualPet("Kupa", "Hybrid Wolf", 50, 40, 30, 20, 10));
    }
}
