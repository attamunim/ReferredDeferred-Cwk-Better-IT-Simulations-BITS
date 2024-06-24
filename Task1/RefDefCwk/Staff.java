package RefDefCwk;

public class Staff {
    private String name;
    private String role;
    private int experience;
    private int salary;
    private int efficiency;
    private boolean isAvailable;

    public Staff(String name, String role, int experience, int salary, int efficiency, boolean isAvailable) {
        this.name = name;
        this.role = role;
        this.experience = experience;
        this.salary = salary;
        this.efficiency = efficiency;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name + ", " + role + ", " + experience + ", " + salary + ", " + efficiency + ", " + (isAvailable ? "Available" : "Not Available");
    }
}
