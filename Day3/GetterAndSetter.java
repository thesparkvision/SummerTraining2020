class DemoExample
{
	private int x,y;

	public DemoExample(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public void show()
	{
		System.out.println("x: "+x+" ,y:"+y);
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getXAlso()  //This approach is also right but is not preferred as it can created issues if we have local variables also present in the method
	{			
		return x;			
	}

	public void setX(int x)
	{
		this.x=x;
	}

	public void setY(int y)
	{
		this.y=y;
	}
}

class GetterAndSetter
{
	public static void main(String[] args) {
		DemoExample ex1=new DemoExample(5,12);
		ex1.show();
		ex1.setX(77);
		System.out.println("x: "+ex1.getX());
		ex1.setY(90);
		System.out.println("y: "+ex1.getY());	
	}
}