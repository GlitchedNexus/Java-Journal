package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// The Habit Tracker allows the user to track their habit goals.
public class HabitTracker implements Writable {
    private ArrayList<String> habits;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Constructs a new list of habits.
    public HabitTracker() {
        habits = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Adds a new habit to habit list if it is not already present.
    public void addHabit(String habit) {
        if (!habits.contains(habit)) {
            habits.add(habit);
            eventLog.logEvent(new Event("Added Habit: " + habit + "."));
        }
    }

    // MODIFIES: this
    // EFFECTS: Removes a habit from habit list if is present.
    public boolean removeHabit(String habit) {
        if (habits.contains(habit)) {
            habits.remove(habit);
            eventLog.logEvent(new Event("Removed Habit: " + habit + "."));
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Returns list of current habits
    public ArrayList<String> getHabits() {
        return habits;
    }

    // MODIFIES: this
    // EFFECTS: Clears all habits
    public void clearHabits() {
        habits.clear();
        eventLog.logEvent(new Event("Cleared HabitTracker."));
    }

    //EFFECTS: Returns number of habits
    public int numberOfHabits() {
        return habits.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("habits", habitsToJson());

        return json;
    }

    // EFFECTS: Returns a JSONArray containing habits in the HabitTracker
    private JSONArray habitsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String habits : habits) {
            jsonArray.put(habits);
        }

        return jsonArray;
    }
}
