class ExampleDemo
{
	private int x,y;

	public ExampleDemo(int x,int y)
	{
		System.out.println("Local variables x: "+x+", y: "+y); //So here the scope is of local variables so they are printed.
		x=x;
		y=y;
	}

	public void show()
	{
		System.out.println("Instance Variables x: "+x+" ,y: "+y); //The instance variables were never initalised by the above constructor, hence will be printed as 0,0
	}
}

class MainClass
{
	public static void main(String[] args) {
		ExampleDemo ex1=new ExampleDemo(4,5);
		ex1.show();

		ExampleDemo ex2=new ExampleDemo(8,7);
		ex2.show();
	}
}