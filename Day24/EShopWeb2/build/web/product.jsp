<%@page import="com.adroit.eshop.dto.Category"%>
<%@page import="com.adroit.eshop.dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.adroit.eshop.dto.Product"%>
<%@page import="com.adroit.eshop.dao.ProductDao"%>
<%@include file="blocks/header.jsp" %>

<%  
    ProductDao pdao=new ProductDao();
    CategoryDao cdao=new CategoryDao();
%>

<%  
    String result=request.getParameter("res");
    String resultmsg="";
    if(result!=null && result.equals("true")){resultmsg="Category Saved!";}
    if(result!=null && result.equals("false")){resultmsg="Category Not Saved!";}
    //*****************************************************************************
    List<Product> plist=pdao.list();   
    List<Category> clist=cdao.list();
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Add New Product</h1>
            <br>
            <form action="saveproduct" method="POST">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <input type="text" class="form-control"
                            name="pname" placeholder="Product Name" required>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <input type="text" class="form-control"
                            name="company" placeholder="Product Company" required>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <input type="number"  class="form-control"
                           name="price" placeholder="Product Price" required>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <select name="category" onchange="getSubCate(this.value)" class="form-control" required>
                            <option value=''>Choose Category</option>
                            <% for(Category ob:clist){%>
                            <option value='<%=ob.getCateId()%>'> <%=ob.getCateName()%></option>
                            <% } %>
                        </select>         
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <select id='subcate' name="subcategory" class="form-control" required>
                            <option value=''>Choose Sub-Category</option>
                        </select>      
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <input type="file" name="pic" class='form-control'>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <input type="submit" value="Save" class="btn btn-primary ml-2">
                    </div>
                </div>
            </form>
                
               
            <br>
            <b class='text-danger' id="cmsg"><%=resultmsg%></b>
            <hr>
            
            <h2>Product List</h2>
            <table class="table table-hover">
                <tr>
                    <th>S.No.</th>
                    <th>Product Name</th>
                    <th>Company</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Sub-Category</th>
                    <th>Status</th>
                </tr>
                <% int x=1; for(Product ob:plist){%>
                    <tr>
                        <td><%=x%></td>
                        <td><%=ob.getProdName()%></td>
                        <td><%=ob.getCompany()%></td>
                        <td><%=ob.getPrice()%></td>
                        <td><%=ob.getCategory()%></td>
                        <td><%=ob.getSubcategory()%></td>
                        <td><%=ob.isIsActive()%></td>
                    </tr>
                <% x++; } %>      
            </table>
        </div>
</div>
                
        <script>
            function getSubCate(category)
            {
                if(category.length>0)
                {
                    $.ajax({
                    url:"getsubcate",
                    type:"POST",
                    data:{cid:category},
                    success:function(response)
                    {
                        var arr=JSON.parse(response);
                        var finalData="<option value=''>Choose Sub-Category</option>";
                        for(x=0;x<arr.length;x++)
                        {
                            var ob=arr[x];
                            var op="<option value="+ob.subcateId+">";
                            op+=ob.subcateName;
                            op+="</option>";
                            finalData+=op;
                        } //for end
                        $("#subcate").html(finalData);
                    }, //success end
                    error:function(err)
                        {
                        alert(err);
                        }
                    }); //ajax end
                } //if end
                else
                {
                    alert("Please Select Any One Category!");
                }
            } //function end
            
        </script>
        
<%@include file="blocks/footer.jsp"%>