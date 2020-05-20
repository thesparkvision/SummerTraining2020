class SampleExample
{
	private int x,y; //private instance variables and they get default values as 0,0

	public void show()
	{
		System.out.println("X: "+x);
		System.out.println("Y: "+y);
	}
}

class ProperClassExample
{
	public static void main(String[] args) {
		SampleExample obj=new SampleExample();
		obj.show();			
	}
}