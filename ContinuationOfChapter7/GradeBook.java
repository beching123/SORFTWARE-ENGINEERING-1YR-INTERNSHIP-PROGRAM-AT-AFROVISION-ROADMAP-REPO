 // Fig. 7.18: GradeBook.java
 // GradeBook class using a two-dimensional array to store grades. 
package ContinuationOfChapter7;

public class GradeBook {
  
   private String courseName; // name of course this grade book represents
   private int[][] grades; // array of student grades

   // constructor
   public GradeBook(String courseName, int numberOfStudent, int numberOfExams) {
      this.courseName = courseName; 
      this.grades = new int[numberOfStudent][numberOfExams];

      for (int students = 0; students < numberOfStudent; students ++) {

         for (int exam = 0; exam < numberOfExams; exam ++) {

            grades[students][exam]  = -1;

         }
      }
       
   } 

   // method to set the course name
   public void setCourseName(String courseName)
   {
      this.courseName = courseName; 
   } 

   // method to retrieve the course name
   public String getCourseName()
   {
      return courseName;
   } 

   // perform various operations on the data
   public void processGrades()
   {
      // output grades array
      outputGrades();

      // call method getAverage to calculate the average grade
      System.out.printf("%nClass average is %.2f%n", getOverallClassAverage());

      // call methods getMinimum and getMaximum 
      System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n", getMinimum(), getMaximum());

     // output grade distribution chart of all grades on all tests
      outputBarChart();
   } 
          
  // find minimum grade
   public int getMinimum()
   { 
     int lowGrade = grades[0][0];

     // loop through rows of students
     for (int[] studentGrades: grades) {
       for (int grade: studentGrades) {
         if (grade != -1 && grade < lowGrade) {
            lowGrade = grade;
         }
        }
      }

      return lowGrade;
   } 

   // find maximum grade
   public int getMaximum()
   { 
     int highGrade = grades[0][0];

     // loop through rows of students
     for (int[] studentGrades: grades) {
       for (int grade: studentGrades) {
         if (grade > highGrade) {
            highGrade = grade;
         }
        }
      }
      
      return highGrade;
   } 

   // determine average grade for test
   public double getAverage(int[] grades)
   {      
      int total = 0;
 
      // sum grades for one student
      for (int grade: grades)
         total += grade;
   
      // return average of grades
      return (double) total / grades.length;
   } 

   // output bar chart displaying grade distribution
   public void outputBarChart()
   {
      System.out.println("Overall grade distribution: ");

      // stores frequency of grades in each range of grades
      int[] frequency = new int[11];

      // loop through the 2d array  to populate the frequency array
      for (int[] studentGrades: grades) {
         for (int grade: studentGrades) {
            // ignore -1
            if (grade != -1){
               ++ frequency[grade / 10];
            }
         }
      }
      // for each grade frequency, print bar in chart
      for (int count = 0; count < frequency.length; count ++) {
         if (count == 10) {
            System.out.printf("%5d: ", 100);
         } else {
            System.out.printf("%02d-%02d: ", count * 10, count *10 + 9);
         }

         for (int stars = 0; stars < frequency[count]; stars ++) {
            System.out.print("*");
         }
         System.out.println(); // start a new line of output
      }
   }

   public void setGrades (int student, int exam, int grade) {

      if (student >= 0 && student < grades.length && exam >= 0 && exam < grades[student].length ) {
         grades[student][exam] = grade;
      } else {
         System.out.println("Error: Invalid student or exam index. ");
      }
   } 

   // output the contents of the grades array
   public void outputGrades () {

      System.out.printf("The grades are: %n%n");
      System.out.print("             ");

      for (int test = 0; test < grades[0].length; test ++) {
         System.out.printf("Test %d  ", test + 1);
      }

      System.out.println("Average");

      for (int student = 0; student < grades.length; student ++) {
         System.out.printf("Student %2d", student + 1);

         for (int exam: grades[student]) {
            if (exam == -1) {
               System.out.print("    ---   ");
            } else {
               System.out.printf("%8d ", exam);
            }
         }

         double average = getAverage(grades[student]);
         System.out.printf("%9.2f%n", average);
      }
   }

   public double getOverallClassAverage () {
      int total = 0;
      int count = 0;

      for (int[] studentGrades: grades) {
         for (int grade: studentGrades) {
            if (grade != -1) {
               total += grade;
               count ++;
            }
         }
      }

      return (count == 0) ? 0.0 : (double) total / count;
   }

} // end class GradeBook