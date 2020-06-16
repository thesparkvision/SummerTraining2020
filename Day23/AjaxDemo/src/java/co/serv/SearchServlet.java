/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name="search",urlPatterns={"/search"})
public class SearchServlet extends HttpServlet
{
 @Override
 public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
 {
    String txt=req.getParameter("data");  
    try
    {
      //resp.getWriter().println("test" +txt);
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection cnn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample1?useSSL=false","root","root");
      
      String query="select * from student "
       +"where name like '%"+txt+"%' "
        +"order by name";
      
      PreparedStatement stm=cnn.prepareStatement(query);
      ResultSet rs=stm.executeQuery();
      
      ArrayList<Student> slist=new ArrayList<Student>();
      while(rs.next())
      {
          int roll=rs.getInt("roll");
          String name=rs.getString("name");
          String phone=rs.getString("phone");
          String email=rs.getString("email");
          String city=rs.getString("city");
          
          Student s=new Student(roll,name,phone,email,city);
          slist.add(s);
      }
      
      Gson gson=new Gson();
      String json=gson.toJson(slist);
              
      PrintWriter pw=resp.getWriter();
      pw.print(json); 
    }
    catch(Exception ex){
        System.out.println(""+ex.getMessage());
    }
    
 }
}