package RefDefCwk;

import java.util.*;
import java.io.*;

public class ITProject implements BITS, Serializable {
    private String manager;
    private double account;
    private List<Staff> staffList;
    private List<Staff> team;
    private List<Job> jobs;

    public ITProject(String manager, double budget) {
        this.manager = manager;
        this.account = budget;
        this.staffList = new ArrayList<>();
        this.team = new ArrayList<>();
        this.jobs = new ArrayList<>();
        setUpStaff();
        setUpJobs();
    }

    private void setUpStaff() {
        staffList.add(new Staff("Amir", "Designer", 2, 300, 30, StaffState.AVAILABLE));
        staffList.add(new Staff("Lisa", "Programmer", 2, 200, 20, StaffState.AVAILABLE));
        staffList.add(new Staff("John", "Engineer", 2, 100, 30, StaffState.AVAILABLE));
    }

    private void setUpJobs() {
        jobs.add(new Job(100, "Design", 3, 10, 200));
        jobs.add(new Job(101, "Hardware", 5, 20, 300));
        jobs.add(new Job(102, "Software", 7, 15, 400));
    }

    
}

@Override
public String hireStaff(String name) {
    for (Staff staff : staffList) {
        if (staff.getName().equalsIgnoreCase(name)) {
            if (team.contains(staff)) {
                return "Already hired: " + name + "\nAccount = £" + account;
            } else if (account < staff.getSalary()) {
                return "Not enough money: " + name + "\nAccount = £" + account;
            } else {
                account -= staff.getSalary();
                staff.setState(StaffState.WORKING);
                team.add(staff);
                return "Hired: " + name + "\nAccount = £" + account;
            }
        }
    }
    return "Not found: " + name + "\nAccount = £" + account;
}

@Override
public boolean isInTeam(String name) {
    for (Staff staff : team) {
        if (staff.getName().equalsIgnoreCase(name)) {
            return true;
        }
    }
    return false;
}

@Override
public String getTeam() {
    if (team.isEmpty()) {
        return "No staff hired";
    }
    StringBuilder sb = new StringBuilder("************ TEAM ********\n");
    for (Staff staff : team) {
        sb.append(staff).append("\n");
    }
    return sb.toString();
}

@Override
public String getAllAvailableStaff() {
    StringBuilder sb = new StringBuilder("************ Staff for Hire ********\n");
    for (Staff staff : staffList) {
        if (staff.getState() == StaffState.AVAILABLE) {
            sb.append(staff).append("\n");
        }
    }
    return sb.toString();
}

@Override
public String getAllJobs() {
    StringBuilder sb = new StringBuilder("************ All Jobs ************\n");
    for (Job job : jobs) {
        sb.append(job).append("\n");
    }
    return sb.toString();
}

@Override
public boolean isJob(int num) {
    for (Job job : jobs) {
        if (job.getId() == num) {
            return true;
        }
    }
    return false;
}

@Override
public String getJob(int no) {
    for (Job job : jobs) {
        if (job.getId() == no) {
            return job.toString();
        }
    }
    return "No such job";
}

@Override
public double getAccount() {
    return account;
}

@Override
public boolean isOverdrawn() {
    return account <= 0;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder("Manager: " + manager + "\n");
    sb.append("Account: ").append(account).append("\n");
    sb.append("Overdrawn: ").append(isOverdrawn()).append("\n");
    sb.append(getTeam());
    return sb.toString();
}

@Override
public void saveITProject(String filename) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
        out.writeObject(this);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public ITProject restoreITProject(String filename) {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
        return (ITProject) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}

public void readJobs(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1].trim();
            int duration = Integer.parseInt(parts[2]);
            int reward = Integer.parseInt(parts[3]);
            int complexity = Integer.parseInt(parts[4]);
            jobs.add(new Job(id, type, duration, reward, complexity));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
