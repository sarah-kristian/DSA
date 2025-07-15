package keyin.assignments.LinkedList_ToDoListManager.models;


public class ToDoList {
        public Task head;
        public Task tail;
        public int size;

    public void createToDoList(String taskValue) {
        Task task = new Task();
        task.next = null;
        task.description = taskValue;
        head = task;
        tail = task;
        size = 1;
    }

    //Insert Method
    public void insertTask(String taskValue, int location) {
        Task newTask = new Task();
        newTask.description = taskValue;

        if (head == null) {
            head = tail = newTask;
        } else if (location <= 0) {
            newTask.next = head;
            head = newTask;
        } else if (location >= size) {
            tail.next = newTask;
            tail = newTask;
        } else {
            Task current = head;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            newTask.next = current.next;
            current.next = newTask;
        }

        size++;
    }


    // Traversing through a linked list
    public void printToDoList() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Task tempTask = head;
        int index = 1;
        while (tempTask != null) {
            System.out.println(index++ + ". " + tempTask);
            tempTask = tempTask.next;
        }
    }


    //Search for an element
    public boolean markTaskAsCompleted(int index) {
        index--; // Convert 1-based input to 0-based internal index

        if (index < 0 || index >= size) {
            System.out.println("Invalid task number.");
            return false;
        }

        Task temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.markAsCompleted();
        return true;
    }

    //implement deleting a task from single linked list
    public void deleteTask(int location) {

        // empty list (== no head)
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Invalid position (position doesn't exist)
        if (location < 0 || location >= size) {
            System.out.println("Invalid position: " + location);
        }

        // Delete at beginning (i.e., delete current head, make next task head)
        if (location == 0) {
            // update next task (after current head) to be the head
            head = head.next;

            // decrement the size
            size--;

            // If there are no more tasks, mark the tail as null
            if (size == 0) {
                tail = null;
            }
            return;
        }

        // Delete elsewhere: (whether it's in the middle or the tail, need to traverse the length of the link till we find the task)
        if (location == size - 1) {
            //Move tempTask to task before the one being deleted
            Task tempTask = head;
            for (int i = 0; i < location - 1; i++) {
                tempTask = tempTask.next;
            }

            // delete the task
            Task taskToDelete = tempTask.next; // find where the task to delete points
            tempTask.next = taskToDelete.next; // make the previous task (before the one to delete) point to the following task (after the one to delete)

            // if the deleted task was the tail, make the task before it the tail
            if (location == size - 1) {
                tail = tempTask;
            }

            // reduce size of list
            size--;
        }
    }
}


