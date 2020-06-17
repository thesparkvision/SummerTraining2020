/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.CategoryDao;
import com.adroit.eshop.dto.Category;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "savecate", urlPatterns = {"/savecategory"})
public class SaveCategoryServlet extends HttpServlet {
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
  Category cate=new Category();
  cate.setCateName(cname);
  boolean check=cateDao.save(cate);
  String url="category.jsp?res="+check;
  resp.sendRedirect(url);
 }
 
}
