
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.CategoryDao;
import com.adroit.eshop.dao.SubCategoryDao;
import com.adroit.eshop.dto.Category;
import com.adroit.eshop.dto.SubCategory;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "savesubcategory", urlPatterns = {"/savesubcategory"})
public class SaveSubCategoryServlet extends HttpServlet {
 private SubCategoryDao cateDao;
 
 @Override
 public void init(ServletConfig config) throws ServletException
 {
  cateDao=new SubCategoryDao();
  super.init(config);
 }
 
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
 {
  String cname=req.getParameter("subcatename").toLowerCase();
  int cate=Integer.parseInt(req.getParameter("category"));
  SubCategory ob=new SubCategory();
  ob.setSubcateName(cname);
  ob.setCateid(cate);
  boolean check=cateDao.save(ob);
  String url="subcategory.jsp?res="+check;
  resp.sendRedirect(url);
 }
 
}
