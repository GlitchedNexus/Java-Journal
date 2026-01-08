# Journaling App

## Project Overview

### Conditions
Must have at least four functionalities of which one must include arbitrary number of inputs into a list.

### What will the application do?
1. Calendar
2. Achievements Tracker
3. Journal Entry 
4. Habit Tracker
5. Vision Planner
6. Allow multiple users to use the app.
7. Allow users to sign in and out of their accounts.

### Who will use it?
People who are trying to find an integrated organisation system that combines all necessary tools for life organisation and future planning.

### Why is this project of interest to you?
I am very interested in optimising my life to achieve maximum productivity, so to have an app that allows me to integrate all my favourite features into one workflow.

### User Stories
1. As a user, I want to be able to change my habits goals to suit my needs.
2. As a user, I want to be able to track my vision and evolve it with time.
3. As a user, I want to be able to add multiple entries on a given day.
4. As a user, I want to be able to track the quality of my life, so I can adapt accordingly.
5. As a user, I want to be able to track my Achievements my day.
6. As a user, I want to be able to customise the journal prompt if I feel Like I want to change it.
7. As a user, I want to be able to be able to sign in and out of my account. 
8. As a user, I want to be able to have multiple accounts on the app.
9. As a user, I want to be able to save the work I have done.
10. As a user, I want to be able to load the work I have saved if I choose too.

### Instructions for Grader
The app features buttons for each task the app can handle. 
Buttons have been labelled to indicate the function they perform. This includes the 
load and save buttons. Additionally, you will receive a JOptionPane confirmation message for the 
load data. All add X to Y options will give you a JOptionPane asking for input. Furthermore,
you will also have a button to show you all items and to manipulate the number of items like remove or clear all.

### Phase 4: Task 2
Sample of EventLog:

Wed Apr 12 16:40:50 PDT 2023 \
New User Added. \
Wed Apr 12 16:40:53 PDT 2023 \
New Session Login For R. \
Wed Apr 12 16:41:15 PDT 2023 \
New Entry Added \
Wed Apr 12 16:41:20 PDT 2023 \
New Entry Added \
Wed Apr 12 16:41:25 PDT 2023 \
Removed Last Entry. \
Wed Apr 12 16:41:27 PDT 2023 \
Cleared All Entries. \
Wed Apr 12 16:41:33 PDT 2023 \
Added Habit: Code. \
Wed Apr 12 16:41:37 PDT 2023 \
Removed Habit: Code. \
Wed Apr 12 16:41:39 PDT 2023 \
Cleared HabitTracker. \
Wed Apr 12 16:41:58 PDT 2023 \
New Vision Defined \
Wed Apr 12 16:42:00 PDT 2023 \
VisionTracker Cleared. \
Wed Apr 12 16:42:01 PDT 2023 \
VisionTracker Cleared. \
Wed Apr 12 16:42:03 PDT 2023 \
New Vision Defined \
Wed Apr 12 16:42:05 PDT 2023 \
Vision Description Updated. \
Wed Apr 12 16:42:07 PDT 2023 \
Vision Deadline Updated. \
Wed Apr 12 16:42:13 PDT 2023 \
Removed Achievement: Run. \
Wed Apr 12 16:43:28 PDT 2023 \
Cleared AchievementTracker. \
Wed Apr 12 16:43:32 PDT 2023 \
Saved App Instance



### Phase 4: Task 3
Reflecting on the project UML diagram and having gone through the code over the development of this project,
1. I would create and abstract Tracker class containing all basic functions for the Tracker classes and Journal. Reducing code duplication but this comes at the tradeoff that the current design allows me complete control over tailoring the design of each of these classes which will be taken away. Furthermore, this would increase code cohesion.
2. I would add exceptions and exception handling for adding robustness to my code to prevent it from crashing in case of unexpected behaviour. This would drastically increase the complexity of the code.
3. I would Make separate UI classes for all different screens instead of multiple JPanels pasted on the same JFrame. This would allow me to separately control different menus' GUIs and not break all other menus in case of an error, whilst making the code more concise and organised. Of course, this would come at the cost of simplicity.