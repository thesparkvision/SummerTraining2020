class DemoExample
{
	private int x,y;

	public DemoExample(int x,int y)
	{
		this.x=x; //this.x is instance variable and x is local variable now
		this.y=y;
	}

	public void show()
	{
		System.out.println("x: "+x+" ,y: "+y);
	}
}

class ThisKeyword
{
	public static void main(String[] args) {
		DemoExample ex1=new DemoExample(5,6);
		ex1.show();

		DemoExample ex2=new DemoExample(11,78);
		ex2.show();
	}
}