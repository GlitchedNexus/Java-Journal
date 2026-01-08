package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// The Journal Class acts as the journal for the user. It allows the user to make and remove
// entries. Just like you would have in a real journal.
public class Journal implements Writable {
    private ArrayList<String> entries;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Creates new Journal
    public Journal() {
        entries = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Adds new entry to journal
    public void addNewEntry(String entry) {
        entries.add(entry);
        eventLog.logEvent(new Event("New Entry Added"));
    }

    // EFFECTS: Returns all entries from journal
    public ArrayList<String> returnEntries() {
        return entries;
    }

    // MODIFIES: this
    // EFFECTS: Removes last entry from Journal, returns empty string if no entries left
    public String removeLastEntry() {
        if (entries.size() <= 0) {
            return "";
        } else {
            eventLog.logEvent(new Event("Removed Last Entry."));
            return entries.remove(entries.size() - 1);
        }
    }

    // MODIFIES: this
    // EFFECTS: Clears all entries in the journal
    public void clearAllEntries() {
        entries.clear();
        eventLog.logEvent(new Event("Cleared All Entries."));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("entries", entriesToJson());

        return json;
    }

    // EFFECTS: Returns a JSONArray containing all entries in the given Journal class instance
    private JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String entry : entries) {
            jsonArray.put(entry);
        }

        return jsonArray;
    }
}
