class DemoExample
{
	private int x,y;

	public DemoExample(int a,int b)  //Here parametrised constructor is used and it has worked as an overloaded constructor
	{
		x=a;
		y=b;
	}

	public void show()
	{
		System.out.println("x: "+x+" ,y: "+y);
	}
}

class ParametrizedConstructor
{
	public static void main(String[] args) {
		DemoExample obj1=new DemoExample(5,4);
		obj1.show();

		DemoExample obj2=new DemoExample(7,2);
		obj2.show();
	}
}