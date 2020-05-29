import java.util.Scanner;

class Task1
{
 public static void main(String [] args)
 {
   //Creating required objects in memory
  Scanner sc=new Scanner(System.in);
  Product[] p=new Product[5];
  
  //Taking input in Array
  for(int i=0;i<5;i++)
  {
    System.out.println("Enter the Product id:");
    String pid=sc.next();
    System.out.println("Enter the Product price:");
    float price=sc.nextFloat();
    System.out.println("Enter the Product Quantity:");
    int quantity=sc.nextInt();
    
    p[i]=new Product(pid,price,quantity); 
  }

  //Sorting the Products according to total_amount attribute
  p=Product.sortProducts(p);

  //Printing Products
  Product.printProducts(p); 

  //closing the Scanner object
  sc.close();
 }
}