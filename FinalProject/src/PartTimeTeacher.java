public class PartTimeTeacher extends Teacher{
    private int activeHoursPerWeek;
    private static final double weeks = 4.4;


    public PartTimeTeacher(String name, int activeHours) {
        super(name);
        this.activeHoursPerWeek = activeHours;
    }

    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }
}
