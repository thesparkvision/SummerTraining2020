
package com.adroit.eshop.dao;

import com.adroit.eshop.dto.Product;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;

public class ProductDao implements BaseDao<Product>{

    @Override
    public boolean save(Product ob) {
       try(Connection cnn=DBConnection.getConnection()) //this is possible because Connection has closeable interface, 
							//so java will automatically close it
    {
      String query="insert into product "
              +"(prod_name,company,price,"
              +"pic1,category,subcategory) "
              +"value(?,?,?,?,?,?)";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setString(1,ob.getProdName());
      stm.setString(2,ob.getCompany());
      stm.setFloat(3,ob.getPrice());
      stm.setString(4,ob.getPic1());
      stm.setInt(5,ob.getCategory());
      stm.setInt(6,ob.getSubcategory());
      
      int i=stm.executeUpdate();
      if(i>0)
           return true;
    }
    catch(Exception ex)
     {
       System.err.println("Product Save Error"+ex.getMessage());
     }
     return false; 
    }

    @Override
    public boolean update(Product ob) {
      
     return false; 
    }

    @Override
    public Product get(int id) {
        Product ob=null;    
        try(Connection cnn=DBConnection.getConnection()) 
            {
            String query="select * from product "
             +"where prod_id=?";
            PreparedStatement stm=cnn.prepareStatement(query);
            stm.setInt(1,id);
      
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
            int pid=rs.getInt("prod_id");
            String pname=rs.getString("prod_name");
            String company=rs.getString("company");
            float price=rs.getFloat("price");
            String pic1=rs.getString("pic1");
            String pic2=rs.getString("pic2");
            String pic3=rs.getString("pic3");
            int category=rs.getInt("category");
            int subcategory=rs.getInt("subcategory");
            boolean isactive=rs.getBoolean("isactive");
            ob=new Product(pid,pname,company,price,pic1,pic2,pic3,category,subcategory,isactive);
            }
        }
    catch(Exception ex)
     {
       System.err.println("Product Get Error"+ex.getMessage());
     }
     return ob; 
    }

    @Override
    public ArrayList<Product> list() {
         ArrayList<Product> clist=new ArrayList<>();
        try(Connection cnn=DBConnection.getConnection()) 
    {
     
      String query="select * from product "
              +"order by isactive DESC,prod_name,price";
      PreparedStatement stm=cnn.prepareStatement(query);
      ResultSet rs=stm.executeQuery();
      while(rs.next())
        {
          int pid=rs.getInt("prod_id");
            String pname=rs.getString("prod_name");
            String company=rs.getString("company");
            float price=rs.getFloat("price");
            String pic1=rs.getString("pic1");
            String pic2=rs.getString("pic2");
            String pic3=rs.getString("pic3");
            int category=rs.getInt("category");
            int subcategory=rs.getInt("subcategory");
            boolean isactive=rs.getBoolean("isactive");
            Product ob=new Product(pid,pname,company,price,pic1,pic2,pic3,category,subcategory,isactive);
	  clist.add(ob);
        }
    }
    catch(Exception ex)
     {
       System.err.println("Product List Error"+ex.getMessage());
     }
     return clist; 
    }

    public ArrayList<Product> list(boolean status) {
         ArrayList<Product> clist=new ArrayList<>();
        try(Connection cnn=DBConnection.getConnection()) 
    {
     
      String query="select * from product "
              +"where isactive=?"
              +"order by prod_name,price";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setBoolean(1,status);
      ResultSet rs=stm.executeQuery();
      while(rs.next())
        {
          int pid=rs.getInt("prod_id");
            String pname=rs.getString("prod_name");
            String company=rs.getString("company");
            float price=rs.getFloat("price");
            String pic1=rs.getString("pic1");
            String pic2=rs.getString("pic2");
            String pic3=rs.getString("pic3");
            int category=rs.getInt("category");
            int subcategory=rs.getInt("subcategory");
            boolean isactive=rs.getBoolean("isactive");
            Product ob=new Product(pid,pname,company,price,pic1,pic2,pic3,category,subcategory,isactive);
	  clist.add(ob);
        }
    }
    catch(Exception ex)
     {
       System.err.println("Product List Error"+ex.getMessage());
     }
     return clist; 
    }
    
    public boolean checkByName(String txt)
   {
   try(Connection cnn=DBConnection.getConnection())
   {
    String query="select * from product"+
	"where prod_name=?";
    PreparedStatement stm=cnn.prepareStatement(query);
    stm.setString(1,txt);
    ResultSet rs=stm.executeQuery();
    return rs.next();
   }
   catch(Exception ex)
   {
       System.out.println("Product Check Error: "+ex.getMessage());
   }
   return false;
}
    
}
