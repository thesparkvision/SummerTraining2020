import java.util.Scanner;

abstract class Student implements Tution
{
 private String rollno;
 private float percentage;

 public Student()
 {
  this.rollno="";
  this.percentage=0.0f;
 }

 public Student(String rollno,float percent)
 {
  this.rollno=rollno;
  this.percentage=percent;
  }
 
 public String getRollNo()
 {
  return this.rollno;
 }
 
 public void show()
 {
  System.out.println("Student Roll no: "+this.rollno+", Percentage: "+this.percentage);
 }

 public static Student [] input(int n)
  {
    Student[] students=new Student[n];
    Scanner sc=new Scanner(System.in);

    for(int i=0;i<n;i++)
   {
    System.out.println("School(s) Student or College(c) Student: ");
    String option=sc.next();
    
    if(option.equals("s"))
    {
      System.out.println("Enter Student rollno,percent and classname: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      String classname=sc.next();
      students[i]=new SchoolStudent(rollno,percent,classname);     
    }
   else if(option.equals("c"))
    {
      System.out.println("Enter Student rollno,percent and semester: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      String semester=sc.next();
      students[i]=new CollegeStudent(rollno,percent,semester);     
    }
   }
   return students;
  }

  public static void searchStudent(Student [] students, String search_no)
  {
     boolean found=false;
     for(int k=0;k<students.length;k++)
    {
      if(students[k].getRollNo().equals(search_no))
      {
        if(students[k] instanceof SchoolStudent)
            System.out.println("\nRoll no. found and it belongs to SchoolStudent class");
        else if(students[k] instanceof CollegeStudent)
            System.out.println("\nRoll no. found and it belongs to CollegeStudent class");
        else
            System.out.println("\nRoll no. found and it belongs to Student child class");
        found=true;
        break;
      }
    }
    if(found==false)
        System.out.println("\nRoll no. not found");
   }

   public static void giveExam(Student [] students)
   {
     for(int k=0;k<students.length;k++)
     {
       if(students[k] instanceof SchoolStudent)
          {
            SchoolStudent temp_student=(SchoolStudent)students[k];
            temp_student.giveMainExam();
          }
      else
          {
            CollegeStudent temp_student=(CollegeStudent)students[k];
            temp_student.giveMidSemExam();
          }
     }
   }

   public static void payFees(Student [] students)
   {
    for(int k=0;k<students.length;k++)
    {
      if(students[k] instanceof SchoolStudent)
         {
           SchoolStudent temp_student=(SchoolStudent)students[k];
           temp_student.payTutionFees();
         }
     else
         {
           CollegeStudent temp_student=(CollegeStudent)students[k];
           temp_student.payTutionFees();
         }
    }
   }
}