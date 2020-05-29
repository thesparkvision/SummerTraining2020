class SchoolStudent extends Student
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
    int a=2;
 }
 
}