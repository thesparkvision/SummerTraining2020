import java.util.Scanner;

class Student
{
	private int roll_no;
	private String name;
	private Exam exams[];
	private int examcounter;  //automatically set to 0

	public Student()
	{
		exams=new Exam[5];
		for(int x=0;x<5;x++)
		{
			this.exams[x]=new Exam();
		}
	}

	public void input()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Roll no: ");
		this.roll_no=sc.nextInt();
		System.out.println("Name: ");
		this.name=sc.next();
	}

	public void output()
	{
		System.out.println("\n\tRoll number: "+this.roll_no);
		System.out.println("\tName: "+this.name);
		System.out.println("\tExam Details: \n");
		for(int x=0;x<examcounter;x++)
		{
			this.exams[x].showExam();
		}
	}

	public void addExam()
	{
		if(this.examcounter<5)
		{
			this.exams[examcounter].giveExam();
		}
		else
		{
			System.out.println("All exams taken");
		}
	}

}