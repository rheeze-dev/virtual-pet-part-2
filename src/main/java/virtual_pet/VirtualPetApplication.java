package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        VirtualPet virtualPet = new VirtualPet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mali the monkey");
        while (virtualPet.getHunger() <= 100 && virtualPet.getThirst() <= 100 && virtualPet.getTiredness() <= 100
                && virtualPet.getBoredom() <= 100 && virtualPet.getSickness() <= 100) {
            virtualPet.displayStats();
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
                    virtualPet.feed(30);
                } else if (food == 2) {
                    System.out.println("Insects are Mali's 2nd favorite food.");
                    virtualPet.feed(20);
                } else if (food == 3) {
                    System.out.println("Snails are Mali's worst food. Mali refused to eat it.");
                } else
                    continue;
            } else if (toDo == 2)
                virtualPet.hydrate(20);
            else if (toDo == 3)
                virtualPet.rest(20);
            else if (toDo == 4)
                virtualPet.play(20);
            else if (toDo == 5)
                virtualPet.heal(20);
            else if (toDo == 6)
                System.out.println("Did nothing.");
            else {
                System.out.println("The game has been closed!");
                break;
            }
            virtualPet.tick();
        }
        if (virtualPet.getHunger() >= 100)
            System.out.println("Mali starved!");
        else if (virtualPet.getThirst() >= 100)
            System.out.println("Mali got dehydrated!");
        else if (virtualPet.getTiredness() >= 100)
            System.out.println("Mali got soo tired!");
        else if (virtualPet.getBoredom() >= 100)
            System.out.println("Mali got soo bored!");
        else if (virtualPet.getSickness() >= 100)
            System.out.println("Mali got soo sick!");

        System.out.println("      __");
        System.out.println(" w  c(..)o   (");
        System.out.println("  \\__(-)    __)");
        System.out.println("      /\\   (");
        System.out.println("     /(_)___)");
        System.out.println("    w /|");
        System.out.println("      | \\");
        System.out.println("      m  m");
        scanner.close();
    }
}
