import java.io.FileWriter;
import java.io.IOException;

/**
 * The Ticket class represents a ticket for an event, containing information about the seat, price, and the person associated with the ticket.
 */
public class Ticket {
    // Instance variables to store the row, seat, price, and person associated with the ticket
    private String row;
    private int seat;
    private int price;
    private Person person;

    // Constructor
    public Ticket(String row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and setters for row, seat, price, and person
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Method to print information about the ticket and associated person
    public void printInfo() {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: $" + price);
        System.out.println("Person Information:");
        person.printInformation();
    }

    // Method to save ticket information to a file
    public void save() {
        String filename = getRow() + getSeat() + ".txt"; // Creating a filename based on row and seat number
        String content = "Ticket Information: \nRow: " + row + "\nSeat: " + seat + "\nPrice: $" + price +
                "\nPerson Information:" + "\nName: " + person.getName() + "\nSurname: " + person.getSurname() + "\nEmail: " + person.getEmail();
        try {
            FileWriter myWriter = new FileWriter(filename); // Creating a FileWriter object
            myWriter.write(content); // Writing content to the file
            myWriter.close(); // Closing the file
        } catch (IOException e) { // Handling IOException
            System.out.println("An error occurred."); // Printing error message
        }
    }
}
