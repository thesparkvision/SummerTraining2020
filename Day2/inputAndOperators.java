import java.util.Scanner;

class inputAndOperators
{
	public static void main(String [] args)
	{
		int num1,num2,additionResult,subtractionResult,multiplicationResult,divisionResult,remainderResult;
		System.out.println("\nPlease enter two numbers: ");
		Scanner sc= new Scanner(System.in);
		num1=sc.nextInt();
		num2=sc.nextInt();

		additionResult=num1+num2;
		subtractionResult=num1-num2;
		multiplicationResult=num1*num2;
		divisionResult=num1/num2;
		remainderResult=num1%num2;

		System.out.println("additionResult: "+additionResult);
		System.out.println("subtractionResult: "+subtractionResult);
		System.out.println("multiplicationResult: "+multiplicationResult);
		System.out.println("divisionResult: "+divisionResult);
		System.out.println("remainderResult: "+remainderResult);
	}
}