<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.Category"%>
<%@page import="com.adroit.eshop.dao.CategoryDao"%>
<%@include file="blocks/header.jsp" %>

<%  
    CategoryDao cdao=new CategoryDao();
%>

<%
    String result=request.getParameter("res");
    String resultmsg="";
    if(result!=null && result.equals("true")){ resultmsg="Category Saved!";}
    if(result!=null && result.equals("false")){ resultmsg="Category Not Saved!";}
    //*****************************************************************************
    List<Category> clist=cdao.list();   
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Add New Category</h1>
            <br>
            <div class="row">
                <form action="savecategory" method="POST">
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <input type="text" class="form-control" name="cname" placeholder="Category Name" required>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                    <input type="submit" value="Save" class="btn btn-primary ml-2">
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                </form>
            </div>
            <br>
            <b class='text-danger'><%=resultmsg%></b>
            <hr>
            
            <h2>Category List</h2>
            <table class="table table-hover">
                <tr>
                    <th>S.No.</th>
                    <th>Category Name</th>
                </tr>
                <%
                    int x=1;
                    for(Category cate:clist)
                    {
                %>
                <tr>
                    <td><%=x%></td>
                    <td><%=cate.getCateName()%></td>
                </tr>
                <% x++;} %>
            </table>
        </div>
</div>
<%@include file="blocks/footer.jsp"%>