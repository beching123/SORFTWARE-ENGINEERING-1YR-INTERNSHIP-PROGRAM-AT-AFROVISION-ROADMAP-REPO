package Chapter_eight;
// Fig. 8.7: Date.java
// Date class declaration.

public class Date {

  private int month; // 1-12
  private int day; // 1-31 based on month
  private int year; // any year
  private String[] monthsNames = {"January", "February", "Match", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

  private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 

  // constructor: confirm proper value for month and day given the year
  public Date (int month, int day, int year) {


    // check if month in range
    if (month <= 0 || month > 12)
      throw new IllegalArgumentException ("month (" + month + ") must be 1-12");

    // check if day in range for month
    if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
      throw new IllegalArgumentException ("day (" + day + ") out-of-range for the specified month and year");

    //check for leap year if month is 2 and day is 29
    if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
      throw new IllegalArgumentException("day (" + day + ")out-of-range for specified month and year");

    if (year < 1900 || year > 2026)
      throw new IllegalArgumentException("year (" + year + ") out-of-range for specified year");
    
    this.month = month;
    this.day = day;
    this.year = year;

    //System.out.printf("Date objecjt constructor for date %s%n", this);
  }

  // method used to increment the year
  public void nextDay () {

    day ++;

    verifyDay ();

  }

  // method used to verify the date after incremental
  public void verifyDay() {

    if (day > daysPerMonth[month]) {

      //check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {

      } else {

        day -= daysPerMonth[month];
        month ++;

        if (month > 12) {
          month -= 12;
          year ++;
        }
      }
    }
  }
  // return a String of the form month/day/year
  public String monthFirstFormat() {

    return String.format("%d/%d/%d", month, day, year);
  }

  public String stringMonth() {

    return String.format("%s %d, %d", monthsNames[month - 1], day, year);
  }

  public String dayAndYear () {

    return String.format("%d %d", day, year);
    
  }

  public static void main(String[] args) {

    Date myDate = new Date (12, 30, 2026);

    for (int i = 0; i < 369; i ++) {

      System.out.printf("%s\n", myDate.toString());
      myDate.nextDay();

    }
  }
} // end class Date