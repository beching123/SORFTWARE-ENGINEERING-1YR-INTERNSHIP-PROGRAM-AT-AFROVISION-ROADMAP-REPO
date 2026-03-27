// exercise 7.21 turtle game

public class TurtleGraphics {
 
  // constants
  private final int ROWS = 20;
  private final int COLUMNS = 20;

  private int[][] floor = new int[ROWS][COLUMNS];
  private int currentRow;
  private int currentColumn;
  private enum DIRECTION {RIGHT, DOWN, LEFT, UP};
  private boolean penDown;
  private DIRECTION direction;


  public TurtleGraphics () {

    // initializing floor array
    for (int i = 0; i < ROWS; i ++ ) {
      for (int j = 0; j < COLUMNS; j ++) {
        floor[i][j] = 0;
      }
    }

    currentRow = 10;
    currentColumn = 10;
    penDown = false;
    direction = DIRECTION.RIGHT;

  }

  public void penUP() {
    penDown = false;
  }
  public void penDown() {
    penDown = true;
  }

  public void turnRight () {
    int newIndex = (direction.ordinal() + 1 + 4) % 4;
    direction = DIRECTION.values()[newIndex]; 
  }

  public void turnLeft() {
    int newIndex = (direction.ordinal() - 1) % 4;
    direction = DIRECTION.values()[newIndex];
  }

  public void processCommands(int[] commands) {

    for (int i = 0; i < commands.length; i ++) {
      
      int command = commands[i];

      switch(command) {

        case 1: 
          penUP();
          break;

        case 2: 
          penDown();
          break;

        case 3:
          turnRight();
          break;
        
        case 4: 
          turnLeft();
          break;
        
        case 5: 
          int steps = commands[ ++i];
          moveForward(steps);
          break;

          case 6:
            display();
            break;

          case 9: 
            return;
      }
    }
  }

  public void moveForward(int steps) {

    for (int i = 1; i <= steps; i ++) {

      switch(direction) {
        
        case RIGHT:
          currentColumn ++;
          break;
        
        case LEFT:
          currentColumn --;
          break;

        case DOWN:
          currentRow ++;
          break;

        case UP:
          currentRow --;
          break;
      }

      if (currentRow < 0 || currentRow >= 20 || currentColumn < 0 || currentColumn >= 20){
        break;
      }

      if (penDown) {
        floor[currentRow][currentColumn] = 1;
      }
    }
  }

  public void display() {

    for (int i = 0; i < ROWS; i ++)  {

      for (int j = 0; j < COLUMNS; j ++) {

        System.out.printf("%s", floor[i][j] == 1? "*": " ");
      }
      System.out.println();
    }
    }
  }