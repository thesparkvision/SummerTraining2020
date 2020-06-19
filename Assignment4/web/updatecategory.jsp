<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.Category"%>
<%@page import="com.adroit.eshop.dao.CategoryDao"%>
<%@include file="blocks/header.jsp" %>

<%
  int cid=Integer.parseInt(request.getParameter("cateid"));
 
  CategoryDao cdao=new CategoryDao();
  Category category=cdao.get(cid);

  if(category==null)
  {
     response.sendRedirect("category.jsp");
  }
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Update Category</h1>
            <br>
            <div class="row">
                <form action="updatecategory" method="POST">
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                   <input type="text" onkeyup="check(this.value)" class="form-control" name="cname" value="<%=category.getCateName()%>" placeholder="Category Name" required>
                   <input type="hidden" name="cid" value="<%=category.getCateId()%>" required>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4">
                    <input type="submit" value="Update" class="btn btn-primary ml-2">
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                </form>
            </div>
            <br>
            <b class='text-danger' id="cmsg"></b>
            <hr>
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