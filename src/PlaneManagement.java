import java.util.InputMismatchException;
import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;


public class PlaneManagement {

    private static final Ticket[] ticket = new Ticket[52];
    private static int totalSales = 0;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Validates row
     * This method will get seat row and validates its type
     * @return The seat row
     */
    public static String getSeatRow(){
        while(true) { // Loops until it gets a valid input
            try {
                System.out.println("Please input row letter :");  // Gets seat row input
                return scanner.nextLine().toUpperCase();  // Returns seat Row in upper case

            } catch (InputMismatchException e) { // Handles InputMismatch error thrown during input
                scanner.next();
                System.out.println("Please select a letter between A-D");
            }
        }
    }

    /**
     * Validates seat
     * This method will get seat number and validates its type
     * @return The seat number
     */
    public static int getSeatNumber(){
        while(true) {  // Loops until it gets a valid input
            try {
                System.out.println("Please input seat number :");
                int seat = scanner.nextInt();  // Gets seat number input
                scanner.nextLine(); // Clears scanner
                return seat;


            } catch (InputMismatchException e) {  // Handles InputMismatch error thrown during input
                scanner.next();
                System.out.println("Please select a valid seat number");
            }
        }

    }

    /**
     * Books Ticket
     *This function will book the seat after getting inputs from buys_seat method.
     * @param row The array of the Row
     * @param rowName The name of the Row
     * @param seat  The seat number
     */
    public static void bookTicket(int[] row,String rowName, int seat){
        int seatIndex = seat - 1;  // Arrays's index is always one less than seat number
        try {
            if (row[seatIndex] == 0) {  // Checks whether the seat is available
                row[seatIndex] = 1;  // Books seat

                System.out.println("Enter Buyer Name :");
                String name = scanner.nextLine();  // Gets buyer's name
                System.out.println("Enter Buyer Surname :");
                String surname = scanner.nextLine();  // Gets buyer's surname
                System.out.println("Enter Buyer Email :");
                String email = scanner.nextLine();  // Gets buyer's email

                // Creates an object in Person class with inputted details
                Person newPerson = new Person(name,surname,email);

                // Setting price for each ticket categories
                int price;
                if(seat<6){  // Seat 1-5
                    price = 200;
                }
                else if(seat <10){  // Seat 6-9
                    price = 150;
                }
                else{ // Seat 10-12/14
                    price = 180;
                }

                // Creates a new ticket in Ticket class with inputted ticket details and person object.
                Ticket newTicket = new Ticket(rowName,seat,price,newPerson);
                for (int i=0; i < ticket.length; i++ ) {

                    if (ticket[i] == null){  // Finds the first null object in array of objects
                        ticket[i] = newTicket;  // Saves the object in first null object in array.
                        break;
                    }
                }
                newTicket.save();  // Creates ticket file
                System.out.println("Seat  " + rowName + seat + " booked successfully.");
            }
            else {
                System.out.println("Sorry, seat  " + rowName + seat + "  is already booked.");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){  // Validates seat number using Index Error
            System.out.println("Invalid seat number");
        }
    }

    /**
     *
     * @param row
     * @param rowName
     * @param seat
     */

    public static void cancelTicket(int[] row,String rowName,int seat){
        int seatIndex = seat - 1;  // Arrays's index is always one less than seat number
        try {
            if (row[seatIndex] == 1) {  // Checks whether the seat is booked
                row[seatIndex] = 0; // Cancels seat
                System.out.println("Seat  " + rowName + seat + "  canceled successfully.");

                for (int i=0; i < ticket.length; i++ ) {  //Loops through the array to search the seat
                    if (ticket[i] != null){  // Checks and avoids null objects in the array

                        // Finds the inputted seat using getters of ticket object
                        if ((ticket[i].getRow().equals(rowName))&&(ticket[i].getSeat() == seat)){
                            ticket[i] = null;  // Changes the value of that index to null
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("Seat  " + rowName + seat + " does not have any booking.");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){  // Validates seat number using Index Error
            System.out.println("Invalid seat number");

        }
    }

    /**
     *
     * @param rowA
     * @param rowB
     * @param rowC
     * @param rowD
     */

    public static void buy_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        String seatRow = getSeatRow();  // Gets type validated seat Row
        int seatNumber = getSeatNumber();  // Gets type validated seat Number

        // Calls bookTicket function providing respective parameters.
        switch(seatRow){

            case "A":
                bookTicket(rowA,seatRow,seatNumber);
                break;
            case "B":
                bookTicket(rowB,seatRow,seatNumber);
                break;
            case "C":
                bookTicket(rowC,seatRow,seatNumber);
                break;
            case "D":
                bookTicket(rowD,seatRow,seatNumber);
                break;
            default:
                System.out.println("Invalid Seat Row");  // Validates seat Row
                break;             

        }
    }

    /**
     *
     * @param rowA
     * @param rowB
     * @param rowC
     * @param rowD
     */

    public static void cancel_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        String seatRow = getSeatRow();
        int seatNumber = getSeatNumber();

        switch(seatRow){

            case "A":
                cancelTicket(rowA,seatRow,seatNumber);
                break;
            case "B":
                cancelTicket(rowB,seatRow,seatNumber);
                break;
            case "C":
                cancelTicket(rowC,seatRow,seatNumber);
                break;
            case "D":
                cancelTicket(rowD,seatRow,seatNumber);
                break;
            default:
                System.out.println("Invalid Seat Row");
                break;

        }
    }

    /**
     *
     */

    public static void displayMenu() {

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
     *
     * @param rowA
     * @param rowB
     * @param rowC
     * @param rowD
     */

   public static void find_first_available(int[] rowA, int[] rowB, int[] rowC, int[] rowD){
        int[][] array = {rowA,rowB,rowC,rowD};

        String rowName;

        rowLoop:
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    if (Arrays.equals(ints, rowA)) {
                        rowName = "A";
                    } else if (Arrays.equals(ints, rowB)) {
                        rowName = "B";
                    } else if (Arrays.equals(ints, rowC)) {
                        rowName = "C";
                    } else {
                        rowName = "D";
                    }
                    int seatName = j + 1;  // Seat number is the column index + 1
                    System.out.println("First available seat is : " + rowName + seatName);
                    break rowLoop;

                }
            }
        }
    }

    /**
     *
     * @param rowA
     * @param rowB
     * @param rowC
     * @param rowD
     */

    public static void show_seating_plan(int[] rowA, int[] rowB, int[] rowC, int[] rowD){
        int[][] array = {rowA,rowB,rowC,rowD};

        for (int[] row : array) {
            for (int seat : row) {
                if (seat == 0) {
                    System.out.print("O ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();  // Move to the next line after each row
        }
    }

    /**
     *
     */

    public static void print_tickets_info(){
        for(int i=0; i<ticket.length;i++){
            if(ticket[i] != null){
                ticket[i].printInfo();
                System.out.println();

                totalSales = totalSales+ ticket[i].getPrice();
            }
        }
        System.out.println("Total sales for the session is : " + totalSales);
    }

    /**
     *
     */

    public static void search_ticket(){
        String seatRow = getSeatRow();
        int seatNumber = getSeatNumber();

        boolean loopCompleted = true;

        for (int i=0; i < ticket.length; i++ ) {
            if (ticket[i] != null){
                if ((ticket[i].getRow().equals(seatRow))&&(ticket[i].getSeat() == seatNumber)){
                    ticket[i].printInfo();
                    System.out.println();
                    loopCompleted = false;
                    break;
                }
            }
        }

        if(loopCompleted){
            System.out.println("This seat is available");
        }
    }


    public static void main(String[] args){
        // Initializing seats
        int[] rowA = new int[14];
        int[] rowB = new int[12];
        int[] rowC = new int[12];
        int[] rowD = new int[14];

        System.out.println("Welcome to the Plane Management Application");

        int userInput;

        mainLoop:
        while(true){
            // Displays menu
            displayMenu();
            while (true){
                try{
                    System.out.println("\nPlease select an option :");
                    userInput = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }
                catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Please enter a value between 0-6");
                }
            }

            switch (userInput){
                case 0:
                    break mainLoop;

                case 1:
                    buy_seat(rowA,rowB,rowC,rowD);
                    break;

                case 2:
                    cancel_seat(rowA,rowB,rowC,rowD);
                    break;

                case 3:
                    find_first_available(rowA,rowB,rowC,rowD);
                    break;

                case 4:
                    show_seating_plan(rowA,rowB,rowC,rowD);
                    break;

                case 5:
                    print_tickets_info();
                    break;

                case 6:
                    search_ticket();
                    break;

                default:
                    System.out.println("Invalid Input");

            }
        }
    }
}