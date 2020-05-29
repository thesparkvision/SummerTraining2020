import java.util.Scanner;

public class SchoolStudent extends Student
{
 private String classname;
 
 public SchoolStudent()
 {
  super();
  this.classname="";
 }
 
 public String getClassname() 
 {
    return this.classname; 
 } 

 public SchoolStudent(String rollno,float percentage,String classname)
 {
 super(rollno,percentage);
 this.classname=classname;
 }

 public void payTutionFees()
 {
   if(this.classname.equals("1St") || this.classname.equals("2Nd") || this.classname.equals("3Rd") || this.classname.equals("4Th") || this.classname.equals("5Th"))
         System.out.println(this.getRollNo()+" Student pays Rs. 40000\n");
   else if(this.classname.equals("6Th") || this.classname.equals("7Th") || this.classname.equals("8Th"))
         System.out.println(this.getRollNo()+" Student pays Rs. 50000\n");
   else if(this.classname.equals("9Th") || this.classname.equals("10Th"))
         System.out.println(this.getRollNo()+" Student pays Rs. 60000\n");
   else if(this.classname.equals("11Th") || this.classname.equals("12Th"))
         System.out.println(this.getRollNo()+" Student pays Rs. 70000\n");
 }
 
 public void giveMainExam()
 {
    int marks[]=new int[5];
    int total_marks=0;
    Scanner sc=new Scanner(System.in);
    System.out.println(this.getRollNo()+" ,Enter marks of 5 subjects out of 100: ");

    for(int m=0;m<marks.length;m++)
    {
        marks[m]=sc.nextInt();
        total_marks+=marks[m];
    }
    System.out.println("Student obtained "+total_marks+" marks out of 500");
    System.out.println("Student secured: "+(float)total_marks/500*100+" %\n");     
 }
}