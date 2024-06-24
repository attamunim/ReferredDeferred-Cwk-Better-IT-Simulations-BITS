package RefDefCwk;

import java.util.List;

public interface BITS {
    boolean hireStaff(String name);
    List<String> getTeam();
    int getAccount();
    boolean isOverdrawn();
    boolean isJob(int jobId);
    String getAllJobs();
    String getStaff(String name);
    String getAllAvailableStaff();
    String doJob(int jobId);
}
