<%@include file="blocks/header.jsp" %>

<%
  String pid=request.getParameter("pid");  
%>

<div class="tm-right-column">
	<div class="tm-content-div">
            <h1>Flip Product Status</h1>
            <br>
            <center>
                <h3>Confirm Flipping?</h3>
                <br/>
                <form action="flipproductstatus" method="POST">
                    <input type="hidden" value="<%=pid%>" name="pid">
                    <button type="submit"><b>Yes</b></button>
                </form>
                <br>
                <button onclick="back()" ><b>No</b></button>
            </center>    
        </div>
</div>

    <script> 
        function back()
        {
         document.location.href = 'product.jsp';   
        }
    </script>   
    
<%@include file="blocks/footer.jsp"%>