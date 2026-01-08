package model;

import org.json.JSONObject;
import persistence.Writable;

// User class allows us to make separate instances of different trackers and journals for
// different users so that multiple people can work on the app. It basically just creates distinct
// instantiations of all necessary classes for each user on the app and consists only of
// get methods
public class User implements Writable {
    private String name;
    private Journal journal;
    private HabitTracker habitTracker;
    private VisionTracker visionTracker;
    private AchievementTracker achievementTracker;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Constructs a new user with corresponding name and a new Journal, HabitTracker, VisionTracker
    //          and AchievementTracker.
    public User(String name) {
        this.name = name;
        journal = new Journal();
        habitTracker = new HabitTracker();
        visionTracker = new VisionTracker();
        achievementTracker = new AchievementTracker();
    }

    // EFFECTS: Constructs a new user with corresponding name, Journal, HabitTracker, VisionTracker
    //          and AchievementTracker.
    public User(String name, Journal journal, HabitTracker habitTracker,
                VisionTracker visionTracker, AchievementTracker achievementTracker) {
        this.name = name;
        this.journal = journal;
        this.habitTracker = habitTracker;
        this.visionTracker = visionTracker;
        this.achievementTracker = achievementTracker;
    }


    // EFFECTS: Returns Journal For User
    public Journal getJournal() {
        return journal;
    }

    // EFFECTS: Returns HabitTracker For User
    public HabitTracker getHabitTracker() {
        return habitTracker;
    }

    // EFFECTS: Returns VisionTracker For User
    public VisionTracker getVisionTracker() {
        return visionTracker;
    }

    // EFFECTS: Returns AchievementTracker For User
    public AchievementTracker getAchievementTracker() {
        return achievementTracker;
    }

    // EFFECTS: Returns name of User
    public String getName() {
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Journal", journal.toJson());
        json.put("HabitTracker", habitTracker.toJson());
        json.put("VisionTracker", visionTracker.toJson());
        json.put("AchievementTracker", achievementTracker.toJson());
        return json;
    }
}
