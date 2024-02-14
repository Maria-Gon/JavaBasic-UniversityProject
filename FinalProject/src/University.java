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
}
