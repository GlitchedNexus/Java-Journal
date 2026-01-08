package ui;

import model.Event;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// Self-Improvement Journal Application
public class JournalAppWithUI extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/JournalApp.json";
    private Journal journal;
    private HabitTracker habitTracker;
    private VisionTracker visionTracker;
    private AchievementTracker achievementTracker;
    private Users users;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private EventLog eventLog = EventLog.getInstance();

    // Buttons For Authentication Menu
    private Button logInButton = new Button();
    private Button signUpButton = new Button();
    private Button deleteUserButton = new Button();
    private Button saveInstanceButton = new Button();
    private Button loadLastInstanceButton = new Button();

    // Buttons For JournalApp Menu
    private Button journalButton = new Button();
    private Button habitTrackerButton = new Button();
    private Button visionTrackerButton = new Button();
    private Button achievementTrackerButton = new Button();
    private Button logoutButton = new Button();

    // Buttons For Journal
    private Button addNewEntryButton = new Button();
    private Button removeLastEntryButton = new Button();
    private Button showAllEntriesButton = new Button();
    private Button clearAllEntriesButton = new Button();
    private Button exitJournalSubMenuButton = new Button();

    // Buttons For HabitTracker
    private Button addNewHabitButton = new Button();
    private Button removeHabitButton = new Button();
    private Button showAllHabitsButton = new Button();
    private Button clearHabitsButton = new Button();
    private Button exitHabitsSubMenuButton = new Button();

    // Buttons For VisionTracker
    private Button showVisionButton = new Button();
    private Button newVisionButton = new Button();
    private Button clearVisionButton = new Button();
    private Button editDescriptionButton = new Button();
    private Button editDeadlineButton = new Button();
    private Button exitVisionSubMenuButton = new Button();

    // Buttons For AchievementTracker
    private Button addAchievementButton = new Button();
    private Button showAchievementsButton = new Button();
    private Button clearAchievementsButton = new Button();
    private Button exitAchievementsSubMenuButton = new Button();

    // JPanels
    private JPanel authenticationJPanel = new JPanel();
    private JPanel mainMenuJPanel = new JPanel();
    private JPanel journalMenuJPanel = new JPanel();
    private JPanel habitMenuJPanel = new JPanel();
    private JPanel visionMenuJPanel = new JPanel();
    private JPanel achievementMenuJPanel = new JPanel();

    // Special Label In Achievement Tracker Sub Menu
    JLabel achievementCount = new JLabel();

    // EFFECTS: Constructs and runs new Journal app instance.
    public JournalAppWithUI() {
        users = new Users();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setupGUI();
    }

    // MODIFIES: this
    // EFFECTS: Sets Up JFrame and Buttons used in the app
    private void setupGUI() {
        setupButtons();
        setupJFrame();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Buttons used in the app
    private void setupButtons() {
        setupAuthenticationMenuButtons();
        setupJournalAppMenuButtons();
        setupJournalMenuButtons();
        setupVisionTrackerMenuButtons();
        setupHabitTrackerMenuButtons();
        setupAchievementTrackerMenuButtons();
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Authentication Menu
    private void setupAuthenticationMenuButtons() {
        setupLogInButton();
        setupSignUpButton();
        setupDeleteUserButton();
        setupSaveInstanceButton();
        setupLoadLastInstanceButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up LogIn Button
    private void setupLogInButton() {
        logInButton.setLabel("Login");
        logInButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        logInButton.setForeground(new Color(74, 78, 105));
        logInButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up SignUp Button
    private void setupSignUpButton() {
        signUpButton.setLabel("Sign-Up");
        signUpButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        signUpButton.setForeground(new Color(74, 78, 105));
        signUpButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Delete User Button
    private void setupDeleteUserButton() {
        deleteUserButton.setLabel("Delete User");
        deleteUserButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        deleteUserButton.setForeground(new Color(74, 78, 105));
        deleteUserButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Save Instance Button
    private void setupSaveInstanceButton() {
        saveInstanceButton.setLabel("Save App Instance");
        saveInstanceButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        saveInstanceButton.setForeground(new Color(74, 78, 105));
        saveInstanceButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Load Last Instance Button
    private void setupLoadLastInstanceButton() {
        loadLastInstanceButton.setLabel("Load Last Save");
        loadLastInstanceButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        loadLastInstanceButton.setForeground(new Color(74, 78, 105));
        loadLastInstanceButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Main Menu
    private void setupJournalAppMenuButtons() {
        setupJournalButton();
        setupHabitTrackerButton();
        setupVisionTrackerButton();
        setupAchievementTrackerButton();
        setupLogoutButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Journal Button
    private void setupJournalButton() {
        journalButton.setLabel("Journal");
        journalButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        journalButton.setForeground(new Color(74, 78, 105));
        journalButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Habit Tracker Button
    private void setupHabitTrackerButton() {
        habitTrackerButton.setLabel("Track Habits");
        habitTrackerButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        habitTrackerButton.setForeground(new Color(74, 78, 105));
        habitTrackerButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Vision Tracker Button
    private void setupVisionTrackerButton() {
        visionTrackerButton.setLabel("Track Life Vision");
        visionTrackerButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        visionTrackerButton.setForeground(new Color(74, 78, 105));
        visionTrackerButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Achievement Tracker Button
    private void setupAchievementTrackerButton() {
        achievementTrackerButton.setLabel("Track Achievements");
        achievementTrackerButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        achievementTrackerButton.setForeground(new Color(74, 78, 105));
        achievementTrackerButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Logout Button
    private void setupLogoutButton() {
        logoutButton.setLabel("Logout");
        logoutButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        logoutButton.setForeground(new Color(74, 78, 105));
        logoutButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Journal Menu
    private void setupJournalMenuButtons() {
        setupAddNewEntryButton();
        setupRemoveLastEntryButton();
        setupShowAllEntriesButton();
        setupClearAllEntriesButton();
        setupExitJournalSubMenuButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Add New Entry Button
    private void setupAddNewEntryButton() {
        addNewEntryButton.setLabel("Add New Entry");
        addNewEntryButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        addNewEntryButton.setForeground(new Color(74, 78, 105));
        addNewEntryButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Remove Last Entry Button
    private void setupRemoveLastEntryButton() {
        removeLastEntryButton.setLabel("Remove Last Entry");
        removeLastEntryButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        removeLastEntryButton.setForeground(new Color(74, 78, 105));
        removeLastEntryButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show All Entries Button
    private void setupShowAllEntriesButton() {
        showAllEntriesButton.setLabel("See All Entries");
        showAllEntriesButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        showAllEntriesButton.setForeground(new Color(74, 78, 105));
        showAllEntriesButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Clear All Entries Button
    private void setupClearAllEntriesButton() {
        clearAllEntriesButton.setLabel("Clear All Entries");
        clearAllEntriesButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        clearAllEntriesButton.setForeground(new Color(74, 78, 105));
        clearAllEntriesButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Exit Journal Sub Menu Button
    private void setupExitJournalSubMenuButton() {
        exitJournalSubMenuButton.setLabel("Exit");
        exitJournalSubMenuButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        exitJournalSubMenuButton.setForeground(new Color(74, 78, 105));
        exitJournalSubMenuButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Vision Tracker Menu
    private void setupVisionTrackerMenuButtons() {
        setupShowVisionButton();
        setupNewVisionButton();
        setupClearVisionButton();
        setupEditDescriptionButton();
        setupEditDeadlineButton();
        setupExitVisionSubMenuButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show Vision Button
    private void setupShowVisionButton() {
        showVisionButton.setLabel("Show Vision");
        showVisionButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        showVisionButton.setForeground(new Color(74, 78, 105));
        showVisionButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up New Vision Button
    private void setupNewVisionButton() {
        newVisionButton.setLabel("New Vision");
        newVisionButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        newVisionButton.setForeground(new Color(74, 78, 105));
        newVisionButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Clear Vision Button
    private void setupClearVisionButton() {
        clearVisionButton.setLabel("Clear Vision");
        clearVisionButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        clearVisionButton.setForeground(new Color(74, 78, 105));
        clearVisionButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show Edit Vision Description Button
    private void setupEditDescriptionButton() {
        editDescriptionButton.setLabel("Edit Description");
        editDescriptionButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        editDescriptionButton.setForeground(new Color(74, 78, 105));
        editDescriptionButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show Edit Vision Deadline Button
    private void setupEditDeadlineButton() {
        editDeadlineButton.setLabel("Edit Deadline");
        editDeadlineButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        editDeadlineButton.setForeground(new Color(74, 78, 105));
        editDeadlineButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show Exit Vision Sub Menu Button
    private void setupExitVisionSubMenuButton() {
        exitVisionSubMenuButton.setLabel("Exit");
        exitVisionSubMenuButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        exitVisionSubMenuButton.setForeground(new Color(74, 78, 105));
        exitVisionSubMenuButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Habit Tracker Menu
    private void setupHabitTrackerMenuButtons() {
        setupAddNewHabitButton();
        setupRemoveHabitButton();
        setupShowAllHabitsButton();
        setupClearHabitsButton();
        setupExitHabitsSubMenuButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show All Habits Button
    private void setupShowAllHabitsButton() {
        showAllHabitsButton.setLabel("See All Habits");
        showAllHabitsButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        showAllHabitsButton.setForeground(new Color(74, 78, 105));
        showAllHabitsButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Clear All Habits Button
    private void setupClearHabitsButton() {
        clearHabitsButton.setLabel("Clear All Habits");
        clearHabitsButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        clearHabitsButton.setForeground(new Color(74, 78, 105));
        clearHabitsButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Exit Habit Sub Menu Button
    private void setupExitHabitsSubMenuButton() {
        exitHabitsSubMenuButton.setLabel("Exit");
        exitHabitsSubMenuButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        exitHabitsSubMenuButton.setForeground(new Color(74, 78, 105));
        exitHabitsSubMenuButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Add New Habit Button
    private void setupAddNewHabitButton() {
        addNewHabitButton.setLabel("Add New Habit");
        addNewHabitButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        addNewHabitButton.setForeground(new Color(74, 78, 105));
        addNewHabitButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Remove Habit Button
    private void setupRemoveHabitButton() {
        removeHabitButton.setLabel("Remove Habit");
        removeHabitButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        removeHabitButton.setForeground(new Color(74, 78, 105));
        removeHabitButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up all buttons in the Achievement Tracker Menu
    private void setupAchievementTrackerMenuButtons() {
        setupAddAchievementButton();
        setupShowAchievementsButton();
        setupClearAchievementsButton();
        setupExitAchievementsSubMenuButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up Add Achievement Button
    private void setupAddAchievementButton() {
        addAchievementButton.setLabel("Add New Achievement");
        addAchievementButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        addAchievementButton.setForeground(new Color(74, 78, 105));
        addAchievementButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Show Achievements Button
    private void setupShowAchievementsButton() {
        showAchievementsButton.setLabel("Show All Achievements");
        showAchievementsButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        showAchievementsButton.setForeground(new Color(74, 78, 105));
        showAchievementsButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Clear Achievements Button
    private void setupClearAchievementsButton() {
        clearAchievementsButton.setLabel("Clear All Achievements");
        clearAchievementsButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        clearAchievementsButton.setForeground(new Color(74, 78, 105));
        clearAchievementsButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Sets up Exit Achievements Sub Menu Button
    private void setupExitAchievementsSubMenuButton() {
        exitAchievementsSubMenuButton.setLabel("Exit");
        exitAchievementsSubMenuButton.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        exitAchievementsSubMenuButton.setForeground(new Color(74, 78, 105));
        exitAchievementsSubMenuButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Authentication Menu
    private void setupAuthenticationJPanel() {
        authenticationJPanel.setBackground(new Color(34, 34, 59));
        authenticationJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        authenticationJPanel.setLayout(null);
        JLabel label = new JLabel("Welcome To Your Journal");
        label.setBounds(165, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        authenticationJPanel.add(label);

        logInButton.setBounds(150, 100, 200, 30);
        signUpButton.setBounds(150, 150, 200, 30);
        deleteUserButton.setBounds(150, 200, 200, 30);
        saveInstanceButton.setBounds(150, 250, 200, 30);
        loadLastInstanceButton.setBounds(150, 300, 200, 30);
        authenticationJPanel.add(logInButton);
        authenticationJPanel.add(signUpButton);
        authenticationJPanel.add(deleteUserButton);
        authenticationJPanel.add(saveInstanceButton);
        authenticationJPanel.add(loadLastInstanceButton);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Main Menu
    private void setupMainMenuJPanel() {
        mainMenuJPanel.setBackground(new Color(34, 34, 59));
        mainMenuJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        mainMenuJPanel.setLayout(null);
        JLabel label = new JLabel("What Would You Like To Do?");
        label.setBounds(165, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        mainMenuJPanel.add(label);

        journalButton.setBounds(150, 100, 200, 30);
        habitTrackerButton.setBounds(150, 150, 200, 30);
        visionTrackerButton.setBounds(150, 200, 200, 30);
        achievementTrackerButton.setBounds(150, 250, 200, 30);
        logoutButton.setBounds(150, 300, 200, 30);
        mainMenuJPanel.add(journalButton);
        mainMenuJPanel.add(habitTrackerButton);
        mainMenuJPanel.add(visionTrackerButton);
        mainMenuJPanel.add(achievementTrackerButton);
        mainMenuJPanel.add(logoutButton);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Journal Menu
    private void setupJournalMenuJPanel() {
        journalMenuJPanel.setBackground(new Color(34, 34, 59));
        journalMenuJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        journalMenuJPanel.setLayout(null);
        JLabel label = new JLabel("What Would You Like To Do?");
        label.setBounds(153, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        journalMenuJPanel.add(label);

        addNewEntryButton.setBounds(150, 100, 200, 30);
        removeLastEntryButton.setBounds(150, 150, 200, 30);
        showAllEntriesButton.setBounds(150, 200, 200, 30);
        clearAllEntriesButton.setBounds(150, 250, 200, 30);
        exitJournalSubMenuButton.setBounds(150, 300, 200, 30);
        journalMenuJPanel.add(addNewEntryButton);
        journalMenuJPanel.add(removeLastEntryButton);
        journalMenuJPanel.add(showAllEntriesButton);
        journalMenuJPanel.add(clearAllEntriesButton);
        journalMenuJPanel.add(exitJournalSubMenuButton);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Habit Menu
    private void setupHabitMenuJPanel() {
        habitMenuJPanel.setBackground(new Color(34, 34, 59));
        habitMenuJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        habitMenuJPanel.setLayout(null);
        JLabel label = new JLabel("What Would You Like To Do?");
        label.setBounds(153, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        habitMenuJPanel.add(label);

        addNewHabitButton.setBounds(150, 100, 200, 30);
        removeHabitButton.setBounds(150, 150, 200, 30);
        showAllHabitsButton.setBounds(150, 200, 200, 30);
        clearHabitsButton.setBounds(150, 250, 200, 30);
        exitHabitsSubMenuButton.setBounds(150, 300, 200, 30);
        habitMenuJPanel.add(addNewHabitButton);
        habitMenuJPanel.add(removeHabitButton);
        habitMenuJPanel.add(showAllHabitsButton);
        habitMenuJPanel.add(clearHabitsButton);
        habitMenuJPanel.add(exitHabitsSubMenuButton);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Vision Tracker Menu
    private void setupVisionMenuJPanel() {
        visionMenuJPanel.setBackground(new Color(34, 34, 59));
        visionMenuJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        visionMenuJPanel.setLayout(null);
        JLabel label = new JLabel("What Would You Like To Do?");
        label.setBounds(153, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        visionMenuJPanel.add(label);

        showVisionButton.setBounds(150, 100, 200, 30);
        newVisionButton.setBounds(150, 150, 200, 30);
        clearVisionButton.setBounds(150, 200, 200, 30);
        editDescriptionButton.setBounds(150, 250, 200, 30);
        editDeadlineButton.setBounds(150, 300, 200, 30);
        exitVisionSubMenuButton.setBounds(150, 350, 200, 30);
        visionMenuJPanel.add(showVisionButton);
        visionMenuJPanel.add(newVisionButton);
        visionMenuJPanel.add(clearVisionButton);
        visionMenuJPanel.add(editDescriptionButton);
        visionMenuJPanel.add(editDeadlineButton);
        visionMenuJPanel.add(exitVisionSubMenuButton);
    }

    // MODIFIES: this
    // EFFECTS: Setups up JPanel for Achievement Tracker Menu
    private void setupAchievementMenuJPanel() {
        achievementMenuJPanel.setBackground(new Color(34, 34, 59));
        achievementMenuJPanel.setBorder(BorderFactory.createLineBorder(new Color(242, 233, 228), 3));
        achievementMenuJPanel.setLayout(null);
        JLabel label = new JLabel("What Would You Like To Do?");
        label.setBounds(153, 25, 300, 50);
        label.setFont(new Font("Big Caslon", Font.PLAIN, 16));
        label.setForeground(new Color(242, 233, 228));
        achievementMenuJPanel.add(label);

        int count = achievementTracker.returnAchievementCount();
        achievementCount.setText("Achievement Count: " + count);
        achievementCount.setForeground(new Color(242, 233, 228));

        addAchievementButton.setBounds(150, 100, 200, 30);
        showAchievementsButton.setBounds(150, 150, 200, 30);
        clearAchievementsButton.setBounds(150, 200, 200, 30);
        exitAchievementsSubMenuButton.setBounds(150, 250, 200, 30);
        achievementCount.setBounds(175, 300, 200, 30);
        achievementMenuJPanel.add(addAchievementButton);
        achievementMenuJPanel.add(showAchievementsButton);
        achievementMenuJPanel.add(clearAchievementsButton);
        achievementMenuJPanel.add(exitAchievementsSubMenuButton);
        achievementMenuJPanel.add(achievementCount);
    }

    // MODIFIES: this
    // EFFECTS: Sets up JFrame used in the app
    private void setupJFrame() {
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Journal App");
        setupAuthenticationJPanel();
        this.add(authenticationJPanel);
        this.addWindowListener(new WindowAdapter() {
            //for closing
            @Override
            public void windowClosing(WindowEvent e) {
                for (Event event : eventLog) {
                    System.out.println(event);
                }
            }
        });
        this.setVisible(true);
    }

    // Notice Of Reference:
    // The following JSON save method is based on the example provided in the JsonSerializationDemo
    // for phase 2

    // EFFECTS: saves all users' work to file
    private void saveJournalAppSession() {
        try {
            jsonWriter.open();
            jsonWriter.write(users);
            jsonWriter.close();
            JOptionPane.showMessageDialog(authenticationJPanel, "Saved App Instance To: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(authenticationJPanel, "Unable to write to file: " + JSON_STORE);
        }
    }

    // Notice Of Reference:
    // The following JSON load method is based on the example provided in the JsonSerializationDemo
    // for phase 2

    // MODIFIES: this
    // EFFECTS: loads all users from file
    private void loadLastJournalAppSession() {
        try {
            users = jsonReader.read();
            JOptionPane.showMessageDialog(authenticationJPanel, "Loaded Previous App Session from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(authenticationJPanel, "Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Validates login credentials, if valid runs JournalApp for the corresponding user.
    private void runUserLogin() {
        String username = JOptionPane.showInputDialog("Enter Username Below:");
        String password = JOptionPane.showInputDialog("Enter Password Below:");
        if (users.checkValidUser(username, password)) {
            JOptionPane.showMessageDialog(authenticationJPanel, "Welcome!");
            setUserFields(users.getUser(username));
            setupMainMenuJPanel();
            this.remove(authenticationJPanel);
            this.add(mainMenuJPanel);
            this.validate();
        } else {
            JOptionPane.showMessageDialog(authenticationJPanel, "Invalid Username or Password!");
        }
    }


    // MODIFIES: this
    // EFFECTS: adds a new user with a unique username to Users.
    private void runUserSignUp() {
        String username = JOptionPane.showInputDialog("Enter Username Below:");
        String password = JOptionPane.showInputDialog("Enter Password Below:");
        String name = JOptionPane.showInputDialog("Enter Name Below:");
        if (!password.equals("") && !username.equals("") && !name.equals("")) {
            if (users.addNewUser(username, password, name)) {
                JOptionPane.showMessageDialog(authenticationJPanel, "Please Log-In To Start Working");
            } else {
                JOptionPane.showMessageDialog(authenticationJPanel, "Username Already Taken");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Takes user prompt for username to remove and asks for confirmation regarding action.
    //          If approved, removes user from users. In case of invalid username prints "No Such User Found".
    private void runDeleteUser() {
        String usernameToDelete = JOptionPane.showInputDialog("Enter Username Below:");
        String isUserSure = JOptionPane.showInputDialog("Enter \"YES\" To Confirm:");
        if ("YES".equals(isUserSure)) {
            if (users.removeUser(usernameToDelete)) {
                JOptionPane.showMessageDialog(authenticationJPanel, "Removed User");
            } else {
                JOptionPane.showMessageDialog(authenticationJPanel, "No Such User Found");
            }
        } else {
            JOptionPane.showMessageDialog(authenticationJPanel, "Request Cancelled");
        }
    }

    // MODIFIES:
    // EFFECTS: Sets all corresponding fields to those of the current user. Namely, journal,
    //          habitTracker, visionTracker and achievementTracker.
    private void setUserFields(User currentUser) {
        journal = currentUser.getJournal();
        habitTracker = currentUser.getHabitTracker();
        visionTracker = currentUser.getVisionTracker();
        achievementTracker = currentUser.getAchievementTracker();
    }

    // MODIFIES: this
    // EFFECTS: Takes user input and adds the new entry to the journal's list of entries.
    private void runJournalAddNewEntry() {
        String entry = JOptionPane.showInputDialog(journalMenuJPanel, "Make Entry: ");
        journal.addNewEntry(entry);
        JOptionPane.showMessageDialog(journalMenuJPanel, "Entry Added!");
    }

    // EFFECTS: Prints out all entries in the user's journal
    private void runJournalShowAllEntries() {
        String result = "Entries: \n";
        for (String i : journal.returnEntries()) {
            String newString = (i + "\n");
            result = result + newString;
        }
        JOptionPane.showMessageDialog(journalMenuJPanel, result);
    }

    // MODIFIES: this
    // EFFECTS: Clears all entries in the user's journal whilst giving confirmation at start
    //          and end of process.
    private void runJournalClearAllEntries() {
        JOptionPane.showMessageDialog(journalMenuJPanel, "Removing Entries");
        journal.clearAllEntries();
        JOptionPane.showMessageDialog(journalMenuJPanel, "All Entries Removed");
    }

    private void runJournalRemoveLastEntry() {
        String outputMessage = "Removed Entry: " + journal.removeLastEntry();
        JOptionPane.showMessageDialog(journalMenuJPanel, outputMessage);
    }

    // MODIFIES: this
    // EFFECTS: Takes user input and adds corresponding habit to Habit Tracker
    private void runHabitTrackerAddHabit() {
        String habitToAdd = JOptionPane.showInputDialog(habitMenuJPanel, "Habit Name:");
        habitTracker.addHabit(habitToAdd);
        JOptionPane.showMessageDialog(journalMenuJPanel, "Habit Added!");
    }

    // MODIFIES: this
    // EFFECTS: Takes user prompt for habit to remove, deletes habit if it exists,
    //          else prints "Habit Not In List".
    private void runHabitTrackerRemoveHabit() {
        String habitToBeRemoved = JOptionPane.showInputDialog(habitMenuJPanel, "Habit To Be Removed:");
        if (habitTracker.removeHabit(habitToBeRemoved)) {
            JOptionPane.showMessageDialog(journalMenuJPanel, "Removed Habit");
        } else {
            JOptionPane.showMessageDialog(journalMenuJPanel, "Habit Not In List");
        }
    }

    // EFFECTS: Prints out all habits in Habit Tracker
    private void runShowAllHabits() {
        String result = "Habits: \n";
        for (String i : habitTracker.getHabits()) {
            String newString = (i + "\n");
            result = result + newString;
        }
        JOptionPane.showMessageDialog(habitMenuJPanel, result);
    }


    // MODIFIES: This
    // EFFECTS: Clears habits in Habit Tracker and returns confirmation for completion of task.
    private void runHabitTrackerClearHabits() {
        JOptionPane.showMessageDialog(journalMenuJPanel, "Clearing Habit Tracker");
        habitTracker.clearHabits();
        JOptionPane.showMessageDialog(journalMenuJPanel, "All Habits Removed");
    }

    // EFFECTS: Prints out the current vision defined by user and states "vision defined" if vision is empty.
    private void runShowVision() {
        if ("".equalsIgnoreCase(visionTracker.getVisionStatement())) {
            JOptionPane.showMessageDialog(visionMenuJPanel, "No Vision Defined");
        } else {
            String vision = "Current Vision: " + visionTracker.getVisionStatement();
            String description = "Description: " + visionTracker.getDescription();
            String deadline = "Deadline: " + visionTracker.getDeadline();

            String finalString = vision + "\n" + description + "\n" + deadline;
            JOptionPane.showMessageDialog(visionMenuJPanel, finalString);
        }
    }

    // MODIFIES: this
    // EFFECTS: Takes user prompts and sets up new user defined vision in Vision Tracker.
    private void runVisionTrackerNewVision() {
        String visionStatement = JOptionPane.showInputDialog(visionMenuJPanel, "Enter Vision Statement:");
        String visionDescription = JOptionPane.showInputDialog(visionMenuJPanel, "Enter Description:");
        String visionDeadline = JOptionPane.showInputDialog(visionMenuJPanel, "Enter Deadline:");
        visionTracker.newVision(visionStatement, visionDescription, visionDeadline);
        runShowVision();
    }

    // MODIFIES: this
    // EFFECTS: Prompts user to input new description and updates user's vision description.
    private void runVisionTrackerEditDescription() {
        String newDescription = JOptionPane.showInputDialog(visionMenuJPanel, "Enter New Description:");
        if (visionTracker.updateDescription(newDescription)) {
            String confirmDescriptionUpdate = "Updated description to: \"" + visionTracker.getDescription() + "\"";
            JOptionPane.showMessageDialog(visionMenuJPanel, confirmDescriptionUpdate);
        } else {
            JOptionPane.showMessageDialog(visionMenuJPanel, "No Vision Defined");
        }
    }

    // MODIFIES: this
    // EFFECTS: Prompts user to input new deadline and updates user's vision deadline.
    private void runVisionTrackerEditDeadline() {
        String newDeadline = JOptionPane.showInputDialog(visionMenuJPanel, "Enter New Deadline:");
        if (visionTracker.updateDeadline(newDeadline)) {
            String confirmDeadlineUpdate = "Updated deadline to: \"" + visionTracker.getDeadline() + "\"";
            JOptionPane.showMessageDialog(visionMenuJPanel, confirmDeadlineUpdate);
        } else {
            JOptionPane.showMessageDialog(visionMenuJPanel, "No Vision Defined");
        }
    }

    // MODIFIES: this
    // EFFECTS: Clears a user's Achievement Tracker
    private void runAchievementTrackerClearAchievements() {
        achievementTracker.clearAchievements();
        JOptionPane.showMessageDialog(achievementMenuJPanel, "Achievements Cleared");
        setupAchievementMenuJPanel();
        this.remove(achievementMenuJPanel);
        this.add(achievementMenuJPanel);
        this.validate();
    }

    // MODIFIES: this
    // EFFECTS: Prompts user to add their achievement to their Achievement Tracker
    private void runAchievementTrackerAddAchievement() {
        JFrame congratsFrame = new JFrame();
        String achievementToAdd = JOptionPane.showInputDialog(achievementMenuJPanel, "Achievement:");
        achievementTracker.addAchievement(achievementToAdd);
        setupAchievementMenuJPanel();
        this.remove(achievementMenuJPanel);
        this.add(achievementMenuJPanel);
        this.validate();
        ImageIcon icon = new ImageIcon("src/Images/tenor.gif");
        congratsFrame.add(new JLabel(icon));
        congratsFrame.pack();
        congratsFrame.setVisible(true);
    }

    // EFFECTS: Prints all achievements of the user logged into the AchievementTracker
    private void runShowAchievements() {
        String result = "Achievements: \n";
        for (String i : achievementTracker.returnAchievements()) {
            String newString = (i + "\n");
            result = result + newString;
        }
        JOptionPane.showMessageDialog(achievementMenuJPanel, result);
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton) {
            runUserLogin();
        } else if (e.getSource() == signUpButton) {
            runUserSignUp();
        } else if (e.getSource() == deleteUserButton) {
            runDeleteUser();
        } else if (e.getSource() == saveInstanceButton) {
            saveJournalAppSession();
        } else if (e.getSource() == loadLastInstanceButton) {
            loadLastJournalAppSession();
        } else {
            mainMenuButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void mainMenuButtonChecker(ActionEvent e) {
        if (e.getSource() == journalButton) {
            enterPassedMenu("journal");
        } else if (e.getSource() == habitTrackerButton) {
            enterPassedMenu("habitTracker");
        } else if (e.getSource() == visionTrackerButton) {
            enterPassedMenu("visionTracker");
        } else if (e.getSource() == achievementTrackerButton) {
            enterPassedMenu("achievementTracker");
        } else if (e.getSource() == logoutButton) {
            enterPassedMenu("logout");
        } else {
            exitButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void exitButtonChecker(ActionEvent e) {
        if (e.getSource() == exitJournalSubMenuButton) {
            returnToMainMenu(journalMenuJPanel);
        } else if (e.getSource() == exitHabitsSubMenuButton) {
            returnToMainMenu(habitMenuJPanel);
        } else if (e.getSource() == exitVisionSubMenuButton) {
            returnToMainMenu(visionMenuJPanel);
        } else if (e.getSource() == exitAchievementsSubMenuButton) {
            returnToMainMenu(achievementMenuJPanel);
        } else {
            journalMenuButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void journalMenuButtonChecker(ActionEvent e) {
        if (e.getSource() == addNewEntryButton) {
            runJournalAddNewEntry();
        } else if (e.getSource() == removeLastEntryButton) {
            runJournalRemoveLastEntry();
        } else if (e.getSource() == clearAllEntriesButton) {
            runJournalClearAllEntries();
        } else if (e.getSource() == showAllEntriesButton) {
            runJournalShowAllEntries();
        } else {
            habitMenuButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void habitMenuButtonChecker(ActionEvent e) {
        if (e.getSource() == addNewHabitButton) {
            runHabitTrackerAddHabit();
        } else if (e.getSource() == removeHabitButton) {
            runHabitTrackerRemoveHabit();
        } else if (e.getSource() == showAllHabitsButton) {
            runShowAllHabits();
        } else if (e.getSource() == clearHabitsButton) {
            runHabitTrackerClearHabits();
        } else {
            achievementMenuButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void achievementMenuButtonChecker(ActionEvent e) {
        if (e.getSource() == addAchievementButton) {
            runAchievementTrackerAddAchievement();
        } else if (e.getSource() == clearAchievementsButton) {
            runAchievementTrackerClearAchievements();
        } else if (e.getSource() == showAchievementsButton) {
            runShowAchievements();
        } else {
            visionMenuButtonChecker(e);
        }
    }

    // EFFECTS: Evaluates which buttons are pressed and calls corresponding method.
    public void visionMenuButtonChecker(ActionEvent e) {
        if (e.getSource() == showVisionButton) {
            runShowVision();
        } else if (e.getSource() == newVisionButton) {
            runVisionTrackerNewVision();
        } else if (e.getSource() == clearVisionButton) {
            visionTracker.clearVision();
        } else if (e.getSource() == editDescriptionButton) {
            runVisionTrackerEditDescription();
        } else if (e.getSource() == editDeadlineButton) {
            runVisionTrackerEditDeadline();
        } else {
            // Pass
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates GUI from passed Sub Menu JPanel to Main Menu JPanel
    private void returnToMainMenu(JPanel panel) {
        this.remove(panel);
        setupMainMenuJPanel();
        this.add(mainMenuJPanel);
        this.validate();
    }

    // MODIFIES: this
    // EFFECTS: Updates GUI from Main Menu JPanel to passed Menu JPanel
    private void enterPassedMenu(String chosenSubMenu) {
        if (chosenSubMenu.equals("journal")) {
            this.remove(mainMenuJPanel);
            setupJournalMenuJPanel();
            this.add(journalMenuJPanel);
        } else if (chosenSubMenu.equals("habitTracker")) {
            this.remove(mainMenuJPanel);
            setupHabitMenuJPanel();
            this.add(habitMenuJPanel);
        } else if (chosenSubMenu.equals("visionTracker")) {
            this.remove(mainMenuJPanel);
            setupVisionMenuJPanel();
            this.add(visionMenuJPanel);
        } else if (chosenSubMenu.equals("achievementTracker")) {
            this.remove(mainMenuJPanel);
            setupAchievementMenuJPanel();
            this.add(achievementMenuJPanel);
        } else {
            this.remove(mainMenuJPanel);
            setupAuthenticationJPanel();
            this.add(authenticationJPanel);
        }
        this.validate();
    }
}