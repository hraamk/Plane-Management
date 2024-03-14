import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;


public class PlaneManagement {

    private static Ticket[] ticket = new Ticket[52];

    public static void bookTicket(int[] row,String rowName, int seat){
        int seatIndex = seat - 1;
        try {
            if (row[seatIndex] == 0) {
                row[seatIndex] = 1;

                Scanner personInfo = new Scanner(System.in);
                System.out.println("Enter Buyer Name :");
                String name = personInfo.nextLine();
                System.out.println("Enter Buyer Surname :");
                String surname = personInfo.nextLine();
                System.out.println("Enter Buyer Email :");
                String email = personInfo.nextLine();

                Person temp = new Person(name,surname,email);

                int price;

                if(seat<6){
                    price = 200;
                }
                else if(seat <10){
                    price = 150;
                }
                else{
                    price = 180;
                }
                Ticket tick1 = new Ticket(rowName,seat,price,temp);
                for (int i=0; i < ticket.length; i++ ) {

                    if (ticket[i] == null){
                        ticket[i] = tick1;
                    }
                }
                System.out.println("Seat  " + rowName + seat + " booked successfully.");
            }
            else {
                System.out.println("Seat  " + rowName + seat + "  is not available.");
            }
        }
        catch(Exception e){
            System.out.println("Invalid seat number");
        }

    }

    public static void cancelTicket(int[] row,String rowName,int seat){
        int seatIndex = seat - 1;
        try {
            if (row[seatIndex] == 1) {
                row[seatIndex] = 0;
                System.out.println("Seat  " + rowName + seat + "  canceled successfully.");
                for (int i=0; i < ticket.length; i++ ) {

                    if ((ticket[i].getRow().equals(rowName))&&(ticket[i].getSeat() == seat)){
                        ticket[i] = null;
                    }
                }
            }
            else {
                System.out.println("Seat  " + rowName + seat + " does not have any booking.");
            }
        }
        catch(Exception e){
            System.out.println("Invalid seat number");

        }

    }


    public static void buy_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input seat number :");
        int seatNumber = seatInput.nextInt();

        switch(seatRow.toUpperCase()){

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
                System.out.println("Invalid Seat Row");
                break;

        }

    }

    public static void cancel_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input seat number :");
        int seatNumber = seatInput.nextInt();

        switch(seatRow.toUpperCase()){

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

   public static void find_first_available(int[] rowA, int[] rowB, int[] rowC, int[] rowD){
        int[][] array = {rowA,rowB,rowC,rowD};

        String rowName;

        rowLoop:
        for (int i=0; i < array.length; i++ ) {
            for (int j=0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    if(Arrays.equals(array[i], rowA)){
                        rowName = "A";
                    }
                    else if (Arrays.equals(array[i], rowB)) {
                        rowName = "B";
                    }
                    else if (Arrays.equals(array[i], rowC)) {
                        rowName = "C";
                    }
                    else {
                        rowName = "D";
                    }
                    int seatName = j + 1;  // Seat number is the column index + 1
                    System.out.println("First available seat is : " + rowName + seatName);
                    break rowLoop;

                }
            }

        }

    }

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


    public static void main(String[] args){
        // Initializing seats
        int[] rowA = new int[14];
        int[] rowB = new int[12];
        int[] rowC = new int[12];
        int[] rowD = new int[14];

        System.out.println("Welcome to the Plane Management Application");

        Scanner menuInput = new Scanner(System.in);

        int userInput;

        mainLoop:
        while(true){
            // Displays menu
            displayMenu();
            System.out.println("\nPlease select an option :");
            userInput = menuInput.nextInt();

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

                default:
                    System.out.println("Invalid Input");

            }

/*
            if (userInput==0){  // Closing
                break;
            }

            else if(userInput==1){  // Buying seat
                buy_seat(rowA,rowB,rowC,rowD);
            }
            else if(userInput==2){  // Cancel seat
                cancel_seat(rowA,rowB,rowC,rowD);
            }

            else if(userInput==3){  // Finding first seat
                find_first_available(rowA,rowB,rowC,rowD);
            }

            else if(userInput==4){
                show_seating_plan(rowA,rowB,rowC,rowD);
            }

            else{
                System.out.println("Invalid Input");
            }

 */
        }

    }

}
