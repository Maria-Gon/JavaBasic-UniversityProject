import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Class> classes;

    public University() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public Teacher getTeacher(int index) {
        return teachers.get(index);
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(int index){
        return students.get(index);
    }

    public void addClass(Class course){
        classes.add(course);
    }

    public Class getClass(int index){
        return classes.get(index);
    }

    public int getNumberOfClasses() {
        return classes.size();
    }

    public void printAllTeachers(){
        System.out.println("****************************************");
        int i = 1;
        for(Teacher teacher : teachers){
            System.out.println("\n"+ (i) + ". "+"Name: " + teacher.getName());
            System.out.println("Salary: " + teacher.getSalary());
            if (teacher instanceof FullTimeTeacher){
                System.out.println("Years of experience: " + ((FullTimeTeacher) teacher).getYearsOfExperience());
            } else if (teacher instanceof PartTimeTeacher){
                System.out.println("Active hours per week: " + ((PartTimeTeacher) teacher).getActiveHoursPerWeek());
            }
            i++;
        }
        System.out.println("****************************************");
    }

    public void printClassesName(){
        System.out.println("****************************************");
        int i = 1;
        for(Class course : classes){
            System.out.println("\n"+ (i) + ". " + course.getName());
            i++;
        }
        System.out.println("****************************************");
    }

    public void printClassInfo(int index){
        System.out.println("****************************************");
        System.out.println("\nName: " + classes.get(index).getName());
        System.out.println("Classroom: " + classes.get(index).getClassroom());
        System.out.println("Duration: " + classes.get(index).getDuration());
        System.out.println("Teacher: \n");
        System.out.println("    Name: " + classes.get(index).getTeacher().getName());
        System.out.println("    Salary: " + classes.get(index).getTeacher().getSalary());
        if (classes.get(index).getTeacher() instanceof FullTimeTeacher){
            System.out.println("    Years of experience: " + ((FullTimeTeacher) classes.get(index).getTeacher()).getYearsOfExperience());
        } else if (classes.get(index).getTeacher() instanceof PartTimeTeacher){
            System.out.println("    Active hours per week: " + ((PartTimeTeacher) classes.get(index).getTeacher()).getActiveHoursPerWeek());
        }
        System.out.println("\nStudents: ");
        classes.get(index).printStudentsInClass();
        System.out.println("****************************************");
    }

    public void printAllClasses(){
        System.out.println("****************************************");
        int i = 1;
        for(Class course : classes){
            System.out.println("\n"+ (i) + ". "+"Name: " + course.getName());
            System.out.println("Classroom: " + course.getClassroom());
            System.out.println("Duration: " + course.getDuration());
            System.out.println("Teacher: " + course.getTeacher().getName());
            i++;
        }
        System.out.println("****************************************");
    }

    public void printClassesByStudent(int id){
        System.out.println("****************************************");
        int i = 1;
        for(Class course : classes){
            if (course.validateStudentInClass(id)){
                System.out.println("\n"+ (i) + ". "+"Name: " + course.getName());
                System.out.println("Classroom: " + course.getClassroom());
                System.out.println("Duration: " + course.getDuration());
                System.out.println("Teacher: " + course.getTeacher().getName());
                i++;
            }
        }
        System.out.println("****************************************");
    }
}
