package ContinuationOfChapter7;
// Fig. 7.15 GradeBookTest.java
// GradeBookTEst creates a GradeBook object using an array of grades.
// then invokes method processGrades to analyze them.
import java.util.Scanner;

public class GradeBookTest {
  
  public static void main(String[] args) {

    Scanner input = new Scanner (System.in);

    // asking for the number of student
    System.out.print("Enter the number of Students: ");
    int students = input.nextInt();

    System.out.print("Enter the number of exams: ");
    int exams  = input.nextInt();

    GradeBook myGradeBook = new GradeBook("CS101 Introduction to Java programming", students, exams);

    for (int student = 0; student < students; student ++) {

      for (int exam = 0; exam < exams; exam ++) {
        System.out.printf("Enter grade for Student %d, EXam %d: ", student + 1, exam + 1);

      }
    }

    System.out.printf("%nWelcome to the grade book for%n%s%n%n", myGradeBook.getCourseName());

    myGradeBook.processGrades();
  }
} // end class gradeBookTest
