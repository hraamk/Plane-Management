import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Ticket class represents a ticket for an event, containing information about the seat, price, and the person associated with the ticket.
 */
public class Ticket {
    // Instance variables to store the row, seat, price, and person associated with the ticket
    private char row;
    private int seat;
    private int price;
    private Person person;

    /**
     * Constructs a Ticket object with the specified row, seat, price, and associated person.
     * @param row    the row of the ticket
     * @param seat   the seat number of the ticket
     * @param price  the price of the ticket
     * @param person the person associated with the ticket
     */
    public Ticket(char row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and setters for row, seat, price, and person

    /**
     * Returns the row of the ticket.
     * @return the row of the ticket
     */
    public char getRow() {
        return row;
    }

    /**
     * Sets the row of the ticket.
     * @param row the row of the ticket
     */
    public void setRow(char row) {
        this.row = row;
    }

    /**
     * Returns the seat number of the ticket.
     * @return the seat number of the ticket
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Sets the seat number of the ticket.
     * @param seat the seat number of the ticket
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     * Returns the price of the ticket.
     * @return the price of the ticket
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the ticket.
     * @param price the price of the ticket
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns the person associated with the ticket.
     * @return the person associated with the ticket
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the person associated with the ticket.
     * @param person the person associated with the ticket
     */
    public void setPerson(Person person) {
        this.person = person;
    }


    /**
     * Prints information about the ticket and associated person.
     */
    public void printInfo() {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: $" + price);
        System.out.println("Person Information:");
        person.printInformation();
    }

    /**
     * Saves ticket information to a file.
     */
    public void save() {
        String rowString = String.valueOf(getRow());
        String filename = rowString + getSeat() + ".txt"; // Creating a filename based on row and seat number
        //System.out.println(filename);
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


    /**
     * Deletes the file associated with the ticket.
     */
    public void deleteFile() {
        String rowString = String.valueOf(getRow());
        String filename = rowString + getSeat() + ".txt"; // Creating a filename based on row and seat number
        try {
            File ticketFile = new File(filename);
            ticketFile.delete(); // Deletes file

        } catch (Exception e) { // Handling IOException
            System.out.println("An error occurred."); // Printing error message
        }

    }
}
