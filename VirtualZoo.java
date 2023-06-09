import java.util.ArrayList;
import java.util.Scanner;
/**
 * Driver class for the virtual zoo application.
 *
 * @author
 * Ranjul Grover
 * 2298044
 * grov0094
 */
public class VirtualZoo {

    private final Scanner scan;
    private final ArrayList<String> usedNames;
    public static int totalCost;

    public VirtualZoo() {
        scan = new Scanner(System.in);
        usedNames = new ArrayList<>();
        totalCost = 0;
    }

    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    //-------------------------operational methods------------------------------

    /**
     * Defines the Welcome Message text
     */
    private void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|   Use this application to simulate running a zoo with many animals   |");
        System.out.println("|           This program is intended for zoo employees only            |");
        System.out.println("+----------------------------------------------------------------------+");
    }

    /**
     * Asks the user how many animals are present in the zoo
     * and verifies that the response is a positive integer
     * @return the number of animals as an integer
     */
    private int askNumberAnimals() {
        int numAnimals = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("How many animals are at your zoo?");
            String input = scan.nextLine();
            try {
                numAnimals = Integer.parseInt(input);
                if (numAnimals > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive number of animals");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number of animals");
            }
        }
        return numAnimals;
    }

    /**
     * Asks the user for the name of the animal with the specified ID
     * and verifies that the name is unique
     * @param id the ID of the animal
     * @return the name of the animal as a string
     */
    private String askAnimalName(int id) {
        String animalName = "";
        boolean uniqueName = false;
        while (!uniqueName) {
            System.out.println("What is the name of animal #" + id + "?");
            animalName = scan.nextLine();
            if (!usedNames.contains(animalName)) {
                usedNames.add(animalName);
                uniqueName = true;
            } else {
                System.out.println("That name is already taken");
            }
        }
        return animalName;
    }

    private Animal askAnimalSpecies(String animalName) {
        Animal animal= null;
        boolean validSpecies = false;
        while (!validSpecies) {
            System.out.println("What is the species of " + animalName + "?");
            String species = scan.nextLine().trim().toLowerCase();

            switch (species) {
                case "tiger":
                    animal = new Tiger(animalName);
                    validSpecies = true;
                    break;
                case "elephant":
                    animal = new Elephant(animalName);
                    validSpecies = true;
                    break;
                case "rhino":
                    animal = new Rhino(animalName);
                    validSpecies = true;
                    break;
                case "panda":
                    animal = new Panda(animalName);
                    validSpecies = true;
                    break;
                case "monkey":
                    animal = new Monkey(animalName);
                    validSpecies = true;
                    break;
                default:
                    System.out.println("That is not a valid species");
                    animal = null;
            }
        }

        return animal;
    }


    /**
     * Asks the user how many animals are present in the zoo
     * and gathers the name and species of each animal
     * @return an ArrayList of Animal objects representing all the animals in the zoo
     */
    private ArrayList<Animal> animalSelection() {
        ArrayList<Animal> animals = new ArrayList<>();
        int numAnimals = askNumberAnimals();
        System.out.println();
        for (int i = 1; i <= numAnimals; i++) {
            String animalName = askAnimalName(i);
            Animal animal = askAnimalSpecies(animalName);
            animals.add(animal);
        }
        return animals;
    }

    public void askItem(Animal animal) {
        boolean validItem = false;
        String previousItem = animal.getPreviousItem();

        while (!validItem) {
            System.out.println("What item would you like to give to " + animal.getName() + "?");
            String item = scan.nextLine().trim().toLowerCase();

            if (item.equals(previousItem)) {
                System.out.println("You cannot give the same item as yesterday");
                continue;
            }

            switch (item) {
                case "food":
                    animal.giveFood(totalCost);
                    validItem = true;
                    break;
                case "water":
                    animal.giveWater(totalCost);
                    validItem = true;
                    break;
                case "toy":
                    animal.giveToy(totalCost);
                    validItem = true;
                    break;
                default:
                    System.out.println("That is not a valid item");
            }

            previousItem = item;
            animal.setPreviousItem(previousItem);
        }
    }

    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : daysOfWeek) {

            System.out.println("\n"+"The current day is " + day + "\n");
            for (Animal animal : zooAnimals) {
                System.out.println(animal);
            }

            for (Animal animal : zooAnimals) {
                if (!animal.isDead()) {
                    askItem(animal);
                }
            }

        }
        System.out.println("\n"+"Total week cost = $" + totalCost);
    }


    public static void main(String[] args) {
        VirtualZoo zoo = new VirtualZoo();
        zoo.beginSimulation();

    }

}
