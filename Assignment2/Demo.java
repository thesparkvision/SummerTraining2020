import java.util.Scanner;

class Demo
{
 public static void main(String args[])
 {
   int option;
   Scanner sc=new Scanner(System.in); 
   ExamInfo examinfo=new ExamInfo();

   do
   {
    System.out.println("\nEnter an option:");
    System.out.println("1. Add Student");
    System.out.println("2. Search Student By Roll Number");
    System.out.println("3. Search Student By Name");
    System.out.println("4. Delete Student by Roll");
    System.out.println("5. Add Exam");
    System.out.println("6. Show Physics 5 Topper");
    System.out.println("7. Show Computer 5 Topper");
    System.out.println("8. Show Top 5 Student (Roll,Name)");
    System.out.println("9. Exit.");
   
    option=sc.nextInt();
    switch(option)
    {
      case 1: examinfo.addStudent(); 
	      break;
      case 2: examinfo.searchStudentByRollNo();
	      break;
      case 3: examinfo.searchStudentByName();
	      break;
      case 4: examinfo.deleteStudent();
	      break;
      case 5: examinfo.addExam();
	      break;
      case 6: examinfo.showPhysicsToppers();
	      break;
      case 7: examinfo.showComputerToppers();
  	      break;
      case 8: examinfo.showTop5Students();
	      break;
      case 9: System.out.println("\nProgram exiting");
              break;
      default: System.out.println("Invalid option. Please enter a number from 1 to 9");
	       break;  
     }//End of switch case
   }while(option!=9);  
 }
}