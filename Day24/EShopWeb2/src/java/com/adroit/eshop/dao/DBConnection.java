
package com.adroit.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
  public static Connection getConnection() throws ClassNotFoundException,SQLException
  {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection cnn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eshop?useSSL=false","root","root");
      return cnn;
  }  
}
