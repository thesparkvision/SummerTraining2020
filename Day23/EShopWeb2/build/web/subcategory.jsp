<%@page import="com.adroit.eshop.dto.Category"%>
<%@page import="com.adroit.eshop.dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.SubCategory"%>
<%@page import="com.adroit.eshop.dao.SubCategoryDao"%>
<%@include file="blocks/header.jsp" %>

<%  
    SubCategoryDao subcateDao=new SubCategoryDao();
    CategoryDao cateDao=new CategoryDao();
%>

<%  
    //*****************************************************************************
    List<SubCategory> subcateList=subcateDao.list();   
    List<Category> cateList=cateDao.list();
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Add New Sub Category</h1>
            <br>
            <div class="row">
                <form action="savesubcategory" method="POST">
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                    <input type="text" onkeyup="check(this.value)" class="form-control" name="subcatename" placeholder="SubCategory Name" required>
                </div>
                 <div class="col-lg-4 col-md-4 col-sm-4">
                     <select class="form-control" name="category" required>
                         <option value=''>Choose Category</option>
                         <% for(Category cate:cateList){%>
                            <option value='<%=cate.getCateId()%>'><%=cate.getCateName() %></option>
                         <% } %>
                     </select>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2">
                    <input type="submit" value="Save" class="btn btn-primary ml-2">
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                </form>
            </div>
            <br>
            <b class='text-danger' id="cmsg"></b>
            <hr>
            
            <h2>Sub Category List</h2>
            <table class="table table-hover">
                <tr>
                    <th>S.No.</th>
                    <th>Sub Category Name</th>
                    <th>Operation</th>
                </tr>
                <%
                    int x=1;
                    for(SubCategory cate:subcateList)
                    {
                %>
                <tr>
                    <td><%=x%></td>
                    <td><%=cate.getSubcateName()%></td>
                    <td>
                        <a href="updatesubcategory.jsp?id=<%=cate.getSubcateId()%>">
                            <b class='btn btn-info'>Update</b>
                        </a>
                    </td>
                </tr>
                <% x++;} %>
            </table>
        </div>
</div>
                
        <script>
          function check(txt){
                $.ajax({
		url:"checksubcate?txt="+txt,
		success:function(response){
			if(response==="true")
			{
			document.getElementById("cmsg").innerHTML="SubCategory already exist";
			}
			else
			{
			document.getElementById("cmsg").innerHTML="";
			}
		},
		error:function(error){
			alert(error);	
		}
	    }); 
            }
        </script>
<%@include file="blocks/footer.jsp"%>