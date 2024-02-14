import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private String classroom;
    private List<Student> students;
    private Teacher teacher;
    private int duration;

    public Class(String name, String classroom, int duration) {
        this.name = name;
        this.classroom = classroom;
        this.duration = duration;
        this.students = new ArrayList<>();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
