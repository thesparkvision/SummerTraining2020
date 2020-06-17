
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.SubCategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "checksubcate", urlPatterns = {"/checksubcate"})
public class CheckSubCategoryServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
     String txt=req.getParameter("txt");
	
     SubCategoryDao dao=new SubCategoryDao();
     boolean check=dao.checkByName(txt);

   PrintWriter pw=resp.getWriter();
   pw.write(check+"");
 }
}
