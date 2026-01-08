package persistence;

import org.json.JSONObject;

// Notice Of Reference:
// The following Writable interface is based on the example provided in the JsonSerializationDemo
// for phase 2
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
