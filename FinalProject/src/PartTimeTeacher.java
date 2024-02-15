public class PartTimeTeacher extends Teacher implements Salary{
    private int activeHoursPerWeek;
    private static final double weeks = 4.4;

    public PartTimeTeacher(String name, int activeHours) {
        super(name);
        this.activeHoursPerWeek = activeHours;
    }

    @Override
    public double calculateSalary() {
        return Salary.baseSalary * activeHoursPerWeek * weeks;
    }

    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }
}
