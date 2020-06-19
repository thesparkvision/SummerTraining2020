
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.CategoryDao;
import com.adroit.eshop.dto.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "updatecategory", urlPatterns = {"/updatecategory"})
public class UpdateCategoryServlet extends HttpServlet {
 private CategoryDao cateDao;
 
 @Override
 public void init(ServletConfig config) throws ServletException
 {
  cateDao=new CategoryDao();
  super.init(config);
 }
 
 @Override
 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
 {
  String cname=req.getParameter("cname").toLowerCase();
  int cid=Integer.parseInt(req.getParameter("cid"));
  Category cate=new Category(cid,cname);
  boolean check=cateDao.update(cate);
  String url="category.jsp";
  resp.sendRedirect(url);
 }
 
}
