import java.util.Scanner;

public class Menu {
    private static University university = new University();
    public static void VirtualUniversity() {

        //Initialize 2 teachers of each type
        initializeTeachers();

        //************************************************************
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the university!");

        boolean running = true;
        while (running) {
            System.out.println("\nWhat option would you like to do today? (Please enter the corresponding number)" +
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

    private static void initializeTeachers(){
        FullTimeTeacher fullTimeTeacher1 = new FullTimeTeacher("Carlos Acosta", 35);
        double salaryFullTimeTeacher1 = fullTimeTeacher1.calculateSalary();
        fullTimeTeacher1.setSalary(salaryFullTimeTeacher1);
        university.addTeacher(fullTimeTeacher1);

        FullTimeTeacher fullTimeTeacher2 = new FullTimeTeacher("Marta Bolaños", 40);
        double salaryFullTimeTeacher2 = fullTimeTeacher2.calculateSalary();
        fullTimeTeacher2.setSalary(salaryFullTimeTeacher2);
        university.addTeacher(fullTimeTeacher2);

        PartTimeTeacher partTimeTeacher1 = new PartTimeTeacher("Angie Castañeda",3);
        double salaryPartTimeTeacher1 = partTimeTeacher1.calculateSalary();
        partTimeTeacher1.setSalary(salaryPartTimeTeacher1);
        university.addTeacher(partTimeTeacher1);

        PartTimeTeacher partTimeTeacher2 = new PartTimeTeacher("Diego Diaz",1);
        double salaryPartTimeTeacher2 = partTimeTeacher2.calculateSalary();
        partTimeTeacher2.setSalary(salaryPartTimeTeacher2);
        university.addTeacher(partTimeTeacher2);
    }

}
