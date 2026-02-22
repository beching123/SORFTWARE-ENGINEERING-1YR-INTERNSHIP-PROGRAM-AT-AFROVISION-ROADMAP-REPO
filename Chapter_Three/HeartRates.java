package Chapter_Three;
// Target Heart Rate Calculation Exercise 3.16


public class HeartRates {
  
  //attributes used to hold info per person
  String firstName;
  String lastName;
  int day;
  int month;
  int year;

  // Constructor that will be used to initialized the attributes
  public HeartRates (String firstName, String lastName, int day, int month, int year){

    this.firstName = firstName;
    this.lastName = lastName;
    this.day = day;
    this.month = month;
    this.year = year;

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
  public void setDay(int day){
    this.day = day;
  }
  public int getDay(){
    return day;
  }
  public void setMonth(int month){
    this.month = month;
  }
  public int getMonth(){
    return month;
  }
  public void setYear(int year){
    this.year = year;
  }
  public int getYear(){
    return year;
  }

  public int personAge(){
    int age = 2026 - this.year;
    return age;
  }
  public int MaximumHeartRate() {
    int maximumHeartRates = 220 - this.personAge();
    return maximumHeartRates;
  }
  public int targetHeartRates(){
    int targetHeartRate1 = this.MaximumHeartRate() * 50 / 100;
    int targetHeartRate2 = this.MaximumHeartRate() * 85 / 100;
    
    int targetHeartRate = ( targetHeartRate1 + targetHeartRate2) / 2;
    return targetHeartRate;
  }
}
