<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.SubCategory"%>
<%@page import="com.adroit.eshop.dao.SubCategoryDao"%>
<%@include file="blocks/header.jsp" %>

<%
  int scid=Integer.parseInt(request.getParameter("id"));
 
  SubCategoryDao cdao=new SubCategoryDao();
  SubCategory ob=cdao.get(scid);

  if(ob==null)
  {
     response.sendRedirect("subcategory.jsp");
  }
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Update Sub-Category</h1>
            <br>
            <div class="row">
                <form action="updatesubcategory" method="POST">
                <div class="col-lg-1 col-md-1 col-sm-1"></div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                   <input type="text" onkeyup="check(this.value)" class="form-control" name="scname" value="<%=ob.getSubcateName()%>" placeholder="Sub-Category Name" required>
                   <input type="hidden" name="scid" value="<%=ob.getSubcateId()%>" required>
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
		url:"checksubcate?txt="+txt,
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