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

  public int getQuantity()
  {
   return this.quantity;
  }
  
  public float getPrice()
  {
   return this.price;
  }
}