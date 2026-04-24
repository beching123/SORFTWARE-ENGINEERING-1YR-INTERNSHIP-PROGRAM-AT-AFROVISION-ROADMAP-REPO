package Chapter_eight;
// Exercise 8.12 DateAndTime.java
// Modified version of exercise 8.7 and 8.8 that combines both class to one.

public class DateAndTime {
  
  // instance variable to hold reference to Date and Time2 class (as such objects).
  private Date date;
  private Time2 time;

  public DateAndTime() {

    date = new Date (4, 5, 2026)
    time = new Time2(23, 59, 00);

  }

  public void incrementDay() {


    time.incrementMinute();
    int hour = time.getHour();

    if (hour == 24) {
      date.nextDay();
    }
  }


  public static void main(String[] args) {


  }
}
