package Chapter_ten;
// Fig. 10.14: SalariedEmployee.java
// SalariedEmployee class that implements interface Payable.
// method getPaymentAmount.

public class SalariedEmployee2 extends Employee2 {
 
  private double weeklySalary;

  // constructor
  public SalariedEmployee2 (String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {

    super(firstName, lastName, socialSecurityNumber);

    if (weeklySalary < 0.0)
        throw new IllegalArgumentException("Weekly salary must be >= 0.0");

    this.weeklySalary = weeklySalary;

  }

  // set salary
  public void setWeeklySalary(double weeklySalary) {

    if (weeklySalary < 0.0)
      throw new IllegalArgumentException("Week salary must be >= 0.0");

    this.weeklySalary = weeklySalary;

  }

  // return salary
  public double getWeeklySalary() {

    return weeklySalary;
  }

  // calculate earnings; implement interface payable method was 
  // abstract in superclass Employee
  @Override
  public double getPaymentAmount() {

    return getWeeklySalary();
  }

  // return String representation of SalaryEmployee2 object
  @Override 
  public String toString() {

    return String.format("salary employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
  }
} // end class SalariedEmployee
