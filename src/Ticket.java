import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
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

    // Getters and setters
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

    // Method to print information
    public void printInfo() {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: $" + price);
        System.out.println("Person Information:");
        person.printInformation();
    }

    public void save() {
        String filename = getRow()+getSeat()+".txt";
        String content = "Ticket Information: \nRow: " + row + "\nSeat: "+ seat + "\nPrice: $" + price +
                "\nPerson Information:" + "\nName: " + person.getName()+ "\nSurname: " + person.getSurname() + "\nEmail: " + person.getEmail();
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(content);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
