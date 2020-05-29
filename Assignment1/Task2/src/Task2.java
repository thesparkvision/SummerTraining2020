import java.util.Scanner;

public class Task2
{
 public static void main(String [] args)
 {
  Student[] students;
  Scanner sc=new Scanner(System.in);
  
  //asking user how many students are there
  System.out.println("Enter how many students: ");
  int n=sc.nextInt();

  //taking student details in array using Operation class static method input
  System.out.println("\n*******Input*******\n");
  students=Student.input(n);

  //Searching student based on roll no.
  System.out.println("\n*******Search*******\n");
  System.out.println("Enter roll no. to search: ");
  String search_no=sc.next();
  Student.searchStudent(students,search_no);

  //Calling giveExam static method of Student class so that students can give exam
  System.out.println("\n*******Give Exam Time*******\n");
  Student.giveExam(students);

  //Calling payFees static method of Student class so that students can pay Tution Fees
  System.out.println("\n*******Tution Fees Payment*******\n");
  Student.payFees(students);
  }
}

