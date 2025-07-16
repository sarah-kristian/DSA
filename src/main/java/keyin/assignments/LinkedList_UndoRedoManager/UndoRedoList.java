package keyin.assignments.LinkedList_UndoRedoManager;

import java.util.NoSuchElementException;

/**
 * A generic implementation of an undo-redo list data structure that maintains
 * a history of states and allows navigation between them.
 * <p>
 * This implementation supports adding new states, undoing to previous states,
 * and redoing previously undone states. When a new state is added after an undo
 * operation, all potential redo states are discarded.
 *
 * @param <T> the type of elements stored in this list
 */
public class UndoRedoList<T> {
    private class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private Node current;

    public UndoRedoList() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a new state (a new node that will be current)
    public void addState(T state) {
        Node newNode = new Node(state);

        // Step 1: If we're not at the end, discard all redo states.
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        // Step 2: Add the new node
        if (head == null) {
            // List is empty: initialize head, tail, and current
            head = newNode;
        } else {
            // Append after current tail
            tail.next = newNode;
            newNode.prev = tail;
        }

        // Step 3: Update tail and mark the current state
        tail = newNode;
        current = newNode;
    }

    // Undo: move to the previous state
    public boolean undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return true;
        }
        return false; // Can't undo
    }


    // Redo: move to the next state
    public boolean redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return true;
        }
        return false; // Can't redo
    }


    // Get current state
    public T getCurrentState() {
        if (current == null) {
            throw new NoSuchElementException("No current state available");
        }
        return current.data;
    }

    public void clear() {
        head = null;
        tail = null;
        current = null;
    }

    // For debugging: print the entire list
    public void printStates() {
        Node temp = head;
        System.out.print("States: ");
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.data + "] "); // Highlight current
            } else {
                System.out.print(temp.data + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

