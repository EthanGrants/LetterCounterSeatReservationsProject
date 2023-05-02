// Import at top
import java.util.Scanner;
/** AirlineSeatReservations.java - Book a flight
 * <p>Problem Statement: Write a program to assign passenger's seats in a small airplane
 * </p>
 * 
 * <p>Algorithm: <br />
 *   1. Import java.util.Scanner <br />
 *   2. Create class <br />
 *   3. Create array  <br />
 *   4. Loop through seat array, assigning letters  <br />
 *   5. Have a printSeats method  <br />
 *   6. Create an availableSeats variable, print heading and then create 2 for loops  <br />
 *   7. Loop through and print out each line, have a tracker inside an if statement for availableSeats and rows  <br />
 *   8. Print a new line, and then the available seats.  <br />
 *   9.Create a bookSeat method  <br />
 *   10.Have a while loop and ask user for inputs, see if sentinel value of 0 is entered, quitting if so  <br />
 *   11.Put the input into two different variables, one for row and one for column  <br />
 *   12.Set an if loop error trap  <br />
 *   13.See if a seat is already occupied with if statement  <br />
 *   14.Mark the seat as taken and end while loop, returning true if seat was booked  <br />
 *   15.In main, have a flag set to false so in a while loop, while it is false, print the seating map, and check if
 *      sentinel was entered  <br />
 *   16.Then have all seats booked set to true, test to see if it is true, if so then exit while loop  <br />
 *   17.Test and compile  <br />
 *      
 * </p>
 *   @author Ethan Grant
 *   @version Module 8, Homework 2
 */

public class AirlineSeatReservations {
    public static void main(String[] args) 
    {

        // Variable
        char[][] seats = new char[7][4];

        // loop through seats array
        for (int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                // Assign current seat to a letter
                seats[i][j] = "ABCD".charAt(j);
            }
        }

        // Flag to control when user is done booking seats
        boolean done = false;

        // Setup the input scanner
        Scanner scanner = new Scanner(System.in);

        // While done is false, (not done), keep looping
        while(!done) {
            // print the current seating map
            printSeats(seats);
            // Books the seat, then checks to see whether user has canceled with 0
            if (bookSeat(seats, scanner)) {
                // If the sentinel value was entered, we are done. Stop looping.
                done = true;
            }
            // If all seats booked, set done to true
            boolean allSeatsBooked = true;
            // checkForAvailableSeats named as a for loop in order to break the loop
            // Looping through seat array, if seat is available, 
            checkForAvailableSeats: for (int i = 0; i < seats.length; i++) {
                for(int j = 0; j < seats[i].length; j++) {
                    // If seat not occupied, set all seats to false and break loop
                    if (seats[i][j] != 'X') {
                        allSeatsBooked = false;
                        break checkForAvailableSeats;
                    }
                }
            }
            // If allSeatsBooked is true, print statement
            if (allSeatsBooked) {
                System.out.println("All seats are booked.");
                done = true; 
            }
        }
    }

    /**
     * Prints the seating map
     * @param seats seating map to print
     */
    public static void printSeats(char[][] seats) {
        // Variable
        int availableSeats = 0;
        int rowCounter = 1;
        // Print heading
        System.out.println("Available seats: (Seats marked 'X' are already reserved");
        // Print row
        System.out.print("Row\n");
        // loop through seats array
        for (int i = 0; i < seats.length; i++) {
            // Print each row
            System.out.printf("%d ", rowCounter);
            for(int j = 0; j < seats[i].length; j++) {
                // Print current seat
                System.out.printf("%c ", seats[i][j]);

                // If current seat not taken, increment current seat by 1
                if (seats[i][j] != 'X') {
                    availableSeats++;
                }
            }
            // Increment for each row
            rowCounter++;
            // Move down a line
            System.out.print("\n");
        }
        // Print available seats
        System.out.println("\nThere are " + availableSeats + " seats available.");
    }

    /**
     * Books a seat from a specified seating map
     * 
     * @param seats the seating map to book a seat
     * @param scanner a reference to the currently open input scanner
     * @return returns false if the seat was successfully booked and true if the sentinel value was entered
     */
    public static boolean bookSeat(char[][] seats, Scanner scanner) {
        // flag to control when to stop
        boolean validSeat = false;

        while (!validSeat) {
            // Ask user to enter a seat row
            System.out.print("Enter a row followed by a seat letter or enter 0 to cancel: ");
            String input = scanner.nextLine();

            // Check if sentinel value was entered
            if (input.compareTo("0") == 0) {
                return true;
            }
            // '0' is value 48, parse by putting into two different integers
            int row = input.charAt(0) - '0' - 1;
            // Finds where input is in ABCD, 1 is where number is at
            int column = "ABCD".indexOf(input.charAt(1));

            // Error trap
            if (row < 0 || row > 6 || column < 0 || column > 3) {
                System.out.print("Invalid input. ");
                continue;
            }

            // Ensure that the seat isn't already taken 
            if (seats[row][column] == 'X') {
                System.out.print("Seat is already occupied. ");
                continue;
            }
            // mark the seat as taken
            seats[row][column] = 'X';

            // Ends while loop
            validSeat = true;
        }
        // Return false if seat was successfully booked
        return false;
    }
}

