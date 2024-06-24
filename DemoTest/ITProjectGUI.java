hireBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(myFrame, "Enter Staff name:");
        String role = JOptionPane.showInputDialog(myFrame, "Enter Staff role:");
        int experience = Integer.parseInt(JOptionPane.showInputDialog(myFrame, "Enter Staff experience:"));
        int salary = Integer.parseInt(JOptionPane.showInputDialog(myFrame, "Enter Staff salary:"));
        int efficiency = Integer.parseInt(JOptionPane.showInputDialog(myFrame, "Enter Staff efficiency:"));
        StaffState state = StaffState.valueOf(JOptionPane.showInputDialog(myFrame, "Enter Staff state (AVAILABLE/WORKING/ON_HOLIDAY):"));
        
        project.addStaffMember(name, role, experience, salary, efficiency, state);
        listing.setText("Added new staff: " + name);
    }
});
