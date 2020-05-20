class Example
{
	private void fun1()
	{
		System.out.println("This is a private method.");
	}

	public void fun2()
	{
		System.out.println("This is a public method.");
	}
}

class PrivateAndPublicExample
{
	public static void main(String[] args) {
		Example ex1=new Example();
		Example ex2;
		ex1.fun2();
		//ex2.fun1(); 
		//This will cause error as fun1 is a private method and can't be accessed directly using object
	}
}