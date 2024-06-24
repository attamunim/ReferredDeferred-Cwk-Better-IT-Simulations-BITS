package RefDefCwk;
import java.io.Serializable;
/**
 * Enumeration class JobType - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import java.io.Serializable;

public class Job implements Serializable {
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

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public int getReward() {
        return reward;
    }

    public int getComplexity() {
        return complexity;
    }

    @Override
    public String toString() {
        return id + ", " + type + ", " + duration + ", " + reward + ", " + complexity;
    }
}

