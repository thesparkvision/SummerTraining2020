
package com.adroit.eshop.controller;

import com.adroit.eshop.dao.SubCategoryDao;
import com.adroit.eshop.dto.SubCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet(name = "getsubcate", urlPatterns = {"/getsubcate"})
public class GetSubCateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        int cid=Integer.parseInt(req.getParameter("cid"));
        SubCategoryDao sdao=new SubCategoryDao();
 
        List<SubCategory> list=sdao.list(cid);
 
        Gson gson=new Gson();
        String json=gson.toJson(list);

        PrintWriter pw=resp.getWriter();
        pw.write(json);
    }
 }
