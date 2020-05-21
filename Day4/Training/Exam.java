import java.util.Scanner;

class Exam
{
	private String title;
	private int marks[];

	public Exam()
	{
		marks=new int[5];
	}

	public void giveExam()
	{
		System.out.println("Enter the subject title:");
		Scanner sc=new Scanner(System.in);
		this.title=sc.next();

		System.out.println("Enter the 5 subject marks:");
		for(int x=0;x<5;x++)
		{
			this.marks[x]=sc.nextInt();
		}
	}

	public void showExam()
	{
		System.out.println("Subject title: "+this.title);
		System.out.println("Subject marks: ");
		for(int x:this.marks)
		{
			System.out.println(x);
		}
	}

}