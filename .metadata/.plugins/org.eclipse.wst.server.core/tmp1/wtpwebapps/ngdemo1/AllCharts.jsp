
<html>
<head>
 <style>
 li {
    display: inline;
}
    .moreinfo {
    	  display: inline-block;
    	} 
    	TD{font-family: Arial;
    	 font-size: 11pt;}
    </style>
    <!-- <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script> -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="http://code.highcharts.com/modules/exporting.js"></script>
    
    
    <script type="text/javascript">
    var deviceId;
    var processed_json = new Array(); 
    var processed_json1 = new Array();  
    $( document ).ready(function() {
    	var processed_json = new Array();
   	 var processed_json1 = new Array(); 
   	 var url = window.location.href.split('/');
  	  var baseUrl = url[0] + '//' + url[2]+"/"+url[3]+"/";
  	 // alert("Base Url:"+baseUrl);
  	var pathname = window.location.pathname; // Returns path only
  	var url1      = window.location.href; 
  var testcase = url1.substr(url1.indexOf("=") + 1);
  var testcase1 = url1.substr(url1.indexOf("=") + 1);
  testcase1 = testcase1.replace(/%20/g, ' ');
  document.getElementById("testcaseid").innerHTML=testcase1;
 //   alert(testcase+"sdjkdsjd");
  
   
   	 $.getJSON(baseUrl+'web/devicetests/statscircle/'+testcase, function(data) {
   		// alert(data);
   		 
       $('#Trillian').highcharts({
           chart: {
               plotBackgroundColor: null,
               plotBorderWidth: null,
               plotShadow: false,
               type: 'pie'
           },
           title: {
               text: "Pass/Fail"
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
                               //location.href = this.options.url;
                           }
                       }
                   },
                   dataLabels: {
                       enabled: true,
                         style: {
                             color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                         },
                   },
               }
           
           },
           series: [{
           	 data: [{
           		 name:"Pass",
                    y: data[0],
                    /* url: baseUrl+'table-data.jsp?query=trillianpass', */
                    		color:'#009900'
                }, {
               	 name:"Fail",
                    y: data[1],
                    /* url: baseUrl+'table-data.jsp?query=trillianfail', */
                    color:'#ff0000'		 
                }]
           }]
       }); 
   	 });
       
   
   
   $.getJSON(baseUrl+'web/devicetests/statspassfail/'+testcase+"/"+"Pass", function(data1) {
 	  for (i = 0; i < data1.length; i++){
           processed_json1.push([data1[i].app, parseInt(data1[i].device)]);
       	}
 	  Highcharts.setOptions({
 		      colors: ['#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263','#6AF9C4'] 
 		      /*colors: ['#4D4D4D','#5DA5DA','#FAA43A', '#60BD68','#F17CB0', '#B2912F', '#B276B2','#DECF3F', '#F15854']*/ 
 		   });
 	  var chart1;
 	  chart1= $('#trillianpass').highcharts({
            chart: {
            	renderTo:"container",
                type: "area"
                
            },
            title: {
                text: "Testcase Pass trend",
                //margin:20
            },
            xAxis: {
                tickInterval: 1,
                labels: {
                    enabled: true,
                    formatter: function() {
                        return processed_json1[this.value];
                    },
                }
            },
            series: [{
            name:"Pass",
            data:processed_json1,
        }] 
    }); 
   }); 
   
   $.getJSON(baseUrl+'web/devicetests/statspassfail/'+testcase+"/"+"Fail", function(data1) {
	 	  for (i = 0; i < data1.length; i++){
	           processed_json1.push([data1[i].app, parseInt(data1[i].device)]);
	       	}
	 	  Highcharts.setOptions({
	 		      colors: ['#ff0000'] 
	 		      /*colors: ['#4D4D4D','#5DA5DA','#FAA43A', '#60BD68','#F17CB0', '#B2912F', '#B276B2','#DECF3F', '#F15854']*/ 
	 		   });
	 	  var chart1;
	 	  chart1= $('#trillianfail').highcharts({
	            chart: {
	            	renderTo:"container",
	                type: "area"
	                
	            },
	            title: {
	                text: "Testcase Fail trend",
	                //margin:20
	            },
	            xAxis: {
	                tickInterval: 1,
	                labels: {
	                    enabled: true,
	                    formatter: function() {
	                        return processed_json1[this.value];
	                    },
	                }
	            },
	            series: [{
	            name:"Fail",
	            data:processed_json1,
	        }] 
	    }); 
	   }); 
   
   });
 
    </script>
</head>
<body>

  <center><h2 id="testcaseid"></h2></center>
   <div align="center" class="moreinfo">
     <!-- <span id="container1" style="margin-left:100px;height:350px;width:300px;"></span> -->
     <span class="moreinfo" id="trillianpass" style="min-width: 500px; height: 400px; margin: 0 auto"></span>
     <span class="moreinfo" id="trillianfail" style="min-width: 500px; height: 400px; margin: 0 auto"></span> </br>
     </br>
     <span class="moreinfo"  id="Trillian" style="align:center;min-width: 300px; height: 400px;"></span>
   </div>
</body>
</html>