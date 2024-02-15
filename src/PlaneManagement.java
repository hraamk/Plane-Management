import java.util.Scanner;  // Import the Scanner class

public class PlaneManagement {

    static void buy_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD ) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input row number :");
        int seatNumber = seatInput.nextInt();

        int seatIndex = seatNumber - 1;

        switch(seatRow.toUpperCase()){

            case "A":
                try {
                    if (rowA[seatIndex] == 0) {
                        rowA[seatIndex] = 1;
                        System.out.println("Seat A" + seatNumber + "  booked successfully.");
                    }
                    else {
                        System.out.println("Seat A" + seatNumber + "  is not available.");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid seat number");

                    }
                break;

            case "B":
                try {
                    if (rowB[seatIndex] == 0) {
                        rowB[seatIndex] = 1;
                        System.out.println("Seat B" + seatNumber + "  booked successfully.");
                    }
                    else {
                        System.out.println("Seat B" + seatNumber + "  is not available.");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid seat number");

                }
                break;
            case "C":
                try {
                    if (rowC[seatIndex] == 0) {
                        rowC[seatIndex] = 1;
                        System.out.println("Seat C" + seatNumber + "  booked successfully.");
                    }
                    else {
                        System.out.println("Seat C" + seatNumber + "  is not available.");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid seat number");

                }
                break;

            case "D":
                try {
                    if (rowD[seatIndex] == 0) {
                        rowD[seatIndex] = 1;
                        System.out.println("Seat D" + seatNumber + "  booked successfully.");
                    }
                    else {
                        System.out.println("Seat D" + seatNumber + "  is not available.");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid seat number");

                }
                break;

            default:
                System.out.println("Invalid Seat Row");
                break;

        }


    }

    static void displayMenu() {

        System.out.println("Welcome to the Plane Management Application");

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


    public static void main(String[] args){
        // Initializing seats
        int[] rowA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rowD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Scanner menuInput = new Scanner(System.in);

        displayMenu();


        System.out.println("\nPlease select an option :");
        int userInput = menuInput.nextInt();

        if(userInput==1){
            buy_seat(rowA,rowB,rowC,rowD);
        }
        else{
            System.out.println("Invalid Input");
        }


        //for (int i = 0; i < rowA.length; i++) {
        //   System.out.print(rowA[i] + " ");
        //}

    }





}
