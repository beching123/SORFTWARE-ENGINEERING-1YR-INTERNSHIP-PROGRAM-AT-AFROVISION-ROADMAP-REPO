package Chapter_ten;
// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee {
  
  private final String firstName;
  private final String lastName;
  private final String socialSecurityNumber;
  private final Date birthDate;

  // constructor 
  public Employee(String firstName, String lastName, String socialSecurityNumber, int day, int month, int year) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    birthDate = new Date(month, day, year);

  }

  // return first name
  public String getFirstName() {

    return firstName;

  }

  // return last name
  public String getLastName() {

    return lastName;

  }

  // return dateOfBirth
  public Date getDateOfBirth () {

    return birthDate;

  }

  // return month 
  public int getBirthMonth() {

    return birthDate.getMonth();
  }

  // return social security number
  public String getSocialSecurityNumber() {

    return socialSecurityNumber;

  }

  // return String representation of Employee object
  @Override
  public String toString() {

    return String.format("%s %s%n%s: %s%n social security number: %s", getFirstName(), getLastName(), "Date of Birth", getDateOfBirth(),getSocialSecurityNumber());
  }

  // abstract method must be overridden by concrete subclasses
  public abstract double earnings(); // no implementation here 
} // end abstract class Employee
