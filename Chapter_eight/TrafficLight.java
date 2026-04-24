package Chapter_eight;
import java.util.EnumSet;

public enum TrafficLight {

  RED (40),
  GREEN (50),
  YELLOW (60);

  private int duration;

  TrafficLight (int duration) {

    this.duration = duration;

  }

  public int getDuration() {

    return duration;
  }

  public static void main(String[] args) {

    System.out.println("All Lights and thier corresponding seconds");

    for (TrafficLight light: TrafficLight.values()) {

      System.out.printf("%5s%3d\n", light, light.getDuration());
    }
  }

}