class Operation
{
 public static Students [] input(int n)
  {
    for(int i=0;i<n;i++)
   {
    System.out.println("School(s) Student or College(c) Student: ");
    Strint option=sc.next();
    if(option=="s");
    {
      System.out.println("Enter Student rollno,percent and classname: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      String classname=sc.next();
      students[i]=SchoolStudent(rollno,percent,classname);     
    }
   else
    {
      System.out.println("Enter Student rollno,percent and semester: ");
      String rollno=sc.next();
      float percent=sc.nextFloat();
      int semester=sc.nextInt();
      students[i]=CollegeStudent(rollno,percent,semester);     
    }
  }
 }
 
 public static void searchStudents(Student [] students,String search_no)
 { 
   for(int  k=0;k<students.length;k++)
   {
      if(students[k].getRollNo==search_no)
       {
         if(students[k] instanceof SchoolStudent)
             System.out.println("Roll no. found and it is of School Student");
         else if(students[k] instanceof CollegeStudent)
             System.out.println("Roll no. found and it is of School Student");
	 else
	     System.out.println("Roll no. found and it is of child class of Student class or its own object");
         break; 
       }
   }

  
 }