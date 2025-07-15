package keyin.assignments.Array_MovieTheatre;

import keyin.assignments.Array_MovieTheatre.models.TheatreSeating;
import java.util.Scanner;

/**
 * The {@code TheaterDemo} class provides a console-based simulation of a movie theater
 * reservation system where users can reserve or cancel seats and view a live seating chart.
 * <p>
 * This program demonstrates 2D array traversal, basic object-oriented design,
 * input validation, and user interaction using a simple menu-driven interface.
 * It is designed for learning and demonstration purposes.
 * </p>
 *
 * <p><strong>Features:</strong></p>
 * <ul>
 *   <li>Initializes a customizable theater with rows and seats</li>
 *   <li>Allows users to reserve or cancel seats via console input</li>
 *   <li>Validates seat input to ensure valid and available selections</li>
 *   <li>Displays the current seating chart with reserved and available seats</li>
 *   <li>Suggests the next available seat if a chosen one is taken</li>
 *   <li>Includes a reusable method for selecting seats with input validation</li>
 *   <li>Supports optional random seat-filling and random reservations</li>
 * </ul>
 *
 * <p><strong>Use Cases:</strong></p>
 * <ul>
 *   <li>Beginner projects in object-oriented Java</li>
 *   <li>Class demos for 2D arrays and user input</li>
 *   <li>Scaffold for expanding into a full reservation system (e.g., ticket prices, user accounts)</li>
 * </ul>
 *
 * @author Sarah
 */


public class TheatreDemo {
    public static void main(String[] args) {
        TheatreSeating theatreSeating = new TheatreSeating(12, 20);  // 12 rows, 20 seats per row
        Scanner scanner = new Scanner(System.in);

        boolean runProgram = true;
        while (runProgram) {
            System.out.println("\n--- Movie Theatre Seat Booking ---");
            System.out.println("1. Show seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theatreSeating.printSeatingChart();
                    break;

                case 2:
                    int[] reserveSeat = selectSeat(scanner);
                    theatreSeating.reserveSeat(reserveSeat[0], reserveSeat[1]);
                    break;

                case 3:
                    int[] cancelSeat = selectSeat(scanner);
                    theatreSeating.cancelSeat(cancelSeat[0], cancelSeat[1]);
                    break;

                case 4:
                    runProgram = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }


    public static int[] selectSeat(Scanner scanner) {
        int row = -1;
        int seat = -1;

        while (row < 1 || row > 12) {
            System.out.print("Enter row (1–12): ");
            row = scanner.nextInt();
            if (row < 1 || row > 12) {
                System.out.println("Invalid row. Try again.");
            }
        }

        while (seat < 1 || seat > 20) {
            System.out.print("Enter seat (1–20): ");
            seat = scanner.nextInt();
            if (seat < 1 || seat > 20) {
                System.out.println("Invalid seat. Try again.");
            }
        }

        return new int[]{row - 1, seat - 1}; // convert to 0-based for reading arrays
    }


}
