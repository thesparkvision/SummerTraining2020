
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.SubCategoryDao;
import com.adroit.eshop.dto.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "updatesubcategory", urlPatterns = {"/updatesubcategory"})
public class UpdateSubCategoryServlet extends HttpServlet {
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
  String cname=req.getParameter("scname").toLowerCase();
  int cid=Integer.parseInt(req.getParameter("scid"));
  SubCategory ob=new SubCategory();
  ob.setSubcateName(cname);
  ob.setSubcateId(cid);
  boolean check=cateDao.update(ob);
  String url="subcategory.jsp";
  resp.sendRedirect(url);
 }
 
}
