class Result
{
	public void calculateResult(int marks[])
	{
		int total=0;
		float per;
		for(int x:marks)
		{
			total+=x;
		}
		per=(float)total/5;
		System.out.println("Total Marks: "+total);
		System.out.println("Percentage: "+per);
	}
}