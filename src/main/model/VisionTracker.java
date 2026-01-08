package model;

import org.json.JSONObject;
import persistence.Writable;

// The Vision Tracker class allows a user to define an ultimate goal that they are striving for in life.
// It allows the user to make a goal, define what it is and by when they want to achieve it.
// They can update it as per their needs and choice.
public class VisionTracker implements Writable {
    private String visionStatement;
    private String description;
    private String deadline;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Constructs new VisionTracker with empty strings for all fields.
    public VisionTracker() {
        visionStatement = "";
        description = "";
        deadline = "";
    }

    public VisionTracker(String visionStatement, String description, String deadline) {
        this.visionStatement = visionStatement;
        this.description = description;
        this.deadline = deadline;
    }

    // REQUIRES: Vision is already has a vision statement
    // EFFECTS: Returns vision statement
    public String getVisionStatement() {
        return visionStatement;
    }

    // REQUIRES: Vision is already has a description
    // EFFECTS: Returns vision description
    public String getDescription() {
        return description;
    }

    // REQUIRES: Vision is already has a deadline
    // EFFECTS: Returns vision deadline
    public String getDeadline() {
        return deadline;
    }

    // MODIFIES: this
    // EFFECTS: Clears all vision fields
    public void clearVision() {
        visionStatement = "";
        description = "";
        deadline = "";
        eventLog.logEvent(new Event("VisionTracker Cleared."));
    }

    // MODIFIES: this
    // EFFECTS: Updates vision description to that defined by author
    public boolean updateDescription(String newDescription) {
        if ("".equalsIgnoreCase(visionStatement)) {
            return false;
        } else {
            this.description = newDescription;
            eventLog.logEvent(new Event("Vision Description Updated."));
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates vision deadline to deadline defined by author, return true
    //          to confirm completion of task else false in case no vision is defined.
    public boolean updateDeadline(String newDeadline) {
        if ("".equalsIgnoreCase(visionStatement)) {
            return false;
        } else {
            this.deadline = newDeadline;
            eventLog.logEvent(new Event("Vision Deadline Updated."));
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: Changes empty or  overwrites pre-existing vision to vision given by author.
    public void newVision(String visionStatement, String visionDescription, String visionDeadline) {
        this.visionStatement = visionStatement;
        this.description = visionDescription;
        this.deadline = visionDeadline;
        eventLog.logEvent(new Event("New Vision Defined"));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("visionStatement", visionStatement);
        json.put("description", description);
        json.put("deadline", deadline);
        return json;
    }
}
