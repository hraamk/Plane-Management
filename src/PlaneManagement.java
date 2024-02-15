import java.util.Scanner;  // Import the Scanner class

public class PlaneManagement {

    public static void bookTicket(int[] row,String rowName,int seat){
        int seatIndex = seat - 1;
        try {
            if (row[seatIndex] == 0) {
                row[seatIndex] = 1;
                System.out.println("Seat  " + rowName + seat + "  booked successfully.");
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
            }
            else {
                System.out.println("Seat  " + rowName + seat + "  does does not have any booking.");
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

        System.out.println("Please input row number :");
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
            default:
                System.out.println("Invalid Seat Row");
                break;

        }

    }

    public static void cancel_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input row number :");
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
    public static void find_seat(int[] row){
        for (int i : row) {
            if (row[i] == 0){
                System.out.println("First available seat is : "+ "A" + i+1);
                break;
            }
        }

    }


   /* public static void find_first_available(int[] rowA, int[] rowB, int[] rowC, int[] rowD){


    }*/


    public static void main(String[] args){
        // Initializing seats
        int[] rowA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Welcome to the Plane Management Application");

        Scanner menuInput = new Scanner(System.in);

        int userInput;

        while(true){
            displayMenu();
            System.out.println("\nPlease select an option :");
            userInput = menuInput.nextInt();

            if (userInput==0){
                break;
            }

            else if(userInput==1){
                buy_seat(rowA,rowB,rowC,rowD);
            }
            else if(userInput==2){
                cancel_seat(rowA,rowB,rowC,rowD);
            }

            else if(userInput==3){
                //find_first_available(rowA,rowB,rowC,rowD);
            }

            else{
                System.out.println("Invalid Input");
            }
        }

/*
        for (int i = 0; i < rowA.length; i++) {
           System.out.print(rowA[i] + " ");

        }
        System.out.println();

        for (int i = 0; i < rowB.length; i++) {
            System.out.print(rowB[i] + " ");


        }
        System.out.println();
        for (int i = 0; i < rowC.length; i++) {
            System.out.print(rowC[i] + " ");


        }
        System.out.println();
        for (int i = 0; i < rowD.length; i++) {
            System.out.print(rowD[i] + " ");


        }
        System.out.println();
*/
    }


}
