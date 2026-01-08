package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// This class allows user to keep log of their achievements.
public class AchievementTracker implements Writable {
    private ArrayList<String> achievements;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Creates new empty ArrayList of achievements
    public AchievementTracker() {
        achievements = new ArrayList<String>();
    }

    // MODIFIES: this
    // EFFECTS: Adds new given achievement to achievements
    public void addAchievement(String achievement) {
        achievements.add(achievement);
        eventLog.logEvent(new Event("Removed Achievement: " + achievement + "."));
    }

    // MODIFIES: this
    // EFFECTS: Clears achievements
    public void clearAchievements() {
        achievements.clear();
        eventLog.logEvent(new Event("Cleared AchievementTracker."));
    }

    // EFFECTS: Returns number of achievements
    public int returnAchievementCount() {
        return achievements.size();
    }

    // EFFECTS: Returns achievements
    public ArrayList<String> returnAchievements() {
        return achievements;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("achievements", achievementsToJson());

        return json;
    }

    // EFFECTS: Returns a JSONArray containing achievements in the AchievementTracker
    private JSONArray achievementsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String achievement : achievements) {
            jsonArray.put(achievement);
        }

        return jsonArray;
    }
}