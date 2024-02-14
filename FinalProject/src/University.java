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

    public void printAllTeachers(){
        System.out.println("****************************************");
        for(Teacher teacher : teachers){
            System.out.println("\nName: " + teacher.getName());
            System.out.println("Salary: " + teacher.getSalary());
            if (teacher instanceof FullTimeTeacher){
                System.out.println("Years of experience: " + ((FullTimeTeacher) teacher).getYearsOfExperience());
            } else if (teacher instanceof PartTimeTeacher){
                System.out.println("Active hours per week: " + ((PartTimeTeacher) teacher).getActiveHoursPerWeek());
            }
        }
        System.out.println("****************************************");
    }
}
