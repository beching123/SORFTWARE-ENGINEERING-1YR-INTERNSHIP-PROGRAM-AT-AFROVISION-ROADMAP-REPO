// test for exercise 7.21

public class TurtleGraphicsTest {

  public static void main (String[] args) {

    int[] commands = {2,5,12,3,5,12,3,5,12,3,5,12,1,6,9}; 
    TurtleGraphics turtle = new TurtleGraphics();
    turtle.processCommands(commands);

  }
}