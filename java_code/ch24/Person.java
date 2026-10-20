// Fig. 24.30: Person.java
// Person class that represents an entry in an address book.
package java_code.ch24;

public class Person {

    private int addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // constructor
    public Person() {

    }

    // constructor
    public Person(int addressID, String firstName, String lastName, String email, String phoneNumber) {

        setAddressID(addressID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    // sets the addressID
    public void setAddressID(int addressID) {

        this.addressID = addressID;
    }

    // set the firstName
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    // set the lastName
    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    // set the email address
    public void setEmail(String email) {

        this.email = email;
    }

    // set the phone number
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    // return the address id
    public int getAddressID() {

        return addressID;
    }

    // returns the firstName
    public String getFirstName() {

        return firstName;
    }

    // return the lastName
    public String getLastName() {

        return lastName;
    }

    // return the email address
    public String getEmail() {

        return email;
    }

    // return the phone number
    public String getPhoneNumber() {

        return phoneNumber;
    }
} // end class Person