import java.util.Scanner;

public class Menu {
    public static void VirtualUniversity() {
        University university = new University();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the university!");

        boolean running = true;
        while (running) {
            System.out.println("What option would you like to do today? (Please enter the corresponding number)" +
                    "\n 1. Print teachers" +
                    "\n 2. Print classes" +
                    "\n 3. Create a new student" +
                    "\n 4. Create a new class" +
                    "\n 5. Print student classes" +
                    "\n 6. Exit university");
            String option = scan.nextLine();

            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Exiting the university. See you soon!");
        scan.close();
    }
}
