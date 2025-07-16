package keyin.assignments.LinkedList_UndoRedoManager;

public class UndoRedoDemo {
    public static void main(String[] args) {
        UndoRedoList<String> history = new UndoRedoList<>();

        history.addState("State 1");
        history.addState("State 2");
        history.addState("State 3");

        System.out.println("**Initial List**");
        history.printStates(); // Should show all states with current at "State 3"

        System.out.println("\n**Current State after...**");
        history.undo();
        System.out.println("undo: " + history.getCurrentState()); // "State 2"

        history.undo();
        System.out.println("undo: " + history.getCurrentState()); // "State 1"

        history.redo();
        System.out.println("redo: " + history.getCurrentState()); // "State 2"

        history.addState("State 4");
        System.out.println("Add state: " + history.getCurrentState()); // "State 4"

        System.out.println("\n**Current List**");
        history.printStates(); // "State 1" -> "State 2" -> "State 4"

        history.clear();
        System.out.println("\n**Cleared List**");
        history.printStates(); //
    }
}