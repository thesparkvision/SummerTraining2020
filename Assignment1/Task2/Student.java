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
}