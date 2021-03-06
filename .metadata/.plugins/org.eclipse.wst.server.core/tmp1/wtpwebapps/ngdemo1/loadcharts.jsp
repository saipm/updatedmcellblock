 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
        pageEncoding="ISO-8859-1" import="java.util.*,javax.sql.*,java.sql.*,java.awt.*,java.io.*"%> 
<html lang="en">
<head>
<style>
body{
color:"white";
}
</style>
<style>

 
  nav {
  margin: 20px;
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
  padding: 0 10px;
}
 
li:last-child {
  border-right: none;
}
 
li a {
  text-decoration: none;
  color: #3399ff;
  font: 15px/1 Helvetica, Verdana, sans-serif;
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
 <style>
    .moreinfo {
    	  display: inline-block;
    	} 
    	TD{font-family: Arial;
    	 font-size: 11pt;}
    </style>
  
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

     
     <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  -->
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script type="text/javascript">
    $( document ).ready(function() {
    	 var processed_json = new Array();
    	 var processed_json1 = new Array(); 
    	 var url = window.location.href.split('/');
   	  var baseUrl = url[0] + '//' + url[2]+"/"+url[3]+"/";
   	  alert("inside........")
    $.getJSON(baseUrl+'web/devicetests/devicecount/', function(data) {
    	var out=data;
    document.getElementById("devicecount").innerHTML="  "+out;
    });
    
    $.getJSON(baseUrl+'web/devicetests/testcount/', function(data) {
    	var out=data;
    document.getElementById("testcount").innerHTML="  "+out;
    });
    
    $.getJSON(baseUrl+'web/devicetests/errorcount/', function(data) {
    	var out=data;
    document.getElementById("errorcount").innerHTML="  "+out;
    });
    $.getJSON(baseUrl+'web/devicetests/stats/', function(data) {
    	
    
    	
    	
    	var tripass=data[1]-data[3];
    	var textpass=data[0]-data[2];
    	
        var name = ['Pass','Fail'];
  
        var data1 = [tripass,data[3]];
        var final1 = [];
        
        //var name1 = ['Pass','Fail'];
        var data2 = [textpass,data[2]];
        var final2 = [];
        
        for(var i=0; i < name.length; i++) {
        	final1.push({
                name: name[i],
                y: data1[i]			 
            }); 	   
        }    
        for(var i=0; i < name.length; i++) {
        	final2.push({
                name: name[i],
                y: data2[i]			 
            }); 	   
        }    
        Highcharts.setOptions({
		  //  colors: [/* '#50B432', '#ED561B', '#DDDF00', '#24CBE5', */ '#64E572', '#FF9655', '#FFF263','#6AF9C4'] 
		      colors: [/* '#4D4D4D','#5DA5DA','#FAA43A',  */'#60BD68','#F17CB0', '#B2912F', '#B276B2','#DECF3F', '#F15854']  
		   });
        
        Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
            return {
                radialGradient: {
                    cx: 0.5,
                    cy: 0.3,
                    r: 0.7
                },
                stops: [
                    [0, color],
                    [1, Highcharts.Color(color).brighten(-0.5).get('rgb')] // darken
                ]
            };
        });
        
    	
        $('#container1').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Trillian IM'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                location.href = this.options.url;
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                       /*  formatter: function() {
                             return this.name+":"+this.y;
                          }, */
                          style: {
                              color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                          },
                       // distance: -30
                      //  color:'white'
                    },
           /*  startAngle: -90,
            endAngle: 90,
            center: ['50%', '75%'] */
                }
            
            },
            series: [{
            	 data: [{
            		 name:"Pass",
                     y: tripass,
                     url: baseUrl+'table-data.jsp?query=trillianpass'
                 }, {
                	 name:"Fail",
                     y: data[3],
                     url: baseUrl+'table-data.jsp?query=trillianfail',
                     color:'#ff0000'		 
                 }]
            }]
        });
  	
        $('#container2').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Texting'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                location.href = this.options.url;
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        }
                    }
                }
            
            },
            series: [{
           	 data: [{
           		 name:"Pass",
                    y: textpass,
                    url:baseUrl+'table-data.jsp?query=textpass'
                }, {
               	 name:"Fail",
                    y: data[2],
                    url: baseUrl+'table-data.jsp?query=textfail',
                    color:'#ff0000'
                }]
           }]
        });
  	 
 
    });
    
    });
    </script>
<style type="text/css" media="screen">
            #carbonads {
              padding: 20px;
            }

            #carbonads .carbon-img {
              clear: both;
              float: left;
              background: #fff;
              padding: 10px;
            }

            #carbonads .carbon-img img {
              display: block;
            }

            #carbonads .carbon-text {
              clear: both;
              display: block;
              padding: 10px 0;
            }

            #carbonads .carbon-poweredby {
              display: block;
              color: #ADB0BA;
              font-size: .9em;
            }
          </style>

    <title> MCELLBLOCK</title>
    <!--REQUIRED STYLE SHEETS-->
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
   <!--  ANIMATED FONTAWESOME STYLE CSS -->
    <!-- <link href="assets/css/font-awesome-animation.css" rel="stylesheet" />  -->
     <link href="css/session.css" rel="stylesheet" /> 
    <link href="css/elusive-webfont.css" rel="stylesheet" />
    <link href="css/pages.css" rel="stylesheet" />
    <link href="css/sunburst.css" rel="stylesheet" />
       <!-- CUSTOM STYLE CSS -->
    <!-- <link href="assets/css/style.css" rel="stylesheet" /> -->
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>

    
      <div class="contentWrap">
        <div id="content">
          <header>
        
          <nav>
            <ul class="commonNav" id="main-nav">
            
            <li><a href="index.html#/testcase-list">Test cases</a></li>
            
              
                <li class="selected"><a href="/user/dashboard/"><font color="#3399ff"><bold>Dashboard</bold></font></a></li>
                <li><a href="index.html">Devices</a></li>
                
                
              
            </ul> 
            </nav>
            <span id="shadow"></span>
          </header>
          
        </div> 
      </div> 

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
</body>
</html>