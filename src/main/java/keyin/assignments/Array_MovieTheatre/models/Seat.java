package keyin.assignments.Array_MovieTheatre.models;

public class Seat {
    private int row;
    private int col;
    private boolean reserved;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.reserved = false;
    }

    public boolean isReserved() { return reserved; }
    public void reserve() { this.reserved = true; }
    public void cancel() { this.reserved = false; }

    @Override
    public String toString() {
        return reserved ? "[X]" : "[ ]";
    }
}

