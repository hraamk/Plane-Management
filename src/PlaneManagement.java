import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays;


public class PlaneManagement {

    private static final Ticket[] ticket = new Ticket[52];
    private static int totalSales = 0;

    public static void book_ticket(int[] row,String rowName, int seat){
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

                Person newPerson = new Person(name,surname,email);

                personInfo.close();

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
                Ticket newTicket = new Ticket(rowName,seat,price,newPerson);
                for (int i=0; i < ticket.length; i++ ) {
                    if (ticket[i] == null){
                        ticket[i] = newTicket;
                        break;
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

    public static void cancel_ticket(int[] row,String rowName,int seat){
        int seatIndex = seat - 1;
        try {
            if (row[seatIndex] == 1) {
                row[seatIndex] = 0;
                System.out.println("Seat  " + rowName + seat + "  canceled successfully.");
                for (int i=0; i < ticket.length; i++ ) {
                    if (ticket[i] != null){
                        if ((ticket[i].getRow().equals(rowName))&&(ticket[i].getSeat() == seat)){
                            ticket[i] = null;
                            break;
                        }
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
                book_ticket(rowA,seatRow,seatNumber);
                break;
            case "B":
                book_ticket(rowB,seatRow,seatNumber);
                break;
            case "C":
                book_ticket(rowC,seatRow,seatNumber);
                break;
            case "D":
                book_ticket(rowD,seatRow,seatNumber);
                break;
            default:
                System.out.println("Invalid Seat Row");
                break;




        }

        seatInput.close();

    }

    public static void cancel_seat(int[] rowA, int[] rowB, int[] rowC, int[] rowD) {
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input seat number :");
        int seatNumber = seatInput.nextInt();

        switch(seatRow.toUpperCase()){

            case "A":
                cancel_ticket(rowA,seatRow,seatNumber);
                break;
            case "B":
                cancel_ticket(rowB,seatRow,seatNumber);
                break;
            case "C":
                cancel_ticket(rowC,seatRow,seatNumber);
                break;
            case "D":
                cancel_ticket(rowD,seatRow,seatNumber);
                break;
            default:
                System.out.println("Invalid Seat Row");
                break;

        }

        seatInput.close();

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

    public static void search_ticket(){
        Scanner seatInput = new Scanner(System.in);
        System.out.println("Please input row letter :");
        String seatRow = seatInput.nextLine();

        System.out.println("Please input seat number :");
        int seatNumber = seatInput.nextInt();

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

        seatInput.close();

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

                case 5:
                    print_tickets_info();
                    break;

                case 6:
                    search_ticket();
                    break;

                default:
                    System.out.println("Invalid Input");

            }
            menuInput.close();

        }

    }

}
