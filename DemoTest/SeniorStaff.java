package RefDefCwk;

public class SeniorStaff extends Staff {
    private int seniorityLevel;

    public SeniorStaff(String name, String role, int experience, int salary, int efficiency, StaffState state, int seniorityLevel) {
        super(name, role, experience, salary, efficiency, state);
        this.seniorityLevel = seniorityLevel;
    }

    public int getSeniorityLevel() {
        return seniorityLevel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Seniority Level: " + seniorityLevel;
    }
}
