package Chapter_eight;
// Fig. 8.5: Time2.java
// Time2 class declaration with overload constructors

public class Time2 {

  /*private int hour; // 0 - 23
  private int minute; // 0 - 59
  private int second; // 0 - 59*/
  private int totalNumberOfSeconds;
  private int days;
  private int month;
  private int year; 

  // Time2 no-argument constructor
  // initializes each instance variable to zero
  public Time2 () {

    this(0, 0, 0); // invoke constructor with three arguments

  }

  // Time2 constructor: hour supplied, minute and second default3ed to 0
  public Time2 (int hour) {

    this(hour, 0, 0); // invoke constructors with three arguments
  }

  // Time2 constructor: hour and minute supplied, second defaulted to 0
  public Time2 (int hour, int minute) {

    this(hour, minute, 0); // invoke constructor with three argument

  }

  // Time2 constructor: hour, minute and second supplied
  public Time2 (int hour, int minute, int second) {

    if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

    if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0 = 59");

    if (second < 0 || second  >= 60)
      throw new IllegalArgumentException("second must be 0-59");

    totalNumberOfSeconds = (hour * 3600) + (minute * 60) + second;

  }

  // Time2 constructor: another Time2 object supplied
  public Time2(Time2 time) {

    // invoke constructor with three arguments
    this(time.getHour(), time.getMinute(), time.getSecond());

  }

  // set Methods
  // set a new time value using universal time;
  // validate the data
  public void setTime(int hour, int minute, int second) {

    if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

    if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0 = 59");

    if (second < 0 || second  >= 60)
      throw new IllegalArgumentException("second must be 0-59");

     totalNumberOfSeconds = (hour * 3600) + (minute * 60) + second;

  }

  // validate and set hour 
  public void setHour (int hour) {

    if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

    totalNumberOfSeconds += (hour * 360);

  }

  // validate and set minute
  public void setMinute (int minute) {

    if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0-59");

      totalNumberOfSeconds += (minute * 60);
  }

  // validate and set second 
  public void setSecond(int second) {

    if (second < 0 || second >= 60)
      throw new IllegalArgumentException("second must be 0-59");

     totalNumberOfSeconds += second;;

  }

  // Get Methods
  // get hour value
  public int getHour () {

    return totalNumberOfSeconds / 3600;
  }

  // get minute value
  public int getMinute () {

    return (totalNumberOfSeconds % 3600) / 60;

  }

  // get second value
  public int getSecond () {

    return totalNumberOfSeconds % 60;

  }

  // convert to String in universal-time format (HH:MM:SS)
  public String toUniversalString () {

    return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());

  }

  // convert to String in standard-time format (H:MM:SS AM or PM)
  public String toString() {

    return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12: getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM": "PM"
  ));

  }

  // tick method to increment the time stored int the time2 class
  public void tick () {

    totalNumberOfSeconds ++;
    if (totalNumberOfSeconds == 86400) {
      totalNumberOfSeconds = 0;
    }

  } 
  
  // increment by one minute 
  public void incrementMinute () {

    int h = (totalNumberOfSeconds) / 3600;
    int m = (totalNumberOfSeconds % 3600) / 60;
    int s = (totalNumberOfSeconds) % 60;

    m ++;
    if (m == 60) {
      incrementHour();
      m = 0;

    }
    else {
    totalNumberOfSeconds = (h * 3600) + (m * 60) + s;
    }
  
  }

  // increment hour by 1 
  public void incrementHour () {

    int h = (totalNumberOfSeconds) / 3600;
    int m = (totalNumberOfSeconds % 3600) / 60;
    int s = (totalNumberOfSeconds) % 60;

    h = (h + 1) % 24; 

    totalNumberOfSeconds = (h * 3600) + (m * 60) + s; 
  }
} // end class Time2