package RefDefCwk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ITProject implements BITS {
    private String manager;
    private int account;
    private List<String> team;
    private Map<String, Staff> availableStaff;
    private Map<Integer, Job> jobs;

    public ITProject(String manager, int budget) {
        this.manager = manager;
        this.account = budget;
        this.team = new ArrayList<>();
        this.availableStaff = new HashMap<>();
        this.jobs = new HashMap<>();
        setUpStaff();
        setUpJobs();
    }

    private void setUpStaff() {
        availableStaff.put("Amir", new Staff("Amir", "Designer", 2, 300, 30, false));
        availableStaff.put("Lisa", new Staff("Lisa", "Programmer", 2, 200, 20, true));
        availableStaff.put("John", new Staff("John", "Engineer", 2, 100, 30, false));
    }

    private void setUpJobs() {
        jobs.put(100, new Job(100, "Design", 3, 10, 200));
        jobs.put(101, new Job(101, "Hardware", 5, 20, 300));
        jobs.put(102, new Job(102, "Software", 7, 15, 400));
    }

    @Override
    public boolean hireStaff(String name) {
        if (availableStaff.containsKey(name) && account >= 200) {
            team.add(name);
            availableStaff.remove(name);
            account -= 200;
            return true;
        }
        return false;
    }

    @Override
    public List<String> getTeam() {
        if (team.isEmpty()) {
            return List.of("No staff hired");
        }
        return team;
    }

    @Override
    public int getAccount() {
        return account;
    }

    @Override
    public boolean isOverdrawn() {
        return account < 0;
    }

    @Override
    public boolean isJob(int jobId) {
        return jobs.containsKey(jobId);
    }

    @Override
    public String getAllJobs() {
        StringBuilder sb = new StringBuilder();
        for (Job job : jobs.values()) {
            sb.append(job).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getStaff(String name) {
        if (availableStaff.containsKey(name)) {
            return availableStaff.get(name).toString();
        }
        return "No such staff";
    }

    @Override
    public String getAllAvailableStaff() {
        StringBuilder sb = new StringBuilder();
        for (Staff staff : availableStaff.values()) {
            sb.append(staff).append("\n");
        }
        return sb.toString();
    }

    public boolean isInTeam(String name) {
        return team.contains(name);
    }

    @Override
    public String doJob(int jobId) {
        if (!jobs.containsKey(jobId)) {
            return "No such job available.";
        }

        Job job = jobs.get(jobId);
        for (String staffName : team) {
            Staff staff = availableStaff.get(staffName);
            if (staff != null && staff.isAvailable() && staff.getExperience() >= job.getComplexity()) {
                staff.setAvailable(false);
                account += job.getReward();
                return "Job " + jobId + " completed by " + staffName;
            }
        }
        return "No suitable staff available for job " + jobId;
    }
}
