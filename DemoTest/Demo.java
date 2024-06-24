package RefDefCwk;

public class Demo {
    public static void main(String[] args) {
        ITProject project = new ITProject("Alice", 1000);

        System.out.println("Initial Project State:");
        System.out.println(project);

        System.out.println("\nHiring Amir:");
        System.out.println(project.hireStaff("Amir"));
        System.out.println(project.getTeam());

        System.out.println("\nDoing Job 100:");
        System.out.println(project.doJob(100));
        System.out.println(project.getAccount());
        
        System.out.println("\nHiring Bela:");
        System.out.println(project.hireStaff("Bela"));
        System.out.println(project.getTeam());

        System.out.println("\nAvailable Staff:");
        System.out.println(project.getAllAvailableStaff());

        System.out.println("\nAll Jobs:");
        System.out.println(project.getAllJobs());
    }
}
