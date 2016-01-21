<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
@import url('http://fonts.googleapis.com/css?family=Amarante');

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  outline: none;
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
html { overflow-y: scroll; }
body { 
  background: #eee url('http://i.imgur.com/eeQeRmk.png'); /* http://subtlepatterns.com/weave/ */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
  font-size: 80.5%;
  font-weight:bold;
  line-height: 1;
  color: #585858;
  padding: 22px 10px;
  padding-bottom: 55px;
}

::selection { background: #5f74a0; color: #fff; }
::-moz-selection { background: #5f74a0; color: #fff; }
::-webkit-selection { background: #5f74a0; color: #fff; }

br { display: block; line-height: 1.6em; } 

article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }
ol, ul { list-style: none; }

input, textarea { 
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  outline: none; 
}

blockquote, q { quotes: none; }
blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }
strong, b { font-weight: bold; } 

table { border-collapse: collapse; border-spacing: 0; border:2;}
img { border: 0; max-width: 100%; }

h1 { 
  font-family: 'Amarante', Tahoma, sans-serif;
  font-weight: bold;
  font-size: 2.6em;
  line-height: 1.7em;
  margin-bottom: 10px;
  text-align: center;
  color:#3399ff;
}


/** page structure **/
#wrapper {
  display: block;
  width: 1250px;
  background: #fff;
  margin: 0 auto;
  padding: 10px 17px;
  -webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);
}

#keywords {
  margin: 0 auto;
  font-size: 1.2em;
  margin-bottom: 15px;
}


#keywords thead {
  cursor: pointer;
  background: #c9dff0;
}
#keywords thead tr th { 
  font-weight: bold;
  padding: 12px 30px;
  padding-left: 42px;
}
#keywords thead tr th span { 
  padding-right: 20px;
  background-repeat: no-repeat;
  background-position: 100% 100%;
}

#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {
  background: #acc8dd;
}

#keywords thead tr th.headerSortUp span {
  background-image: url('http://i.imgur.com/SP99ZPJ.png');
}
#keywords thead tr th.headerSortDown span {
  background-image: url('http://i.imgur.com/RkA9MBo.png');
}


#keywords tbody tr { 
  color: #555;
}
#keywords tbody tr td {
  text-align: center;
  padding: 15px 10px;
}
#keywords tbody tr td.lalign {
  text-align: left;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script src="http://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">
var deviceId;
var processed_json = new Array(); 
var processed_json1 = new Array();  
$( document ).ready(function() {
    console.log( "document loaded" );	
    	var pathname = window.location.pathname; // Returns path only
    	var url      = window.location.href; 
  deviceId = url.substr(url.indexOf("=") + 1);
  //alert(deviceId);
  document.getElementById("test").innerHTML=deviceId;
  var url = window.location.href.split('/');
  var baseUrl = url[0] + '//' + url[2]+"/"+url[3]+"/";
  $.getJSON(baseUrl+'web/devicetests/querydata/'+deviceId, function(data) {
	  
	  if(deviceId=='trillianpass'){
		  var head="<h1>Trillian Instant Messaging Pass Testcases Report</h1>";
	  }
	  if(deviceId=='trillianfail'){
		  var head="<h1>Trillian Instant Messaging Fail Testcases Report</h1>";
	  }
	  if(deviceId=='textpass'){
		  var head="<h1>Text Messaging Pass Testcases Report</h1>";
	  }
	  if(deviceId=='textfail'){
		  var head="<h1>Text Messaging Fail Testcases Report</h1>";
	  }
	  
	  var out = "<div id='wrapper'>"+head+"<table id='keywords' cellspacing='0' cellpadding='0'> "+
	  "<thead><tr><th>UserId</th><th>DeviceId</th><th>Date and Time taken</th><th>Error</th></tr></thead>";
	  for(var i=0;i<data.length;i++){
		  out=out+"<tr><td>"+data[i].userid+"</td>"+"<td>"+data[i].device+"</td><td>"+data[i].date+", "+data[i].time+" ms"+"</td>"+"<td width='20%'>"+data[i].errormsg+"</td></tr>"
	  }
	  out=out+"</table></div>";
	  document.getElementById("test").innerHTML=out;
  });
  
});
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status Report</title>
</head>

<body>
<div id="test">
</div>

</body>
</body>
</html>