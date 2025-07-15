package keyin.assignments.LinkedList_ToDoListManager.models;

public class Task {
    public String description;
    public boolean isCompleted;
    public Task next;

    public Task() {
        isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return description + (isCompleted ? " [Completed]" : " [Pending]");
    }


}
