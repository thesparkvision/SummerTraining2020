import java.util.Scanner;

class Operation
{
  public static Student [] input(int n)
  {
    Student[] students=new Student[n];
    Scanner sc=new Scanner(System.in);

    String s="school";
    String c="college";

    for(int i=0;i<n;i++)
   {
    System.out.println("School(s) Student or College(c) Student: ");
    String option=sc.next();
    System.out.println(option==s);
    if(option==s)
    {
      System.out.println("Enter Student rollno,percent and classname: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      String classname=sc.next();
      students[i]=new SchoolStudent(rollno,percent,classname);     
    }
   else if(option==c)
    {
      System.out.println("Enter Student rollno,percent and semester: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      int semester=sc.nextInt();
      students[i]=new CollegeStudent(rollno,percent,semester);     
    }
   }
   sc.close();
   return students;
  }

  public static void searchStudent(Student [] students, String search_no)
  {
     for(int k=0;k<students.length;k++)
    {
      if(students[k].getRollNo()==search_no)
      {
        if(students[k] instanceof SchoolStudent)
            System.out.println("Roll no. found and it belongs to SchoolStudent class");
        else if(students[k] instanceof CollegeStudent)
            System.out.println("Roll no. found and it belongs to CollegeStudent class");
        else
            System.out.println("Roll no. found and it belongs to Student child class");
        break;
      }
      else
        System.out.println("Roll no. not found");
    }
  }
}