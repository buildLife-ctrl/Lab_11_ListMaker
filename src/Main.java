import java.applet.Applet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList<String>(10);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean quit = false;

        System.out.print("List of fruits listed as one of each letter:");

        do {
            displayList();

            System.out.println();
            System.out.println("Options:");
            System.out.println("A - Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("P – Print the list");
            System.out.println("Q – Quit the program");
            System.out.println();
            String ask = getRegExString(scan, "Please pick one of the options above:", "[AaDdPpQq]");
            if (ask.equalsIgnoreCase("a")) {
                add(scan);
            }

            quit = quit(scan, "\nWould you like to quit? [Y/N]");
        } while (!quit);
    }

    public static void displayList() { //10 fruits that I came up with as letters increment
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

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("\n%-2s %3s", i + 1, " - ");
            System.out.printf(list.get(i));
        }
        System.out.println();
    }

    public static String add(Scanner scan) {
        String userInput = getNonZeroLenString(scan, "What would you like to add?");
        list.add(userInput);
        displayList();
        return userInput;
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
}
