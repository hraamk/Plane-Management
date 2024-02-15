import java.util.Scanner;  // Import the Scanner class

public class PlaneManagement {

    static void buy_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD ) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input seat number :");
        String seatNumber = seatInput.nextLine();

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

    }



}
