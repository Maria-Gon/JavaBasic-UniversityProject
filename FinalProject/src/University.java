import java.util.List;

public class University {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Class> classes;

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
}
