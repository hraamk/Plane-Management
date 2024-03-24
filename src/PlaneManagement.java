import java.util.InputMismatchException;
import java.util.Scanner;  // Import the Scanner class

/**
 * This class performs a ticket booking of a commercial airline.
 */
public class PlaneManagement {
    //Initializing array of objects
    private static final Ticket[] ticket = new Ticket[52];

    //Initializing scanner
    private static Scanner scanner = new Scanner(System.in);

    /**
     * This function gets seat row as input from user and validates its type and value
     * @return Validated seat row as char
     */
    public static char getSeatRow(){
        while(true) { // Loops until it gets a valid input
            System.out.println("Please input a row letter between A-D :");  // Gets seat row input
            char row =  scanner.next().toUpperCase().charAt(0);// Returns seat in upper case
            if(row>='A' && row <= 'D'){
                return row;
            }
        }
    }

    /**
     * This function gets seatNumber as input from user and validates its type and value
     * @param seatingPlan The array contains seating plan and information
     * @param seatRow Validated seat row as char
     * @return Validated seat number as integer
     */

    public static int getSeatNumber(int[][] seatingPlan,char seatRow){
        int rowIndex = seatRow-'A';
        while(true) {  // Loops until it gets a valid input
            try {
                System.out.println("Please input seat number :");
                int seat = scanner.nextInt();  // Gets seat number input
                scanner.nextLine(); // Clears scanner
                if(seat <= seatingPlan[rowIndex].length){
                    return seat;
                }
                else{
                    System.out.println("Please input a valid seat number.");
                }

            } catch (InputMismatchException e) {  // Handles InputMismatch error thrown during input
                scanner.next();
                System.out.println("Please input a valid seat number.");

            }
        }
    }

    /**
     * This function returns price of the seat number entered
     * @param seatNumber Validated seat number as integer
     * @return Price of the relevant seat as int
     */

    public static int price(int seatNumber){
        if(seatNumber<6){  // Seat 1-5
            return 200;
        }
        else if(seatNumber <10){  // Seat 6-9
            return  150;
        }
        else{ // Seat 10-12/14
            return 180;
        }

    }

    /**
     * This function will book seat after getting validated seat row and seat number
     * @param seatingPlan The array contains seating plan and information
     */

    public static void buy_seat(int[][] seatingPlan) {
        char seatRow = getSeatRow();  // Gets validated seat Row
        int seatNumber = getSeatNumber(seatingPlan,seatRow);  // Gets validated seat Number

        int rowIndex = seatRow-'A';
        int seatIndex = seatNumber - 1;  // Array's index is always one less than seat number

        if (seatingPlan[rowIndex][seatIndex] == 0) {  // Checks whether the seat is available

            seatingPlan[rowIndex][seatIndex] = 1;  // Books seat

            System.out.println("Enter Buyer Name :");
            String name = scanner.nextLine();  // Gets buyer's name
            System.out.println("Enter Buyer Surname :");
            String surname = scanner.nextLine();  // Gets buyer's surname
            System.out.println("Enter Buyer Email :");
            String email = scanner.nextLine();  // Gets buyer's email

            // Creates an object in Person class with inputted details
            Person newPerson = new Person(name,surname,email);

            // Setting price for each ticket categories
            int price=price(seatNumber);

            // Creates a new ticket in Ticket class with inputted ticket details and person object.
            Ticket newTicket = new Ticket(seatRow,seatNumber,price,newPerson);
            for (int i=0; i < ticket.length; i++ ) {
                // Finds the first null object in array of objects
                if (ticket[i] == null){
                    ticket[i] = newTicket;  // Saves the object in first null object in array.
                    break;
                }
            }
            newTicket.save();  // Creates ticket file
            System.out.println("Seat  " + seatRow + seatNumber + " is booked successfully.");
        }
        else {
            System.out.println("Sorry, seat  " + seatRow + seatNumber + "  is already booked.");
        }
    }

    /**
     * This function will cancel a booked seat after getting validated seat row and seat number
     * @param seatingPlan The array contains seating plan and information
     */


