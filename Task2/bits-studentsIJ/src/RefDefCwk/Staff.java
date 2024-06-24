package RefDefCwk;

import java.io.Serializable;

public class Staff implements Serializable {
    private String name;
    private String role;
    private int experience;
    private int salary;
    private int efficiency;
    private StaffState state;

    public Staff(String name, String role, int experience, int salary, int efficiency, StaffState state) {
        this.name = name;
        this.role = role;
        this.experience = experience;
        this.salary = salary;
        this.efficiency = efficiency;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public StaffState getState() {
        return state;
    }

    public void setState(StaffState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return name + ", " + role + ", " + experience + ", " + salary + ", " + efficiency + ", " + state;
    }
}
