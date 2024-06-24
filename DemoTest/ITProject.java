public void addStaffMember(String name, String role, int experience, int salary, int efficiency, StaffState state) {
    Staff newStaff = new Staff(name, role, experience, salary, efficiency, state);
    staffList.add(newStaff);
}

// Usage example
ITProject project = new ITProject("Alice", 1000);
project.addStaffMember("New Staff", "Tester", 1, 150, 10, StaffState.AVAILABLE);
