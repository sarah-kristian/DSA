package keyin.assignments.LinkedList_ToDoListManager;

import keyin.assignments.LinkedList_ToDoListManager.models.User;

/**
 * The Main class is the entry point to demonstrate the usage of the User and ToDoList classes
 * for managing user-specific task management.
 *
 * Each User can have a personalized to-do list where tasks can be added, marked as completed,
 * and displayed. The main method initializes users, assigns tasks to their respective lists,
 * updates task completion statuses, and displays the tasks.
 */
public class Demo {
    public static void main(String[] args) {
        User[] users = new User[3];
        users[0] = new User("Gerald");
        users[1] = new User("Sans");
        users[2] = new User("Jeremie");

        // Add tasks for Gerald
        users[0].addTask("Get Milk", 0);
        users[0].addTask("Paint Room", 1);
        users[0].addTask("Finish report", 2);

        // Add tasks for Sans
        users[1].addTask("Get Dog Treats", 0);
        users[1].addTask("Feed Dog", 1);

        // Add tasks for Jeremie
        users[2].addTask("Walk dog", 0);

        // Mark some tasks as completed
        users[0].completeTask(1);
        users[1].completeTask(2);

        // Show tasks for all users
        for (User user : users) {
            user.showTasks();
            System.out.println("------------------------");
        }
    }
}