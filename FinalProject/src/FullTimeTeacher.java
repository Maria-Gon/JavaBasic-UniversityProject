public class FullTimeTeacher extends Teacher implements Salary {
    private static final double multiplier = 1.1;

    public FullTimeTeacher(String name) {
        super(name);
    }

    @Override
    public double calculateSalary() {
        return Salary.baseSalary * multiplier;
    }
}
