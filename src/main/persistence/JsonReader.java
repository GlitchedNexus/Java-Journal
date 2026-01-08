package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

// Notice Of Reference:
// The following JsonReader class is heavily based on the example provided in the JsonSerializationDemo
// for phase 2

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Users read() throws IOException {
        eventLog.logEvent(new Event("Loaded Previous App Instance"));
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Users appData = parseUsers(jsonObject);
        return appData;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Users from JSON object and returns it
    private Users parseUsers(JSONObject jsonObject) {
        ArrayList<String> usernames = usernamesFromJsonArray(jsonObject.getJSONArray("usernames"));
        ArrayList<String> passwords = passwordsFromJsonArray(jsonObject.getJSONArray("passwords"));
        ArrayList<User> userList = userListFromJsonArray(jsonObject.getJSONArray("users"));

        return new Users(usernames, passwords, userList);
    }

    // EFFECTS: parses usernames from JSONArray and returns it
    private ArrayList<String> usernamesFromJsonArray(JSONArray jsonArray) {
        ArrayList<String> usernames = new ArrayList<>();
        for (Object json : jsonArray) {
            usernames.add(json.toString());
        }
        return usernames;
    }

    // EFFECTS: parses passwords from JSONArray and returns it
    private ArrayList<String> passwordsFromJsonArray(JSONArray jsonArray) {
        ArrayList<String> passwords = new ArrayList<>();
        for (Object json : jsonArray) {
            passwords.add(json.toString());
        }
        return passwords;
    }

    // EFFECTS: parses User class instances from JSONArray and returns it
    private ArrayList<User> userListFromJsonArray(JSONArray jsonArray) {
        ArrayList<User> userList = new ArrayList<>();
        for (Object json : jsonArray) {
            addCurrentUser(userList, (JSONObject) json);
        }
        return userList;
    }

    // MODIFIES: userList
    // EFFECTS: Adds the corresponding User class instance to userList
    private void addCurrentUser(ArrayList<User> userList, JSONObject json) {
        String name = json.getString("name");
        Journal journal = readJournal(json.getJSONObject("Journal"));
        HabitTracker habitTracker = readHabitTracker(json.getJSONObject("HabitTracker"));
        VisionTracker visionTracker = readVisionTracker(json.getJSONObject("VisionTracker"));
        AchievementTracker achievementTracker = readAchievementTracker(json.getJSONObject("AchievementTracker"));
        userList.add(new User(name, journal, habitTracker, visionTracker, achievementTracker));
    }

    // EFFECTS: Returns a Journal class instance containing all data from passed JSONObjects
    private Journal readJournal(JSONObject journal) {
        Journal userJournal = new Journal();

        for (String entry : readEntries(journal.getJSONArray("entries"))) {
            userJournal.addNewEntry(entry);
        }
        return userJournal;
    }

    // EFFECTS: Returns ArrayList of all entries for Journal class instance from passed JSONArray
    private ArrayList<String> readEntries(JSONArray entries) {
        ArrayList<String> allEntries = new ArrayList<>();
        for (Object json : entries) {
            allEntries.add(json.toString());
        }
        return allEntries;
    }

    // EFFECTS: Returns a HabitTracker class instance containing all data from passed JSONObjects
    private HabitTracker readHabitTracker(JSONObject habitTracker) {
        HabitTracker userHabitTracker = new HabitTracker();

        for (String habit : readHabits(habitTracker.getJSONArray("habits"))) {
            userHabitTracker.addHabit(habit);
        }
        return userHabitTracker;
    }

    // EFFECTS: Returns ArrayList of all habits for HabitTracker class instance from passed JSONArray
    private ArrayList<String> readHabits(JSONArray habits) {
        ArrayList<String> userHabits = new ArrayList<>();
        for (Object json : habits) {
            userHabits.add(json.toString());
        }
        return userHabits;
    }

    // EFFECTS: Returns a VisionTracker class instance containing all data from passed JSONObjects
    private VisionTracker readVisionTracker(JSONObject visionTracker) {
        String visionStatement = visionTracker.getString("visionStatement");
        String description = visionTracker.getString("description");
        String deadline = visionTracker.getString("deadline");
        return new VisionTracker(visionStatement, description, deadline);
    }

    // EFFECTS: Returns a AchievementTracker class instance containing all data from passed JSONObjects
    private AchievementTracker readAchievementTracker(JSONObject achievementTracker) {
        AchievementTracker userAchievementTracker = new AchievementTracker();

        for (String achievement : readAchievements(achievementTracker.getJSONArray("achievements"))) {
            userAchievementTracker.addAchievement(achievement);
        }
        return userAchievementTracker;
    }

    // EFFECTS: Returns ArrayList of all achievements for AchievementTracker class instance from passed JSONArray
    private ArrayList<String> readAchievements(JSONArray achievements) {
        ArrayList<String> userAchievements = new ArrayList<>();
        for (Object json : achievements) {
            userAchievements.add(json.toString());
        }
        return userAchievements;
    }

}
