import java.util.Scanner;

public class Menu {
    private static University university = new University();
    private static Scanner scan = new Scanner(System.in);
    public static void VirtualUniversity() {

        //Initialize 2 teachers of each type
        initializeTeachers();

        //Initialize 6 different students
        initializeStudents();

        //Initialize 4 different classes
        initializeClasses();

        //************************************************************
        System.out.println("Welcome to the university!");

        int code = 2024121146;
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
                    option1();
                    break;
                case "2":
                    option2();
                    break;
                case "3":
                    option3(code);
                    code++;
                    break;
                case "4":
                    option4();
                    break;
                case "5":
                    option5();
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

    private static void initializeStudents(){
        Student student1 = new Student(202412131, "Juan Rodriguez",17);
        university.addStudent(student1);

        Student student2 = new Student(202412141, "Sophia Cortez",19);
        university.addStudent(student2);

        Student student3 = new Student(202412142, "Julianna Yanqueen",16);
        university.addStudent(student3);

        Student student4 = new Student(2024121143, "Mario Hernandez",18);
        university.addStudent(student4);

        Student student5 = new Student(2024121144, "Felipe Ortega",19);
        university.addStudent(student5);

        Student student6 = new Student(2024121145, "Camille Villegas",18);
        university.addStudent(student6);
    }

    private static void initializeClasses(){
        Class class1 = new Class("Math", "ML-1001", 2);
        class1.addStudent(university.getStudent(0));
        class1.addStudent(university.getStudent(1));
        class1.addStudent(university.getStudent(2));
        class1.setTeacher(university.getTeacher(1));
        university.addClass(class1);

        Class class2 = new Class("English", "B-3002", 3);
        class2.addStudent(university.getStudent(5));
        class2.addStudent(university.getStudent(4));
        class2.addStudent(university.getStudent(3));
        class2.setTeacher(university.getTeacher(2));
        university.addClass(class2);

        Class class3 = new Class("History", "C-2015", 1);
        class3.addStudent(university.getStudent(0));
        class3.addStudent(university.getStudent(2));
        class3.addStudent(university.getStudent(4));
        class3.setTeacher(university.getTeacher(3));
        university.addClass(class3);

        Class class4 = new Class("Spanish", "C-1009", 3);
        class4.addStudent(university.getStudent(1));
        class4.addStudent(university.getStudent(3));
        class4.addStudent(university.getStudent(5));
        class4.setTeacher(university.getTeacher(0));
        university.addClass(class4);

    }
    private static void option1(){
        university.printAllTeachers();
    }
    private static void option2() {
        university.printClassesName();
        System.out.println("Please enter the number corresponding to the class:  ");
        String classInput = scan.nextLine();
        int index = 0;
        if (classInput.matches("^\\d+$")) {
            index = Integer.parseInt(classInput);
            if(index > university.getNumberOfClasses()){
                System.out.println("Invalid number. Please try again");
                return;
            }
        } else {
            System.out.println("Invalid number. Please try again");
            return;
        }
        university.printClassInfo(index-1);
    }
    private static void option3(int code) {
        //get the student info
        System.out.println("Please enter the student name: ");
        String name = scan.nextLine();
        System.out.println("Please enter the student age: ");
        String ageInput = scan.nextLine();
        int age = 0;
        if (ageInput.matches("^\\d+$")) {
            age = Integer.parseInt(ageInput);
        } else {
            System.out.println("Invalid age. Please try again");
            return;
        }

        Student student = new Student(code, name, age);

        //print all the classes in the university
        university.printAllClasses();
        System.out.println("Please enter the number corresponding to the class in which you wish to enroll the student:  ");
        String classInput = scan.nextLine();
        int index = 0;
        if (classInput.matches("^\\d+$")) {
            index = Integer.parseInt(classInput);
            if(index > university.getNumberOfClasses()){
                System.out.println("Invalid number. Please try again");
                return;
            }
        } else {
            System.out.println("Invalid number. Please try again");
            return;
        }

        Class course = university.getClass(index-1);

        //Validate if student is in the class
        boolean isInClass = course.validateStudentInClass(student.getId());
        if(!isInClass) {
            course.addStudent(student);
            System.out.println("The student was added correctly.");
        }else {
            System.out.println("Sorry the student is already in this class. Please try again");
        }
    }
    private static void option4(){
        //get the class info
        System.out.println("Please enter the class name: ");
        String name = scan.nextLine();
        System.out.println("Please enter the class classroom (e.g. ML-2002): ");
        String classroomInput = scan.nextLine();
        String classroom;
        if (classroomInput.matches("^[A-Z]{1,2}-\\d{4}$")) {
            classroom = classroomInput;
        }else {
            System.out.println("Invalid classroom. Please try again");
            return;
        }
        System.out.println("Please enter the class duration (in hours): ");
        String durationInput = scan.nextLine();
        int duration = 0;
        if (durationInput.matches("^\\d")) {
            duration = Integer.parseInt(durationInput);
        } else {
            System.out.println("Invalid duration. Please try again");
            return;
        }

        Class course = new Class(name,classroom,duration);

        //print all the teachers in the university
        university.printAllTeachers();
        System.out.println("Please enter the number corresponding to the teacher you want to add to the class:  ");
        String teacherInput = scan.nextLine();
        int index = 0;
        if (teacherInput.matches("^\\d+$")) {
            index = Integer.parseInt(teacherInput);
            if(index > university.getNumberOfTeachers() || index == 0){
                System.out.println("Invalid number. Please try again");
                return;
            }
        } else {
            System.out.println("Invalid number. Please try again");
            return;
        }

        Teacher teacher = university.getTeacher(index-1);
        if (teacher instanceof PartTimeTeacher){
            int hours = ((PartTimeTeacher) teacher).getActiveHoursPerWeek();
            ((PartTimeTeacher) teacher).setActiveHoursPerWeek(hours+duration);
            double salary = ((PartTimeTeacher) teacher).calculateSalary();
            teacher.setSalary(salary);
        }
        course.setTeacher(teacher);
        System.out.println("The teacher was added correctly.");

        //print all the students in the university
        System.out.println("Please enter the number of students you wish to add to the class:  ");
        String numStudentsInput = scan.nextLine();
        index = 0;
        if (numStudentsInput.matches("^\\d+$") ) {
            index = Integer.parseInt(numStudentsInput);
            if(index > university.getNumberOfStudents()){
                System.out.println("Invalid number. Please try again");
                removeHours(teacher,duration);
                return;
            }
        } else {
            System.out.println("Invalid number. Please try again");
            removeHours(teacher,duration);
            return;
        }
        university.printAllStudents();
        int i = 0;
        do {
            System.out.println("Please enter the number corresponding to the student you want to add to the class:  ");
            String studentInput = scan.nextLine();
            int studentIndex = 0;
            if (studentInput.matches("^\\d+$")) {
                studentIndex = Integer.parseInt(studentInput);
                if(studentIndex > university.getNumberOfStudents() || studentIndex == 0){
                    System.out.println("Invalid number. Please try again");
                    removeHours(teacher,duration);
                    return;
                }else if (course.validateStudentInClass(university.getStudent(studentIndex-1).getId())){
                    System.out.println("Sorry the student is already in this class. Please try again");
                    removeHours(teacher,duration);
                    return;
                }
            } else {
                System.out.println("Invalid number. Please try again");
                removeHours(teacher,duration);
                return;
            }
            Student student = university.getStudent(studentIndex-1);
            course.addStudent(student);
            i++;
        }
        while (i < index);
        System.out.println("The students were added correctly.");
        university.addClass(course);
    }
    private static void option5(){
        System.out.println("Please enter the student id: ");
        String idInput = scan.nextLine();
        int id = 0;
        if (idInput.matches("^\\d+$")) {
            id = Integer.parseInt(idInput);
        } else {
            System.out.println("Invalid id. Please try again");
            return;
        }
        university.printClassesByStudent(id);
    }

    private static void removeHours(Teacher teacher, int duration){
        if (teacher instanceof PartTimeTeacher){
            int hours = ((PartTimeTeacher) teacher).getActiveHoursPerWeek();
            ((PartTimeTeacher) teacher).setActiveHoursPerWeek(hours-duration);
            double salary = ((PartTimeTeacher) teacher).calculateSalary();
            teacher.setSalary(salary);
        }
    }
}
