import java.util.Scanner;

public class CollegeStudent extends Student
{
 private String semester;
 
 public CollegeStudent()
 {
  super();
  this.semester="";
 }

 public String getSemester()
 {
     return this.semester;
 }

 public CollegeStudent(String rollno,float percentage,String semester)
 {
 super(rollno,percentage);
 this.semester=semester;
 }

 public void payTutionFees()
 {
     System.out.print(this.getRollNo()+" Student pays 35000 Rs for this semester\n");
 }
 
 public void giveMidSemExam()
 {
    int marks[]=new int[5];
    int total_marks=0;
    Scanner sc=new Scanner(System.in);
    System.out.println(this.getRollNo()+" ,Enter marks of 5 subjects: ");
    for(int m=0;m<marks.length;m++)
    {
        marks[m]=sc.nextInt();
        total_marks+=marks[m];
    }
    System.out.println("Student obtained "+total_marks+" marks out of 100\n");
 }

}