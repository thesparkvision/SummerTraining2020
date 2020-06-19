
package com.adroit.eshop.dao;

import com.adroit.eshop.dto.Category;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;

public class CategoryDao implements BaseDao<Category>{

    @Override
    public boolean save(Category ob) {
       try(Connection cnn=DBConnection.getConnection()) //this is possible because Connection has closeable interface, 
							//so java will automatically close it
    {
      String query="insert into category(cate_name) "
         +"value(?)";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setString(1,ob.getCateName());
      int i=stm.executeUpdate();
      if(i>0)
           return true;
    }
    catch(Exception ex)
     {
       System.err.println("Category Save Error"+ex.getMessage());
     }
     return false; 
    }

    @Override
    public boolean update(Category ob) {
        try(Connection cnn=DBConnection.getConnection()) 
    {
      String query="update category set cate_name=? "
         +"where cate_id=?";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setString(1,ob.getCateName());
      stm.setInt(2,ob.getCateId());
      int i=stm.executeUpdate();
      if(i>0)
           return true;
    }
    catch(Exception ex)
     {
       System.err.println("Category Update Error"+ex.getMessage());
     }
     return false; 
    }

    @Override
    public Category get(int id) {
        Category ob=null;    
        try(Connection cnn=DBConnection.getConnection()) 
            {
            String query="select * from category "
             +"where cate_id=?";
            PreparedStatement stm=cnn.prepareStatement(query);
            stm.setInt(1,id);
      
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
            int cid=rs.getInt("cate_id");
            String cname=rs.getString("cate_name");
            ob=new Category(cid,cname);
            }
        }
    catch(Exception ex)
     {
       System.err.println("Category Get Error"+ex.getMessage());
     }
     return ob; 
    }

    @Override
    public ArrayList<Category> list() {
         ArrayList<Category> clist=new ArrayList<>();
        try(Connection cnn=DBConnection.getConnection()) 
    {
     
      String query="select * from category";
      PreparedStatement stm=cnn.prepareStatement(query);
      ResultSet rs=stm.executeQuery();
      while(rs.next())
        {
          int cid=rs.getInt("cate_id");
          String cname=rs.getString("cate_name");
          Category ob=new Category(cid,cname);
	  clist.add(ob);
        }
    }
    catch(Exception ex)
     {
       System.err.println("Category List Error"+ex.getMessage());
     }
     return clist; 
    }

    public boolean checkByName(String txt)
   {
   try(Connection cnn=DBConnection.getConnection())
   {
    String query="select * from category "+
	"where cate_name=?";
    PreparedStatement stm=cnn.prepareStatement(query);
    stm.setString(1,txt);
    ResultSet rs=stm.executeQuery();
    return rs.next();
   }
   catch(Exception ex)
   {
       System.out.println("Category Check Error: "+ex.getMessage());
   }
   return false;
}
    
}
