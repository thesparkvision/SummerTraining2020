import java.util.*;
import java.util.Map.Entry;

public class ExamInfo
{
  private HashMap<String,LinkedList<Object>> student_details=new HashMap<String,LinkedList<Object>>();
  
 public void addStudent()
 {
  Scanner sc=new Scanner(System.in);
  System.out.print("\nEnter rollno: ");
  String roll_no=sc.next();
  System.out.print("Enter name: ");
  String name=sc.next();
  
  LinkedList<Object> linked_list = new LinkedList<Object>();
  HashSet <ArrayList<Object>> hash_set=new HashSet <ArrayList<Object>>();
 
  linked_list.add(roll_no);
  linked_list.add(name);
  linked_list.add(hash_set);
  
  this.student_details.put(roll_no,linked_list);
  System.out.println("\nStudent added successfully-> ");
  System.out.println("Roll no: "+roll_no+" ,Name: "+name+", exam_details: "+hash_set);
 }

 public void searchStudentByRollNo()
 { 
   Scanner sc=new Scanner(System.in);

   System.out.println("Enter Roll no to search: ");
   String roll_no=sc.next();
   LinkedList <Object> student=this.student_details.get(roll_no);
   if(student!=null)
	{
         System.out.println("Student Found");
   	 System.out.println("Roll no: "+student.get(0)+" ,Name: "+student.get(1)+", Exam_details: "+student.get(2));
	}
   else
	System.out.println("Student not found");
  }

 public void searchStudentByName()
 {
   Scanner sc=new Scanner(System.in);
   System.out.println("searchStudentByName working");

   System.out.println("Enter name to search: ");
   String name=sc.next();
   
   boolean is_found=false;
   Set set = this.student_details.entrySet();
   Iterator iterator = set.iterator();
   while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         try
	 {
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

 public void deleteStudent()
 {
   Scanner sc=new Scanner(System.in);
   System.out.println("deleteStudent working");

   System.out.println("Enter roll no to delete: ");
   String roll_no=sc.next();
   if(student_details.containsKey(roll_no))
	{
         this.student_details.remove(roll_no);
	 System.out.println("Student record delete successfully");
	}
   else
	System.out.println("Student not found");
   
 }

 public void addExam()
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter Roll no. of student : ");
   String roll_no=sc.next();

   LinkedList <Object> student=this.student_details.get(roll_no);
   if(student!=null)
	{ 
          HashSet <ArrayList<Object>> exam=(HashSet <ArrayList<Object>>)student.get(2);
	 if(exam.isEmpty())
	 {
            System.out.print("Enter Exam title: ");
   	    String title=sc.next();  
            HashSet <ArrayList<Object>> student_exam_details=new HashSet <ArrayList<Object>>();
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
            
	    ArrayList <Object> exam_details=new ArrayList<Object>();
	    exam_details.add(title);
	    exam_details.add(marks);
		
	    student_exam_details.add(exam_details);
	    student.set(2,student_exam_details);
	    this.student_details.put(roll_no,student);
		
            System.out.println("Exam details added successfully");
	 }
	 else
	    System.out.println("Exam already given");
       }
   else
	System.out.println("Student not found");
   
 }

 public void showPhysicsToppers()
 {
   System.out.println("showPhysicsToppers working");
   Set<Entry<String, LinkedList<Object>>> entries = this.student_details.entrySet();

  Comparator<Entry<String, LinkedList<Object>>> valueComparator = new Comparator<Entry<String,LinkedList<Object>>>() {
            public int compare(Entry<String, LinkedList<Object>> e1, Entry<String, LinkedList<Object>> e2) {
                LinkedList<Object> v1 = e1.getValue();
                LinkedList<Object> v2= e2.getValue();
                HashSet <ArrayList<Object>> hash1=(HashSet <ArrayList<Object>>)v1.get(2);
		int marks1,marks2;
		Iterator iterator = hash1.iterator(); 
		while (iterator.hasNext()) {
		
        	 ArrayList <Object> arr2=(ArrayList <Object>)iterator.next();
                  System.out.println(arr2);
		 marks2=arr2.get(1).get("physics");
		}
		HashSet <ArrayList<Object>> hash2=(HashSet <ArrayList<Object>>)v2.get(2);
		Iterator iterator = hash2.iterator(); 
		while (iterator.hasNext()) {
        	 ArrayList <Object> arr1=(ArrayList <Object>)iterator.next();
		 marks1=arr1.get(1).get("physics");
		}
		return marks1>marks2;
             }
        };
 
  List<Entry<String, LinkedList<Object>>> listOfEntries = new ArrayList<Entry<String, LinkedList<Object>>>(entries);

  Collections.sort(listOfEntries, valueComparator);
        
  LinkedHashMap<String, String> sortedByValue = new LinkedHashMap<String, String>(listOfEntries.size());
        
  for(Entry<String, String> entry : listOfEntries){
        sortedByValue.put(entry.getKey(), entry.getValue());
   }

   System.out.println("HashMap after sorting entries by values ");
   Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
        
   for(Entry<String, String> mapping : entrySetSortedByValue){
          System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
    }
        
 }

 public void showComputerToppers()
 {
  System.out.println("showComputerToppers working");
 }

 public void showTop5Students()
 {
  System.out.println("showTop5Students working");

 } 
 
}