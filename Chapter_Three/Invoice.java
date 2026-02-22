//Exercise 3.12 Invoice.java


public class Invoice {

  // Instance variables
  private String partNumber;
  private String partDescription;
  private int quantityPurchased;
  private double prizePerItem;
  
  // constructor that initializes the instance variables
  public Invoice (String partNumber, String partDescription, int quantityPurchased, double prizePerItem ) {

    // initializing instances
    this.partNumber = partNumber; 
    this.partDescription = partDescription;
    
    // making sure that the quantity is valid
    if (quantityPurchased > 0)
      this.quantityPurchased = quantityPurchased;

    // making sure that the prize is valid
    if (prizePerItem > 0.0)
      this.prizePerItem = prizePerItem;
  }


  // methods for setting and getting the values of the instance variables
  public void setPrizePerItem(double prize) {
    this.prizePerItem = prize;
  }
  public double getPrizePerItem(){
    return prizePerItem;
  }
  public void setPartNumber(String partNumber){
    this.partNumber = partNumber;
  }
  public String getPartNumber(){
    return partNumber;
  }
  public void setPartDescription(String partDescription){
    this.partDescription = partDescription;
  }
  public String getPartDescription(){
    return partDescription;
  }
  public void setQuantityPurchased(int quantityPurchased){
    this.quantityPurchased = quantityPurchased;
  }
  public int getQuantityPurchased(){
    return quantityPurchased;
  }

  //method to calculate invoice amount
  public double getInvoicedAmount(){
    return quantityPurchased * prizePerItem; 
  }
  
  

}
