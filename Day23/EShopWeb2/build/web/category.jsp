<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.Category"%>
<%@page import="com.adroit.eshop.dao.CategoryDao"%>
<%@include file="blocks/header.jsp" %>

<%  
    CategoryDao cdao=new CategoryDao();
%>

<%  
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
                    <input type="text" onkeyup="check(this.value)" class="form-control" name="cname" placeholder="Category Name" required>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                    <input type="submit" value="Save" class="btn btn-primary ml-2">
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                </form>
            </div>
            <br>
            <b class='text-danger' id="cmsg"></b>
            <hr>
            
            <h2>Category List</h2>
            <table class="table table-hover">
                <tr>
                    <th>S.No.</th>
                    <th>Category Name</th>
                    <th>Operation</th>
                </tr>
                <%
                    int x=1;
                    for(Category cate:clist)
                    {
                %>
                <tr>
                    <td><%=x%></td>
                    <td><%=cate.getCateName()%></td>
                    <td>
                        <a href="updatecategory.jsp?cateid=<%=cate.getCateId()%>">
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
		url:"checkcate?txt="+txt,
		success:function(response){
			if(response==="true")
			{
			document.getElementById("cmsg").innerHTML="Category already exist";
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