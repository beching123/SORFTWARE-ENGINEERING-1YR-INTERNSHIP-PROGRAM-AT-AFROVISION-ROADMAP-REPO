package Chapter_ten;
// Fig. 10.13: Employee2.java
// Employee abstract superclass.

public abstract class Employee2 implements Payable{
  
  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;

  // constructor 
  public Employee2(String firstName, String lastName, String socialSecurityNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;

  }

  // return first name
  public String getFirstName() {

    return firstName;

  }

  // return last name
  public String getLastName() {

    return lastName;

  }


  // return social security number
  public String getSocialSecurityNumber() {

    return socialSecurityNumber;

  }

  // return String representation of Employee object
  @Override
  public String toString() {

    return String.format("%s %s%n social security number: %s", getFirstName(), getLastName(),getSocialSecurityNumber());
  }

  // Note: I do not implement Payable method getPaymentAmount here so
  // this class must be declared abstract to abstract to avoid a compilation error,
} // end abstract class Employee

