package Chapter_ten;
// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program

public class PayrollSystemTest {
  public static void main(String[] args) {
  
    // create subclass objects
    SalariedEmployee salariedEmployee = 
      new SalariedEmployee("John","Smith", "111-11-1111",800.00, 20, 10, 2000); 
    HourlyEmployee hourlyEmployee =
      new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, 10, 11, 1998);
    CommissionEmployee commissionEmployee =
      new CommissionEmployee(
        "Sue", "Jones", "333-33-3333", 10000, .06, 16, 10, 2006);
    BasePlusCommissionEmployee basePlusCommissionEmployee = 
        new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, 12, 12, 2000);

    System.out.println("Employee processed individually: ");

    System.out.printf("%n%s%n%s%n%s: $%,.2f%n%n",
      salariedEmployee,  salariedEmployee.getDateOfBirth(), "earned", salariedEmployee.earnings());
    System.out.printf("%s%n%s%n%s: $%,.2f%n%n",
      hourlyEmployee, hourlyEmployee.getDateOfBirth(), "earned", hourlyEmployee.earnings());
    System.out.printf("%s%n%s%n%s: $%,.2f%n%n",
      commissionEmployee,  commissionEmployee.getDateOfBirth(), "earned", commissionEmployee.earnings());
    System.out.printf("%s%n%s%n%s: $%,.2f%n%n",
      basePlusCommissionEmployee, basePlusCommissionEmployee.getDateOfBirth(), "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4];

      // initialize array with Employee
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee;
      employees[3] = basePlusCommissionEmployee;

      System.out.printf("Employees processed polymorphically:%n%n");

      // generically process each element in array employees
      for (Employee currentEmployee: employees) {

        System.out.println(currentEmployee); // invokes toString

        // determine whether element is a BasePlusCommissionEmployee
        if (currentEmployee instanceof BasePlusCommissionEmployee){

          // downcast Employee reference to 
          // BasePlusCommissionEmployee reference
          BasePlusCommissionEmployee employee = 
            (BasePlusCommissionEmployee) currentEmployee;

          employee.setBaseSalary(1.10 * employee.getBaseSalary());

          System.out.printf(
            "new base salary with 10%% increase is: $%,.2f%n",
            employee.getBaseSalary());
        } // end if

        System.out.printf(
          "earned $%,.2f%n%n", currentEmployee.earnings());
      } // end for

      // get type name of object in employee array
      for (int j = 0; j < employees.length; j ++) {

        System.out.printf("Employee %d is a %s%n", j,
          employees[j].getClass().getName());
      }
  }
}
