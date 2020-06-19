
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "checkcate", urlPatterns = {"/checkcate"})
public class CheckCategoryServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
     String txt=req.getParameter("txt");
	
     CategoryDao cdao=new CategoryDao();
     boolean check=cdao.checkByName(txt);

   PrintWriter pw=resp.getWriter();
   pw.write(check+"");
 }
}
