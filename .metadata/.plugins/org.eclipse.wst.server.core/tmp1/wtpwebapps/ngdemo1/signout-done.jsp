<html>
<head>
<script>
history.pushState({ page: 1 }, "title 1", "#nbb");
window.onhashchange = function (event) {
    window.location.hash = "nbb";

};
</script>
</head>
<body>
 <%-- <%
 
  request.logout();
 session.invalidate();
  
 %> --%>
 
 
  <h1><a href="dummynew.jsp"> <img src="img/bootstrap/mobile-integration-workgroup-squarelogo.png"  border="0" alt="MIW" style=" float : right; margin : auto ; height:80px;width:'80px;'"/></a></h1>
  
  
  
  
    <h2 
    
    style= " left: 0;
    line-height: 200px;
    margin: auto;
    margin-top: -100px;
    position: absolute;
    top: 50%;
    width: 100%;
    text-align: center;"
    
    > You are now signed out.</h2>
    
   
 
 
 
 
 
 
 
 
 
</body>
</html>