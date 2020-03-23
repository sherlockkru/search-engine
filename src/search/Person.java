package search;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName) {
        this.firstName = firstName;
        this.lastName = "";
        this.email = "";
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = "";
    }

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        if (lastName == "" && email == "") {
            return firstName;
        }
        if (email == "") {
            return firstName + " " + lastName;
        }
        return firstName + " " + lastName + " " + email;
    }
}
