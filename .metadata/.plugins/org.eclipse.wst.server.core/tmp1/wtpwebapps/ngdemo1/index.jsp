<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
        pageEncoding="ISO-8859-1" import="java.util.*,javax.sql.*,java.sql.*,java.awt.*,java.io.*"%> 
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">
$(document).ready(function() { 
	//alert("inside");
    $('#pageContent').load('loadcharts.jsp');
});
</script>

<style>
body{
font-family: "Open Sans",sans-serif;
}
</style>
<style>
#logo { width:200px; height: 50px; background:white; float:left; border: 1px solid #e6e6e6;border-radius:1px;}
#menu { width:1065px; height: 50px; float:left;border: 1px solid #e6e6e6;border-radius:1px;background-color: #4d4d4d; }
#graphs { width:500px; height: 630px; background:white;border: 1px solid #4d4d4d;border-radius:1px;}
#devices { width:200px;height: 580px; background:white;float:left;border: 1px solid #e6e6e6;border-radius:1px;}
#right1 {min-height:580px;background:white;width:620px;float:left;border: 1px solid #e6e6e6;border-radius:1px;}
#right2 {min-height:580px;background:white;width:280px;float:left;border: 1px solid #e6e6e6;border-radius:1px;}
#right3 {min-height:580px;background:white;width:160px;float:left;border: 1px solid #e6e6e6;border-radius:1px;}
#box {background-color: lightgrey; width: 300px;padding: 5px;border: 5px solid #e6e6e6;margin: 5px;}
#rcorners1 {   border-radius: 25px;background: #73AD21; padding: 20px; width: 200px;height: 150px;}
.break { clear:both }
#below { height:25px; width:1265px; background:white;border: 1px solid #e6e6e6; }
span{
font-family: ubuntu;
font-size:13.5px;
}
</style>
<style>

.divborder{
border: 0.5px solid #e6e6e6;height:25px;background-color: #4d4d4d;color: #e6e6e6;
}
 ul {
  /* //overflow: auto; */
  list-style-type: none;
}

li {
  height: 15px;
  float: left;
  margin-right: 0px;
  border-right: 1px solid #aaa;
  padding: 0 5px;
}
 
li:last-child {
  border-right: none;
}
 
li a {
  text-decoration: none;
  color: #3399ff;
  font: 13px/1 Helvetica, Verdana, sans-serif;
  font-color:#3399ff;
  text-transform: uppercase;
 
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -ms-transition: all 0.5s ease;
  transition: all 0.5s ease;
}
 
li a:hover {
  color: #666;
}
 
li.active a {
  font-weight: bold;
  color: #333;
}
</style>
 <link href="assets/css/bootstrap.css" rel="stylesheet" />
 <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
 <link href="css/session.css" rel="stylesheet" /> 
 <link href="css/elusive-webfont.css" rel="stylesheet" />
 <link href="css/pages.css" rel="stylesheet" />
 <link href="css/sunburst.css" rel="stylesheet" />
 <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="logo">
<img src="img/bootstrap/logo_165565_20150921051734.png" alt="MIW" style="width:200px;height:50px;">
</div>
<div id="menu">
</br>
<span style="margin-left:15px; color: #e6e6e6;">View</span>
<span style="margin-left:608px; color: #e6e6e6;">Search</span>
<span style="margin-left:25px; color: #e6e6e6;">Configuration</span>
<span style="margin-left:25px; color: #e6e6e6;">User</span>
<span style="margin-left:25px; color: #e6e6e6;">Notification</span>
</div>
<div>
<span id="devices">
<div style="margin-bottom:4px;border: 1px solid #e6e6e6;height:25px;background-color: #4d4d4d;color: #e6e6e6;"><b>&nbsp;Devices</b></div>
<div style="margin-bottom:392px;"></div>
<div class="divborder">&nbsp;Groups</div>
<div class="divborder">&nbsp;Testing/Tests</div>
<div class="divborder">&nbsp;Reporting</div>
<div class="divborder">&nbsp;Admin</div>
<div class="divborder">&nbsp;Statistics</div>
<div class="divborder">&nbsp;Help</div>
</span>
<span id="right1">
<!-- <div id="pageContent"> -->

      <div class="contentWrap" style="margin-left:260px;">
        <div id="content">
          <!-- <header> -->
          <nav>
            <ul class="commonNav" id="main-nav">
            <li><a href="index.html#/testcase-list">Test cases</a></li>
            <li class="selected"><a href="/user/dashboard/"><font color="#3399ff"><bold>Dashboard</bold></font></a></li>
            <li><a href="index.html">Devices</a></li>
            <li><a href="index.html">Tests</a></li>
            </ul> 
            </nav>
            <span id="shadow"></span>
         <!--  </header> -->
        </div> 
      </div> 
<!-- 
</div> -->

</span>
<span id="right2">
<div style="border: 1px solid #e6e6e6;height:110px;">Reporting</div>
<div style="border: 1px solid #e6e6e6;height:110px;">Admin</div>
<div style="border: 1px solid #e6e6e6;height:110px;">Statistics</div>
<div style="border: 1px solid #e6e6e6;height:110px;">Statistics</div>
<div style="border: 1px solid #e6e6e6;height:130px;">Statistics</div>
</span>
<span id="right3"></span>
</div>
<div class="break"></div>
<div id="below">
<span  style="font-size:10px; margin-bottom:2px;"><center>MCellBlock is produced by Mobile Integration Workgroup</center></span>
</div>
</body>

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
