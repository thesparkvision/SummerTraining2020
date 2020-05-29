import java.util.Scanner;

class Task2
{
 public static void main(String [] args)
 {
  Student[] students;
  Scanner sc=new Scanner(System.in);
  
  //asking user how many students are there
  System.out.println("Enter how many students: ");
  int n=sc.nextInt();
 
  //taking student details in array using Operation class static method input
  students=Operation.input(n);

  //Searching student based on roll no.
  System.out.println("Enter roll no. to search: ");
  String search_no=sc.next();
  Operation.searchStudent(students,search_no);
  sc.close();
  }
}

