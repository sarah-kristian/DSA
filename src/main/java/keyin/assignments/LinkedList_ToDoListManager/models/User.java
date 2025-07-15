package keyin.assignments.LinkedList_ToDoListManager.models;

public class User {
    private String name;
    private ToDoList tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ToDoList();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addTask(String taskValue, int location) {
        tasks.insertTask(taskValue, location);
    }

    public void completeTask(int taskNumber) {
        if (!tasks.markTaskAsCompleted(taskNumber)) {
            System.out.println("Task not found at index: " + taskNumber);
        }
    }

    public void showTasks() {
        System.out.println("Tasks for " + name + ":");
        tasks.printToDoList();
    }

}
