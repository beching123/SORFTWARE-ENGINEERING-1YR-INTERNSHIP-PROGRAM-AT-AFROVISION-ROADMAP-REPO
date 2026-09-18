package Chapter_nine;
// Fig. 9.8: BasePlusCommissionEmployee.java. Fig. 9.11: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployees class inherits from CommissionEmployee
// and accesses the superclass's private data via inherited
// private superclass members cannot be accessed in a subclass.

public class BasePlusCommissionEmployees extends CommissionEmployee {
  
  private double baseSalary; // base salary per week

  // six-argument constructor
  public BasePlusCommissionEmployees (String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {

    // explicit class to superclass CommissionEmployee constructor
    super (firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

    // if baseSalary is invalid throw exception
    if (baseSalary < 0.0)
      throw new IllegalArgumentException("Base salary must be >= 0.0");

    this.baseSalary = baseSalary;
  }

  // set base salary
  public void setBaseSalary (double baseSalary) {

    if (baseSalary < 0.0)
      throw new IllegalArgumentException ("Base salary must be >= 0.0");

    this.baseSalary = baseSalary;
  }

  // return base Salary
  public double getBaseSalary () {
    return baseSalary;

  }

  // calculate earnings
  @Override 
  public double earnings () {

    // not allowed commissionRate and grossSales private in superclass 
    return getBaseSalary() + super.earnings();
  }

  // return String representation of BasePlusCommissionEmployee
  @Override 
  public String toString () {

    // not allowed: attempts to access private superClass members
    return String.format ( "%s %s%n%s: %.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
  }
} // end class BasePlusCommissionEmployees
