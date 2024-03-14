public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.name = newSurname;
    }
    public void setEmail(String newEmail) {
        this.name = newEmail;
    }

    public void printInformation() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }


}

