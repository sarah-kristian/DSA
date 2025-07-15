package keyin.assignments.Array_TemperatureCalculator;
/**
 * The {@code keyin.assignments.Array_TemperatureCalculator.TemperatureAnalyzer} class provides a console-based program
 * that allows users to input daily temperatures, calculates the average temperature,
 * and reports how many days were above the average.
 * <p>
 * This program demonstrates input validation, array handling,
 * and basic statistical analysis in Java. It is designed to be beginner-friendly,
 * modular, and testable.
 * </p>
 *
 * <p><strong>Features:</strong></p>
 * <ul>
 *   <li>Prompts the user to enter the number of days</li>
 *   <li>Collects temperature values for each day</li>
 *   <li>Calculates the average temperature</li>
 *   <li>Counts and displays how many days were above average</li>
 * </ul>
 *
 * @author Sarah
 */

import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printIntro();

        int numberOfDays = promptForNumberOfDays(scanner);

        int[] temperatures = getTemperaturesFromUser(scanner, numberOfDays);

        double averageTemperature = calculateAverage(temperatures);
        int daysAboveAverage = countDaysAboveAverage(temperatures, averageTemperature);

        // print results
        System.out.printf("\nAverage temperature: %.2f\n", averageTemperature);
        System.out.println("Number of days above average: " + daysAboveAverage);
    }


    /**
     * Prints the program introduction to the console.
     * <p>
     * This method is intentionally separated from the main logic to make it easier
     * to update or localize the intro text without affecting the core functionality.
     * This design choice supports future plans to add bilingual support (e.g., English and French).
     * Note: Localization is not yet implemented, and only this introductory text would be affected.
     * </p>
     */
    public static void printIntro() {
        System.out.println("==========================================");
        System.out.println("   Welcome to the Temperature Analyzer");
        System.out.println("==========================================");
        System.out.println("You'll enter temperatures for several days,");
        System.out.println("and I'll tell you the average and how many");
        System.out.println("days were hotter than average.\n");
    }


    public static int promptForNumberOfDays(Scanner scanner) {
        while (true) {
            System.out.print("Enter the number of days (1 or more): ");
            if (scanner.hasNextInt()) {
                int days = scanner.nextInt();
                if (days >= 1) {
                    return days;
                } else {
                    System.out.println("Please enter a number greater than zero.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number (integer).");
                scanner.next(); // discard invalid token
            }
        }
    }



    public static int[] getTemperaturesFromUser(Scanner scanner, int numberOfDays) {
        int[] temperatures = new int[numberOfDays];
        for (int dayCount = 0; dayCount < numberOfDays; dayCount++) {
            while (true) {
                System.out.printf("Enter temperature for day %d: ", dayCount + 1);
                if (scanner.hasNextInt()) {
                    temperatures[dayCount] = scanner.nextInt();
                    break; // valid input, move on
                } else {
                    System.out.println("Invalid input. Please enter a whole number (integer).");
                    scanner.next(); // clear the invalid token
                }
            }
        }
        return temperatures;
    }


    public static double calculateAverage(int[] temperatures) {
        int temperatureSum = 0;
        for (int temp : temperatures) {
            temperatureSum += temp;
        }
        return (double) temperatureSum / temperatures.length;
    }


    public static int countDaysAboveAverage(int[] temperatures, double averageTemperature) {
        int numDaysAboveAverage = 0;
        for (int temp : temperatures) {
            if (temp > averageTemperature) {
                numDaysAboveAverage++;
            }
        }
        return numDaysAboveAverage;
    }
}
