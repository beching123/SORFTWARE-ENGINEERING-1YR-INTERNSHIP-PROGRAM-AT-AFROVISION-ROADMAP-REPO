// Exercise 3.17 Computer of Health Records

public class HealthProfile {
  
  // Attributes used to hold a person Record
  String firstName;
  String lastName;
  String gender;
  int day;
  int month;
  int year;
  double height;
  double weight;


  // Constructor used to initialized the Attributes above
  public HealthProfile(String firstName, String lastName, String gender, int day, int month, int year, double height, double weight){

    //initializing the attributes assuming the user enters valid info (no error checkers)

    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.day = day;
    this.month = month;
    this.year = year;
    this.height = height;
    this.weight = weight;

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
  public void setGender (String gender){
    this.gender = gender;
  }
  public String getGender(){
    return gender;
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
  public void setHeight(double height){
    this.height = height;
  }
  public double getHeight(){
    return height;
  }
  public void setWeight(double weight){
    this.weight = weight;
  }
  public double getWeight(){
    return weight;
  }

  public int personAge(){
    int age = 2026 - this.year;
    return age;
  }
  public double ConversionOfHeight(){
    double newHeight = height * 39.3701;
    return newHeight;
  }
  public double ConversionOfWeight(){
    double newWeight = weight * 2.20462;
    return newWeight;
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
  public double bodyMassIndex(){
    double BMI = weight / (height * height);
    return BMI;
  }
}
