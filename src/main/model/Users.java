package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// The Users class allows us to track the users in our app. An instance of this class tracks a user's:
// 1. username
// 2. password
// 3. User class instance for running the app with multiple users.
public class Users implements Writable {
    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    private ArrayList<User> userList;
    private EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Constructs new list of users with no usernames, passwords and names
    public Users() {
        usernames = new ArrayList<String>();
        passwords = new ArrayList<String>();
        userList = new ArrayList<User>();
    }

    // EFFECTS: Constructs list of users with corresponding usernames, passwords and names
    public Users(ArrayList<String> usernames, ArrayList<String> passwords, ArrayList<User> userList) {
        this.usernames = usernames;
        this.passwords = passwords;
        this.userList = userList;
    }

    // MODIFIES: this
    // EFFECTS: Adds a new user to list of users
    public boolean addNewUser(String username, String password, String name) {
        if (usernames.contains(username)) {
            return false;
        } else {
            usernames.add(username);
            passwords.add(password);
            userList.add(new User(name));
            eventLog.logEvent(new Event("New User Added."));
            return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: Removes a user from list of users and return true if username was removed else false.
    public boolean removeUser(String username) {
        if (usernames.contains(username)) {
            int index = usernames.indexOf(username);
            usernames.remove(index);
            passwords.remove(index);
            userList.remove(index);
            eventLog.logEvent(new Event("User " + username + " Removed."));
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: Checks if given username and password are valid.
    public boolean checkValidUser(String username, String password) {
        if (usernames.contains(username)) {
            int index = usernames.indexOf(username);
            if (passwords.get(index).equals(password)) {
                eventLog.logEvent(new Event("New Session Login For " + username + "."));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // EFFECTS: Returns all registered usernames.
    public ArrayList<String> getUsernames() {
        return usernames;
    }

    // REQUIRES: Username passed as argument must be in usernames
    // EFFECTS: Return user with corresponding username
    public User getUser(String username) {
        int index = usernames.indexOf(username);
        return userList.get(index);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("usernames", usernamesToJson());
        json.put("passwords", passwordsToJson());
        json.put("users", usersToJson());
        return json;
    }

    // EFFECTS: Returns a JSONArray containing usernames in the Users class instance
    private JSONArray usernamesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String username : usernames) {
            jsonArray.put(username);
        }

        return jsonArray;
    }

    // EFFECTS: Returns a JSONArray containing passwords in the Users class instance
    private JSONArray passwordsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String password : passwords) {
            jsonArray.put(password);
        }

        return jsonArray;
    }

    // EFFECTS: Returns a JSONArray containing User class instances in the Users class instance
    private JSONArray usersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (User user : userList) {
            jsonArray.put(user.toJson());
        }

        return jsonArray;
    }
}
