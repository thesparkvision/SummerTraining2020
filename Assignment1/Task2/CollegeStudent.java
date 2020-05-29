class CollegeStudent extends Student
{
 private int semester;
 
 public CollegeStudent()
 {
  super();
  this.semester=0;
 }

 public int getSemester()
 {
     return this.semester;
 }

 public CollegeStudent(String rollno,float percentage,int semester)
 {
 super(rollno,percentage);
 this.semester=semester;
 }

 public void payTutionFees()
 {
     int b=2;
 }
 
}