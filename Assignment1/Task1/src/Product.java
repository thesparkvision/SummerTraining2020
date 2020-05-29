class Product
{
  private String pid;
  private float price,total_amount;
  private int quantity;

  public Product(String pid,float price,int quantity)
  { 
    this.pid=pid;
    this.price=price;
    this.quantity=quantity;
    this.total_amount=this.price*this.quantity;
  }

  public float getTotalAmount()
  {
    return this.total_amount;   
  }

  public String getProductID()
  {
    return this.pid;   
  }

  //static bubble sort method to sort all products using total_amount attribute
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
  
  //static print method to print all product objects
  public static void printProducts(Product[] p)
  {
    for(int l=0;l<p.length;l++)
     System.out.println("Product :"+p[l].getProductID()+" , total amount: "+p[l].getTotalAmount());
  }

}