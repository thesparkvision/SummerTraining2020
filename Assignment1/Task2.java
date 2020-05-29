import java.util.Scanner;

class Task2
{
 public static void main(String [] args)
 {
  Student[] students;
  Scanner sc=new Scanner(System.in);
  
  //Taking number of students as input
  System.out.pritnln("Enter how many students: ");
  int n=sc.nextInt();
  
  //Taking student details using Operation class static method input to create array of reference variables
  students=Operation.input(n);
  
  //Performing search operation using Operation class static method search_student
  System.out.println("Enter a roll no. to search for: ");
  String search_no=sc.next();
  searhStudent(students,search_no);
  }
}

