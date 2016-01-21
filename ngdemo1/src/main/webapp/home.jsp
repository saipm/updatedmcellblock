<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
        pageEncoding="ISO-8859-1" import="java.util.*,javax.sql.*,java.sql.*,java.awt.*,java.io.*"%> 
<html lang="en">
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	        $("#myModal").modal();
	});
</script>

  <title>MCellBlock</title>
  <style>
   .logo {
      float:left;
      width:20%;
      height:12%;
    }
    .devices {
      float:left;
      width:20%;
      height:81%;
    }
    .menu {
      width:78%;
      height:12%;
    }
    .mainContent {
      float:left;
      width:40%;
      height:80%;
    }
    .mainContent1 {
      width:22%;
      height:80%;
    }
     .mainContent2 {
      width:15%;
      height:80%;
    }
    .footer {
    float:left;
      width:98.2%;
      height:8%;
    }
  </style>
</head>
<body>

<iframe class="logo block" frameborder="0" scrolling="no"
   src="img/bootstrap/logo_165565_20150921051734.png" name="imgbox" id="imgbox">
</iframe>
  <iframe class="menu block"  frameborder="0" scrolling="no" src="menu.jsp">
 
  </iframe>
   <iframe class="devices"   frameborder="0"  src="partials/devices.html">
   </iframe>
  <iframe class="mainContent"  name="mainContent" frameborder="0" scrolling="no" src="homegraphs.jsp">
  </iframe>
   <iframe class="mainContent1" frameborder="0" scrolling="no" src="container1.jsp"></iframe>
    <iframe class="mainContent2" frameborder="0" scrolling="no"  src="container2.jsp"></iframe>
     <iframe class="footer"  frameborder="0" scrolling="no" src="footer.jsp" ></iframe>
     <!-- style="border: 3px solid #EEE;" -->
  
    <div class="container">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>


<script src="js/bootstrap/bootstrap.js"></script>

<script src="lib/angular/angular.js"></script>
<script src="lib/angular/angular-resource.js"></script>

<!-- AngularJS App Code ==================================================== -->
<script src="js/app.js"></script>
<script src="js/services.js"></script>
<script src="js/controllers.js"></script>
<script src="js/filters.js"></script>
<script src="js/directives.js"></script>
<script src="js/highcharts.js"></script>
</html>

