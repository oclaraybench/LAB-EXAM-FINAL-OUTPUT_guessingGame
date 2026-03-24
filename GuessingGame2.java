import java.util.Scanner;
import java.util.Random;

public class GuessingGame2 {

    private String name;
    private int secret;
    private int tries;
    private final int MAX = 10;

    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("================================");
        System.out.println("     GUESS THE NUMBER GAME");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        boolean again = true;

        while (again) {
            play();
            showStats();

            System.out.print("Play again? (Y/N): ");
            String ans = sc.nextLine();

            if (ans.equalsIgnoreCase("n")) {
                again = false;
                System.out.println("Thanks for playing, " + name + "!");
            }
        }
    }

    private void play() {
        Random r = new Random();
        secret = r.nextInt(100) + 1;
        tries = 0;

        System.out.println("\nAlright " + name + ", I picked a number from 1-100.");
        System.out.println("You got " + MAX + " tries. Good luck.\n");

        while (tries < MAX) {
            tries++;

            System.out.println("Try #" + tries);
            int guess = getInput();

            if (guess == secret) {
                System.out.println("AYOOO nice one!");
                System.out.println("You got it in " + tries + " tries.");
                return;
            } 
            else if (guess < secret) {
                System.out.println("Too low bro.");
            } 
            else {
                System.out.println("Too high bro.");
            }
        }

        System.out.println("\nGame over.");
        System.out.println("The number was " + secret + ".");
    }

    private int getInput() {
        while (true) {
            System.out.print("Enter guess (1-100): ");
            String input = sc.nextLine();

            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 100) {
                    return num;
                }
            } catch (Exception e) {}

            System.out.println("Invalid input. Try again.");
        }
    }

    private void showStats() {
        String rate;

        if (tries == 1) rate = "Insane luck";
        else if (tries <= 3) rate = "Solid";
        else if (tries <= 6) rate = "Not bad";
        else if (tries <= 10) rate = "Could be better";
        else rate = "Yeah... no";

        System.out.println("\n========== STATS ==========");
        System.out.println("Player: " + name);
        System.out.println("Number: " + secret);
        System.out.println("Tries: " + (tries > MAX ? MAX : tries));
        System.out.println("Rating: " + rate);
        System.out.println("===========================\n");
    }

    public static void main(String[] args) {
        GuessingGame2 g = new GuessingGame();
        g.start();
    }
}
