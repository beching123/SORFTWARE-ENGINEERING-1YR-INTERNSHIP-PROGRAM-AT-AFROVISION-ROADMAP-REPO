package Chapter_ten;
// exercise 10.12 modifications of payroll system

public class NewPayrollSystemTest {
  
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
        PieceWorker pieceWorker = new PieceWorker("Rexzy", "Bate", "555-55-5555", 10, 2, 2000, 100.0, 30);


    // create four-element Employee array
    Employee[] employees = new Employee[5];

    // initialize array with Employee
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;
    employees[4] = pieceWorker;

    for (int month = 0; month <= 12; month ++) {

      System.out.println();System.out.println();System.out.println();

      
      // generically process each element in array employees
      for (Employee currentEmployee: employees) {

        System.out.println(currentEmployee); // invokes toString

        System.out.printf(
          "earned $%,.2f%s%n%n", (month == currentEmployee.getBirthMonth()) ? currentEmployee.earnings() + 100.00 : currentEmployee.earnings(), (month == currentEmployee.getBirthMonth()) ? " (Happy Birth Day. Added bonus: $100.00)": "");
      } // end for
    }
  }
}
