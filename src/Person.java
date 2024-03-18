/**
 * This class represents a Person with attributes such as name, surname, and email.
 */
public class Person {
    // Private instance variables to store the person's name, surname, and email
    private String name;
    private String surname;
    private String email;

    /**
     * Constructor to initialize a Person object with the given name, surname, and email.
     * @param name The name of the person
     * @param surname The surname of the person
     * @param email The email address of the person
     */
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Getter method to retrieve the name of the person.
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the surname of the person.
     * @return The surname of the person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getter method to retrieve the email of the person.
     * @return The email of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method to update the name of the person.
     * @param newName The new name to be set for the person
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Setter method to update the surname of the person.
     * @param newSurname The new surname to be set for the person
     */
    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    /**
     * Setter method to update the email of the person.
     * @param newEmail The new email address to be set for the person
     */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    /**
     * Method to print the information of the person.
     */
    public void printInformation() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
