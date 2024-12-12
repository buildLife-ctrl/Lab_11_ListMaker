import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.*;

public class Main {
    static ArrayList<String> list = new ArrayList<String>(10);
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;

        System.out.print("List of fruits listed as one of each letter:");
        list.add("Apple");
        list.add("Banana");
        list.add("Carrot");
        list.add("Durian");
        list.add("Elderberry");
        list.add("Fig");
        list.add("Grapes");
        list.add("Huckleberry");
        list.add("Indian jujube");
        list.add("Jackfruit");

        displayList(); //Just so it does not keep displaying everytime
        do {
            System.out.println(); //makes it look better
            System.out.println("Options:");
            System.out.println("A - Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("P – Print the list");
            System.out.println("Q – Quit the program");
            System.out.println(); //for better structure
            String ask = getRegExString(scan, "Please pick one of the options above:", "[AaDdPpQq]");

            System.out.println(); //for better structure
            if (ask.equalsIgnoreCase("a")) {
                add(scan);
            } else if (ask.equalsIgnoreCase("d")) {
                delete(scan);
            } else if (ask.equalsIgnoreCase("p")) {
                print();
            } else {
                quit = quit(scan, "Are you sure you want to quit? [Y/N]");
            }
        } while (!quit);
    }

    public static void displayList() { //10 fruits that I came up with as letters increment
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("\n%-2s %3s", i + 1, " - ");
            System.out.printf(list.get(i));
        }
        System.out.println();
    }

    public static void add(Scanner scan) {
        String userInput = getNonZeroLenString(scan, "What would you like to add? PLease add a fruit starting" +
                " with the next letter up from the list.");
        userInput = Character.toString(userInput.charAt(0)).toUpperCase() + userInput.substring(1); //Alex helped
        //the one underneath, I came up with it all by myself with programming I know
        /*String i = valueOf(userInput.indexOf(0));
        userInput = i.toUpperCase() + userInput.substring(1);*/
        list.add(userInput);
        displayList();
    }

    public static void delete(Scanner scan) {
        int userInput = getRangedInt(scan, "Which array list value would you like to remove?" +
                "[0-" + (list.size() - 1) + "]", 0, list.size());
        list.remove(userInput);
        displayList();
    }

    public static void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-2s %3s", i, " - ");
            System.out.printf(list.get(i));
            System.out.println();
        }

        System.out.println("\nIt is printed the way it is valued in the array list!");
    }

    public static String getNonZeroLenString(Scanner scan, String prompt) {
        String input;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.length() != 0) {
                check = true;
            } else {
                System.out.println("You have to enter something, try again.");
            }
        } while (!check);

        return input;
    }

    public static boolean quit (Scanner scan, String prompt) {
        String input;
        boolean confirm = false;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                confirm = true;
                System.out.println(confirm);
                check = true;
            } else if (input.equalsIgnoreCase("n")) {
                confirm = false;
                System.out.println(confirm);
                check = true;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        } while (!check);

        return confirm;
    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern) {
        String input;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.matches(regExPattern)) {
                check = true;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        } while (!check);

        return input;
    }

    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        int num = 0;
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= min && num <= max) {
                    check = true;
                } else {
                    System.out.println("Input not within the range, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
            }
            scan.nextLine();
        } while (!check);

        return num;
    }
}
