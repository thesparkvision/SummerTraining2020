import java.util.Scanner;

class Exam
{
	private String title;
	private int marks[];

	public Exam()
	{
		this.marks=new int[5];
	}

	public void giveExam()
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the subject title:");
		this.title=sc.next();

		System.out.println("Enter the 5 subject marks:");
		for(int x=0;x<5;x++)
		{
			this.marks[x]=sc.nextInt();
		}
	}

	public void showExam()
	{
		System.out.println("\n\tSubject title: "+this.title);
		System.out.println("\tSubject marks: ");
		for(int num:this.marks)
		{
			System.out.print(num+" ");
		}
		System.out.print("\n");

		Result res=new Result();
		res.calculateResult(this.marks);
	}

}