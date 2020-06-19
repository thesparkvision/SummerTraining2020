
package com.adroit.eshop.dao;

import com.adroit.eshop.dto.SubCategory;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;
import java.util.List;

public class SubCategoryDao implements BaseDao<SubCategory>{

    @Override
    public boolean save(SubCategory ob) {
       try(Connection cnn=DBConnection.getConnection()) //this is possible because Connection has closeable interface, 
							//so java will automatically close it
    {
      String query="insert into subcategory(scate_name,category) "
         +"value(?,?)";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setString(1,ob.getSubcateName());
      stm.setInt(2,ob.getCateid());
      
      int i=stm.executeUpdate();
      if(i>0)
           return true;
    }
    catch(Exception ex)
     {
       System.err.println("SubCategory Save Error"+ex.getMessage());
     }
     return false; 
    }

    @Override
    public boolean update(SubCategory ob) {
        try(Connection cnn=DBConnection.getConnection()) 
    {
      String query="update subcategory set scate_name=? "
         +"where scate_id=?";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setString(1,ob.getSubcateName());
      stm.setInt(2,ob.getSubcateId());
      int i=stm.executeUpdate();
      if(i>0)
           return true;
    }
    catch(Exception ex)
     {
       System.err.println("SubCategory Update Error"+ex.getMessage());
     }
     return false; 
    }

    @Override
    public SubCategory get(int id) {
        SubCategory ob=null;    
        try(Connection cnn=DBConnection.getConnection()) 
            {
            String query="select * from subcategory "
             +"where scate_id=?";
            PreparedStatement stm=cnn.prepareStatement(query);
            stm.setInt(1,id);
      
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
            int scid=rs.getInt("scate_id");
            String scname=rs.getString("scate_name");
            int cid=rs.getInt("category");
            
            ob=new SubCategory(scid,scname,cid);
            }
        }
    catch(Exception ex)
     {
       System.err.println("SubCategory Get Error"+ex.getMessage());
     }
     return ob; 
    }

    @Override
    public ArrayList<SubCategory> list() 
    {
         ArrayList<SubCategory> clist=new ArrayList<>();
        try(Connection cnn=DBConnection.getConnection()) 
      {
     
      String query="select * from subcategory"
              +" order by scate_name";
      PreparedStatement stm=cnn.prepareStatement(query);
      ResultSet rs=stm.executeQuery();
      while(rs.next())
        {
          int scid=rs.getInt("scate_id");
          String scname=rs.getString("scate_name");
          int cid=rs.getInt("category");
          SubCategory ob=new SubCategory(scid,scname,cid);
	  clist.add(ob);
        }
    }
    catch(Exception ex)
     {
       System.err.println("SubCategory List Error"+ex.getMessage());
     }
     return clist; 
    }

    public boolean checkByName(String txt)
   {
   try(Connection cnn=DBConnection.getConnection())
   {
    String query="select * from subcategory "+
	"where scate_name=?";
    PreparedStatement stm=cnn.prepareStatement(query);
    stm.setString(1,txt);
    ResultSet rs=stm.executeQuery();
    return rs.next();
   }
   catch(Exception ex)
   {
       System.out.println("SubCategory Check Error: "+ex.getMessage());
   }
   return false;
}

    public List<SubCategory> list(int category) 
    {
       ArrayList<SubCategory> clist=new ArrayList<>();
      try(Connection cnn=DBConnection.getConnection()) 
       {
      String query="select * from subcategory "
              +"where category=? "
              +"order by scate_name";
      PreparedStatement stm=cnn.prepareStatement(query);
      stm.setInt(1,category);
      ResultSet rs=stm.executeQuery();
      while(rs.next())
        {
          int scid=rs.getInt("scate_id");
          String scname=rs.getString("scate_name");
          int cid=rs.getInt("category");
          SubCategory ob=new SubCategory(scid,scname,cid);
	  clist.add(ob);
        }
    }
    catch(Exception ex)
     {
       System.err.println("SubCategory List Error"+ex.getMessage());
     }
     return clist; 
    }
    
}
