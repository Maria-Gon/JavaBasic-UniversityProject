public class FullTimeTeacher extends Teacher implements Salary {
    private static final double multiplier = 1.1;
    private int yearsOfExperience;

    public FullTimeTeacher(String name, int yearsOfExperience) {
        super(name);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateSalary() {
        return Salary.baseSalary * (yearsOfExperience * multiplier);
    }
}
