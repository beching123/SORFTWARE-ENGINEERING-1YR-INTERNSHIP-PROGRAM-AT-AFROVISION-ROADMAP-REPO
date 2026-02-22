// Exercise 3.13 Employee.java


public class Employee {
  
  // Instance variables
  private String firstName;
  private String lastName;
  private double monthlySalary;

  // Constructor used to initialized instances above
  public Employee(String firstName, String lastName, double monthlySalary){

    // initializing instances
    this.firstName = firstName;
    this.lastName = lastName;

    // checking for valid salary
    if (monthlySalary > 0.0)
      this.monthlySalary = monthlySalary;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
public String getFirstName(){
    return firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  public String getLastName(){
    return lastName;
  }
  public void setMonthlySalary(double monthlySalary){
    this.monthlySalary = monthlySalary;
  }
  public double getMonthlySalary(){
    return monthlySalary;
  }

}
