package RefDefCwk;

public class Job {
    private int id;
    private String type;
    private int duration;
    private int reward;
    private int complexity;

    public Job(int id, String type, int duration, int reward, int complexity) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.reward = reward;
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return id + ", " + type + ", " + duration + ", " + reward + ", " + complexity;
    }
}
