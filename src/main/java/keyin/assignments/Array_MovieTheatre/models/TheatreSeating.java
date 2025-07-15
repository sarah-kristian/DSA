package keyin.assignments.Array_MovieTheatre.models;

public class TheatreSeating {
    private Seat[][] seats;

    public TheatreSeating(int numRows, int numSeatsPerRow) {
        seats = new Seat[numRows][numSeatsPerRow];
        for (int row = 0; row < numRows; row++) {
            for (int seat = 0; seat < numSeatsPerRow; seat++) {
                seats[row][seat] = new Seat(row, seat);
            }
        }
    }

    //Access 2D array element to reserve seat
    public void reserveSeat(int row, int seat) {
        if (seats[row][seat].isReserved()) {
            System.out.println("Seat is already taken.");
            suggestAvailableSeat();
        }else {
            seats[row][seat].reserve();
            System.out.println("Seat reserved!");
        }
    }

    //Access 2D array element to cancel reservation
    public void cancelSeat(int row, int seat) {
        seats[row][seat].cancel();
        System.out.println("Seat cancelled.");
    }

    // 2D traversal: loops through every seat, row by row, and prints it
    public void printSeatingChart() {
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.print(seat);
            }
            System.out.println();
        }
    }

    // 2D traversal: Loops through the rows (top to bottom); inside each row, loops through the seats (left to right)
    // The first time it finds a seat that’s not reserved, it prints the location then ends.
    // This currently prints first available seat. Should update this to print best available seat (and offer chance to reserve it)
    private void suggestAvailableSeat() {
        for (int row = 0; row < seats.length; row++) {
            for (int seat = 0; seat < seats[0].length; seat++) {
                if (!seats[row][seat].isReserved()) {
                    System.out.printf("Try seat at Row %d, Seat %d%n", row + 1, seat + 1);
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }
}
