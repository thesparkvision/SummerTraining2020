
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.ProductDao;
import com.adroit.eshop.dto.Product;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "saveproduct", urlPatterns = {"/saveproduct"})
public class SaveProductServlet extends HttpServlet {
 private ProductDao pdao;
 
 @Override
 public void init(ServletConfig config) throws ServletException
 {
  pdao=new ProductDao();
  super.init(config);
 }
 
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
 {
  String pname=req.getParameter("pname");
  String company=req.getParameter("company");
  float price=Float.parseFloat(req.getParameter("price"));
  int category=Integer.parseInt(req.getParameter("category"));
  int subcategory=Integer.parseInt(req.getParameter("subcategory"));
  Product ob=new Product();
  ob.setProdName(pname);
  ob.setCompany(company);
  ob.setPrice(price);
  ob.setCategory(category);
  ob.setSubcategory(subcategory);
  ob.setPic1("???");
  
  boolean check=pdao.save(ob);
  String url="product.jsp?res="+check;
  resp.sendRedirect(url);
 }
 
}
