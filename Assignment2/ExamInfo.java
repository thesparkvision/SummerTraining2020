import java.util.*;
import java.util.Map.Entry;

public class ExamInfo
{
  //hashmap object to store all the students
  private HashMap<String,LinkedList<Object>> student_details=new HashMap<String,LinkedList<Object>>(); 
  
  /*This methods add Student to the hashmap*/
  public void addStudent()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("\nEnter rollno: ");
    String roll_no=sc.next();
    if(this.student_details.containsKey(roll_no)) 
    {
      System.out.println("Student with this roll no. already present");
    }
    else
    {
      System.out.print("Enter name: ");
      String name=sc.next();
  
      //linkedlist object to store student details
      LinkedList<Object> linked_list = new LinkedList<Object>();     
      //hashset object to store exam details
      HashSet <ArrayList<Object>> hash_set=new HashSet <ArrayList<Object>>();    
 
      linked_list.add(roll_no);
      linked_list.add(name);
      linked_list.add(hash_set);
  
      this.student_details.put(roll_no,linked_list);
      System.out.println("\nStudent added successfully-> ");
      System.out.println("Roll no: "+roll_no+" ,Name: "+name+", exam_details: "+hash_set);
    }
  }
  
  /*This method searches student in the hashmap by Roll no.*/
  public void searchStudentByRollNo()
  { 
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter Roll no to search: ");
    String roll_no=sc.next();
    LinkedList <Object> student=this.student_details.get(roll_no); //trying to fetch the student details , if not present, will return null
    if(student!=null)
	  {
      System.out.println("Student Found");
   	  System.out.println("Roll no: "+student.get(0)+" ,Name: "+student.get(1)+", Exam_details: "+student.get(2));
	  }
    else
	    System.out.println("Student not found");
  }

  /*This method searches student in the hashmap by Name*/
  public void searchStudentByName()
  {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter name to search: ");
    String name=sc.next();
   
    boolean is_found=false;
    //this is done so one can iterate over the hashmap
    Set set = this.student_details.entrySet();   
    Iterator iterator = set.iterator();

    while(iterator.hasNext()) {
      Map.Entry mentry = (Map.Entry)iterator.next();
        try
	      {
          //trying to get the linkedlist object so student name can be fetched 
	 	      LinkedList <Object> student=(LinkedList <Object>)mentry.getValue();  
          if(student.get(1).equals(name))
	 	      {
		  	    System.out.println("Student Found");
   	 		    System.out.println("Roll no: "+student.get(0)+" ,Name: "+student.get(1)+", Exam_details: "+student.get(2));
			      is_found=true;
			      break;
	 	      }
   	    }
	      catch(Exception ex)
	      {	
		      System.out.println("Exception Found : "+ex.getMessage());
	      } 
    } 
    if(is_found==false)
	    System.out.println("Student not found");
  }
  
  /*This method deletes a student record if it is present in hashmap*/
  public void deleteStudent()
  {
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter roll no to delete: ");
    String roll_no=sc.next();
    if(student_details.containsKey(roll_no))
	  {
      this.student_details.remove(roll_no);
	    System.out.println("Student record deleted successfully");
	  }
    else
	    System.out.println("Student record not found. Hence can't be deleted");
  }

  /*This method add exam details in Student Record*/
  public void addExam()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter Roll no. of student : ");
    String roll_no=sc.next();

    //fetching the linkedlist object of student
    LinkedList <Object> student=this.student_details.get(roll_no);
    if(student!=null)
	  { 
      //getting the hashset object inside student linkedlist which contains exam hashmap
      HashSet <ArrayList<Object>> exam_details_set=(HashSet <ArrayList<Object>>)student.get(2);	
	    if(exam_details_set.isEmpty())
	    {
        System.out.print("Enter Exam title: ");
        String title=sc.next();  
        //creating a hashmap object to store exam marks with subject names 
	      HashMap <String,Integer> marks=new HashMap <String,Integer>(); 

        System.out.print("Enter physics marks: ");
        marks.put("physics",sc.nextInt());
        System.out.print("Enter chemistry marks: ");
        marks.put("chemistry",sc.nextInt());
        System.out.print("Enter maths marks: ");
        marks.put("maths",sc.nextInt());
        System.out.print("Enter computer marks: ");
        marks.put("computer",sc.nextInt());
        System.out.print("Enter bio marks: ");
        marks.put("bio",sc.nextInt());
            
        //creating arraylist object to store exam name and marks
	      ArrayList <Object> exam_details=new ArrayList<Object>();  
	      exam_details.add(title);
	      exam_details.add(marks);
		
	      exam_details_set.add(exam_details); //adding exam details in exam details hashset
	      student.set(2,exam_details_set);	//updating the hashset in student linkedlist
	      this.student_details.put(roll_no,student);	//updating the hashmap with modified student details
		
        System.out.println("Exam details added successfully");
	    }
	    else
	      System.out.println("Exam already given");
    }
    else
	    System.out.println("Student not found"); 
  }

  /*This method creates a hashmap of rollno and marks for further processing*/
  public HashMap<String,Integer> findNameMarksPair(String marks_category)
  {
    //creating a temporary hashmap for storing name and marks
    HashMap<String,Integer> name_marks_set=new HashMap<String,Integer>(); 
    Iterator<Entry<String, LinkedList<Object>>> it =null;
    it=(Iterator<Entry<String, LinkedList<Object>>>) this.student_details.entrySet().iterator();

    while (it.hasNext()) 
    {
      //Getting physics marks of student and storing name and marks in names_marks_set
      Map.Entry<String, LinkedList<Object>> pair =null;
      pair= (Map.Entry<String, LinkedList<Object>>) it.next();
      LinkedList<Object> student_details=(LinkedList <Object>)pair.getValue();
      HashSet <Object> exam_details_set=(HashSet <Object>)student_details.get(2);
      Iterator iterator1 = exam_details_set.iterator(); 
      while (iterator1.hasNext())
      {
        int total_marks=0;
	      ArrayList <Object> arr1=(ArrayList <Object>)iterator1.next();
        HashMap<String,Integer> marks=(HashMap<String,Integer>) arr1.get(1);
        if(marks_category.equals("total"))
        {
          total_marks+=marks.get("physics");
          total_marks+=marks.get("chemistry");
          total_marks+=marks.get("computer");
          total_marks+=marks.get("bio");
          total_marks+=marks.get("maths");
        }
        else
        {
          total_marks+=marks.get(marks_category);
        }
        name_marks_set.put(pair.getKey(),total_marks);
      }
    }
    return name_marks_set;
  }
 
  /*  This method sorts the hashmap of String rollno and Integer marks 
      and returns a linkedlist of it */
  public  List<Entry<String, Integer>> sortStudents(HashMap<String,Integer> names_marks_set)
  {
    List<Entry<String, Integer>> list = null;
    list=new LinkedList<Entry<String, Integer>>(names_marks_set.entrySet());   
    Collections.sort(list, new Comparator<Entry<String, Integer>>()   
    {  
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   
      {   
        return o2.getValue().compareTo(o1.getValue());  
      }  
    });  
    return list; 
  }
  
  /*This method prints the details of 5 toppers*/
  public void PrintToppers(String marks_category,List<Entry<String, Integer>> list)
  {
    int i=0;
    System.out.println("The 5 "+marks_category+" toppers are:");
    System.out.println("\tRollNo\tName\tMarks\n");
    for (Entry<String, Integer> entry : list)   
    { 
      String roll_no=entry.getKey();
      int marks=entry.getValue();
      LinkedList<Object> student=this.student_details.get(roll_no);
      System.out.println("\t"+roll_no +"\t"+student.get(1)+"\t"+marks);  
      i+=1;
      if(i==5)
        break;
    }
  }

  /*This method finds Physics subject Toppers*/
  public void showPhysicsToppers()
  { 
    String marks_category="physics";
    HashMap<String,Integer> name_marks_set=this.findNameMarksPair(marks_category);
    List<Entry<String, Integer>> list=this.sortStudents(name_marks_set); 
    this.PrintToppers(marks_category, list);  
  }

  /*This method finds Computer subject Toppers*/
  public void showComputerToppers()
  {
    String marks_category="computer";
    HashMap<String,Integer> name_marks_set=this.findNameMarksPair(marks_category);
    List<Entry<String, Integer>> list=this.sortStudents(name_marks_set); 
    this.PrintToppers(marks_category, list); 
  }

  /*This method finds Overall Toppers based on total_marks*/
  public void showTopStudents()
  {
    String marks_category="total";
    HashMap<String,Integer> name_marks_set=this.findNameMarksPair(marks_category);
    List<Entry<String, Integer>> list=this.sortStudents(name_marks_set); 
    this.PrintToppers(marks_category, list); 
  } 

}//end of class ExamInfo