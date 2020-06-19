
package com.adroit.eshop.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adroit.eshop.dao.ProductDao;

@WebServlet(name = "flipproductstatus", urlPatterns = {"/flipproductstatus"})
public class FlipServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)  throws ServletException,IOException 
    {
        int pid=Integer.parseInt(req.getParameter("pid"));
        ProductDao pdao=new ProductDao();
        boolean check=pdao.flipStatus(pid);
        resp.sendRedirect("product.jsp");
    }
}
