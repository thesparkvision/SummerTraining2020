import java.util.Scanner;

class Demo
{
 public static void main(String [] args)
 {
  Scanner sc=new Scanner(System.in);
  Product[] p=new Product[5];
  
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
  p=Demo.sortProducts(p);
  Demo.printProducts(p); 
 }

 public static Product [] sortProducts(Product[] p)
 {
   for(int j=0;j<p.length-1;j++)
   {
     for(int k=j+1;k<p.length;k++)
     {
       if(p[j].getTotalAmount()>p[k].getTotalAmount())
          {
             Product temp=p[j];
             p[j]=p[k];
	     p[k]=temp;
          }
     }
   }
  return p;
 }  

 public static void printProducts(Product[] p)
 {
   for(int l=0;l<p.length;l++)
    System.out.println("Product :"+p[l].getProductID()+" , total amount: "+p[l].getTotalAmount());
 }
  
}