    public static void cancel_seat(int[][] seatingPlan) {
        char seatRow = getSeatRow();
        int seatNumber = getSeatNumber(seatingPlan,seatRow);

        int rowIndex = seatRow-'A';

        int seatIndex = seatNumber - 1;  // Array's index is always one less than seat number
        if (seatingPlan[rowIndex][seatIndex] == 1) {  // Checks whether the seat is booked
            seatingPlan[rowIndex][seatIndex] = 0; // Cancels seat
            System.out.println("Seat  " + seatRow + seatNumber + " is cancelled successfully.");

            for (int i=0; i < ticket.length; i++ ) {  //Loops through the array to search the seat
                if (ticket[i] != null){  // Checks and avoids null objects in the array

                    // Finds the inputted seat using getters of ticket object
                    if (ticket[i].getRow() == seatRow && ticket[i].getSeat() == seatNumber){
                        ticket[i].deleteFile(); // Deletes the ticket file
                        ticket[i] = null;  // Changes the value of that index to null
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("Seat  " + seatRow + seatNumber + " does not have any booking.");
        }

    }

    /**
     * Displays Menu
     * This function prints the menu to user.
     */

    public static void displayMenu() {

        //Prints stars
        for(int i = 0; i <50;i++){
            System.out.print("*");
        }
        System.out.print("\n*");
        for(int i = 0; i <17;i++){
            System.out.print(" ");
        }
        System.out.print(" MENU OPTIONS ");
        for(int i = 0; i <17;i++){
            System.out.print(" ");
        }
        System.out.println("*");
        for(int i = 0; i <50;i++){
            System.out.print("*");
        }

        System.out.println("\n\t1) Buy a ticket");
        System.out.println("\t2) Cancel a seat");
        System.out.println("\t3) Find first available seat");
        System.out.println("\t4) Show seating plan");
        System.out.println("\t5) Print ticket information and total sales");
        System.out.println("\t6) Search ticket");
        System.out.println("\t0) Quit");

        for(int i = 0; i <50;i++){
            System.out.print("*");
        }
    }

    /**
     * This function will find and return the first available seat.
     * @param seatingPlan The array contains seating plan and information
     */

   public static void find_first_available(int[][] seatingPlan){
       char row = 'A';

        rowLoop: // Naming outer loop as rowLoop
        for (int[] ints : seatingPlan) {
            for (int j = 0; j < ints.length; j++) {
                // Finds available seat while looping through array.
                if (ints[j] ==  0) {
                    int seatName = j + 1;  // Seat number is the column index + 1
                    System.out.println("First available seat is : " + row + seatName);
                    break rowLoop;
                }
            }
            row++;
        }
    }

    /**
     * This function will print the seating order and seat availability.
     * @param seatingPlan The array contains seating plan and information
     */

    public static void show_seating_plan(int[][] seatingPlan){
        System.out.println();
        for (int i = 0; i < seatingPlan.length; i++) {
            if(i == 2){
                System.out.println();
            }
            for (int seat : seatingPlan[i]) {
                if (seat == 0) {
                    System.out.print("O  ");
                }
                else {
                    System.out.print("X  ");
                }
            }
            System.out.println();  // Move to the next line after each row
        }
    }


    /**
     * Prints ticket information.
     * This function will access the array of objects which contents ticket information and prints information.
     */

    public static void print_tickets_info(){
        int totalSales = 0;
        for (Ticket value : ticket) {
            if (value != null) {
                value.printInfo();
                System.out.println();

                totalSales = 0;
                totalSales = totalSales + value.getPrice();
            }
        }
        System.out.println("Total sales for the session is : " + totalSales);
    }

    /**
     * Searches for a specific ticket
     * This function will search for a user inputted ticket and prints its details.
     */

    public static void search_ticket(int[][] seatingPlan){
        char seatRow = getSeatRow();  // Gets seat row after validation
        int seatNumber = getSeatNumber(seatingPlan,seatRow);  // Gets seat number after validation

        boolean loopCompleted = true;  // Initializes boolean to check whether loop finished without breaking

        for (int i=0; i < ticket.length; i++ ) {  // Iterates through array of objects
            if (ticket[i] != null){  // Avoids null objects while searching
                // Checks user inputted information with data from getters to find that ticket
                if (ticket[i].getRow()== seatRow && ticket[i].getSeat() == seatNumber){
                    ticket[i].printInfo();
                    System.out.println();
                    loopCompleted = false;
                    break;
                }
            }
        }
        if(loopCompleted){  // Checks whether the loop finished all iterations without breaking.
            System.out.println("This seat is available.");  // Prints that seat doesn't have any bookings.
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("\nPress Enter to go to main menu");
        scanner.nextLine(); // Waits for the user to press Enter
    }

    public static void main(String[] args){

        // Initializing seats
        int[] rowA = new int[14];
        int[] rowB = new int[12];
        int[] rowC = new int[12];
        int[] rowD = new int[14];

        int[][] seatingPlan = {rowA,rowB,rowC,rowD};

        System.out.println("Welcome to the Plane Management Application");  // Welcome note

        int userInput;

        mainLoop:  // Naming outer loop as main loop
        while(true){
            // Displays menu
            displayMenu();

            while (true){
                try{
                    System.out.println("\nPlease select an option :");
                    userInput = scanner.nextInt(); // Gets input from user
                    scanner.nextLine(); // Clears scanner
                    break;
                }
                catch (InputMismatchException e) {  // Handles error caused by entering wrong type of input
                    scanner.next();
                    System.out.println("Please enter a value between 0-6.");
                }
            }

            switch (userInput){
                case 0:
                    scanner.close();
                    break mainLoop; // Exits program

                case 1:
                    buy_seat(seatingPlan);// Calls buy_seat to make a booking
                    pressEnterToContinue();
                    break;

                case 2:
                    cancel_seat(seatingPlan);  // Calls cancel_seat to cancel a booking
                    pressEnterToContinue();
                    break;

                case 3:
                    find_first_available(seatingPlan); // Calls method to print first available seat
                    pressEnterToContinue();
                    break;

                case 4:
                    show_seating_plan(seatingPlan);  // Prints the seating plan
                    pressEnterToContinue();
                    break;

                case 5:
                    print_tickets_info();  // Prints details of all tickets booked and sales information of this session.
                    pressEnterToContinue();
                    break;

                case 6:
                    search_ticket(seatingPlan);  // Searches for a particular ticket and prints its information.
                    pressEnterToContinue();
                    break;

                default:
                    System.out.println("Invalid Input\nSelect an option between 0-6");  // Validates invalid input for menu.
                    System.out.println();

            }
        }
    }
}