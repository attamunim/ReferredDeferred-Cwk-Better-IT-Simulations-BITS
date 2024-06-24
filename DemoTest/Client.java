package RefDefCwk;

public class Client {
    private String clientName;
    private String projectType;

    public Client(String clientName, String projectType) {
        this.clientName = clientName;
        this.projectType = projectType;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProjectType() {
        return projectType;
    }

    @Override
    public String toString() {
        return "Client Name: " + clientName + ", Project Type: " + projectType;
    }
}
