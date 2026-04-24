package Chapter_ten;
// exercise 10.14 Payroll System Modification 
// PieceWorker.java continuation of fig 1..4-10.9

public class PieceWorker extends Employee {

  // instance variable wage to store employee wage per piece and variable piece to store the number of pieces produced
  private double wage;
  private double pieces;


  public PieceWorker (String firstName, String lastName, String socialSecurityNumber, int day, int month, int year, double wage, double pieces) {

    super (firstName, lastName, socialSecurityNumber, day, month, year);

    this.wage = wage;
    this.pieces = pieces;

  }

  // concrete implementation of earnings method
  @Override
  public double earnings() {

    return pieces * wage;

  }

  // to string method  
  @Override
  public String toString() {

    return String.format("%s%n%s%.2f%n%s%,.2f", super.toString(), "Wage Per Piece: ", wage, "Number of Pieces: ", pieces);
  }
}
