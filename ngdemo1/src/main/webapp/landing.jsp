<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
        pageEncoding="ISO-8859-1" import="java.util.*,javax.sql.*,java.sql.*,java.awt.*,java.io.*"%> 
<!doctype html>
<html ng-app="plunker">
  <head>
  <script data-require="angular.js@1.2.8" data-semver="1.2.8" src="https://code.angularjs.org/1.2.8/angular.js"></script>
    <link data-require="bootstrap@*" data-semver="3.2.0" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css" />
    <link data-require="bootstrap-css@~3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link data-require="font-awesome@*" data-semver="4.2.0" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <script data-require="ui-bootstrap@*" data-semver="0.11.0" src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.min.js"></script>
   <!--  <link rel="stylesheet" href="style.css" />
    <script src="example.js"></script>
    <script src="angular.js"></script>
    <script src="ui-bootstrap-tpls-0.10.0.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css"> 
    <script src="example.js"></script>
    <script src="js/controllers.js"></script> -->
    <script src="example.js"></script>
     <script src="moment.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css"> 
    <script type="text/javascript">
    
$(document).ready(function() { 
	   $("#right").load("dropdown.html") 
	  });
</script>
    <!-- <link href="bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome.min.css" rel="stylesheet"/> -->
  
  <style>
.circle{
	border-radius: 50%;
	margin: 0.15em;
	font-size: 3em;
	}
.fa-android{
	background: #4099FF;
	color: #FFFFFF;
  padding: 0.05em 0.07em;
	}
.fa-pie-chart{
	background: #4099FF;
	color: #FFFFFF;
  padding: 0.05em 0.07em;
	}
.fa-file-o{
	background: #4099FF;
	color: #FFFFFF;
  padding: 0.05em 0.07em;
	}
	.fa-search{
	background: #4099FF;
	color: #FFFFFF;
  padding: 0.05em 0.07em;
	}
  #wrapper {
  font: 20px Calibri;
  width: 100px;
  margin: 0 auto;
}
  body{
  background-color:white;
  }
  .dropdown-submenu{position:relative;}
.dropdown-submenu>.dropdown-menu{top:0;left:100%;margin-top:-6px;margin-left:-1px;-webkit-border-radius:0 6px 6px 6px;-moz-border-radius:0 6px 6px 6px;border-radius:0 6px 6px 6px;}
.dropdown-submenu:hover>.dropdown-menu{display:block;}
.dropdown-submenu>a:after{display:block;content:" ";float:right;width:0;height:0;border-color:transparent;border-style:solid;border-width:5px 0 5px 5px;border-left-color:#cccccc;margin-top:5px;margin-right:-10px;}
.dropdown-submenu:hover>a:after{border-left-color:#ffffff;}
div:hover {
    background-image:url('arrow.gif');
}


/* div#special {
    accordion: inherit;
} */
.dropdown-submenu.pull-left{float:none;}.dropdown-submenu.pull-left>.dropdown-menu{left:-100%;margin-left:10px;-webkit-border-radius:6px 0 6px 6px;-moz-border-radius:6px 0 6px 6px;border-radius:6px 0 6px 6px;}
  </style>  
  <style>
  body{
font-family:Arial, Helvetica, sans-serif; 
font-size:17px;
}
.info, .success, .warning, .error, .validation {
border: 1px solid;
margin: 10px 0px;
padding:15px 10px 15px 50px;
background-repeat: no-repeat;
background-position: 10px center;
}
.cwhite{
color: white;
}
.info {
color: #00529B;
background-color: #BDE5F8;
background-image: url('https://cdn4.iconfinder.com/data/icons/32x32-free-design-icons/32/Info.png');
}
.success {
color: #4F8A10;
background-color: #DFF2BF;
background-image:url('https://cdn4.iconfinder.com/data/icons/32x32-free-design-icons/32/Ok.png');
}
.warning {
color: #9F6000;
background-color: #FEEFB3;
background-image: url('');
}
.error {
color: #D8000C;
background-color: #FFBABA;
background-image: url('https://cdn4.iconfinder.com/data/icons/32x32-free-design-icons/32/Cancel.png');
}

.div-table{
  display:table;         
  width:1000px;;         
  /* background-color:#eee;  */        
  border:1px solid  #666666;         
  border-spacing:5px;/*cellspacing:poor IE support for  this*/
  margin-top:10px;
}
.div-table-row{
  display:table-row;
  width:auto;
  clear:both;
}
.div-table-col{
  float:left;/*fix for  buggy browsers*/
  display:table-column;         
  width:300px;         
  /* background-color:#ccc; */  
}
    body{
 /*  background:#567; */
  font-family:'Open Sans',sans-serif;
}

tr.spaceUnder > td
{
  padding-bottom:2em;
}

tr.spaceUpper > td
{
  padding-top: 2em;
}
.tabhead{
font-size: 1.1em;
    text-align: left;
    padding-top: 5px;
    padding-bottom: 10px;
    font-weight:bold;
    background-color:#DCDCDC;
    color: Black;
    margin-left:10px;
}
.form{
    padding:20px
}
.cancel{
    
    padding:20px;
}
html, body{
    background-color: white;
}
  </style>
  </head>
  <body ng-controller="DevicesCtrl"  data-ng-init="init('<%=session.getAttribute("name")%>')">
  <%-- <p> <%=session.getAttribute("name")%></p> --%>
  <div id="header">
    <nav class="navbar navbar-default" role="navigation">
      <div class="navbar-header" style="height:60px;">

        <button type="button" class="navbar-toggle" ng-init="navCollapsed = true" ng-click="navCollapsed = !navCollapsed">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="" ng-click="setActive('default')"><b><span class="cwhite">MCellBlock</span></b>&nbsp;&nbsp;</a>
      </div>

      <div style="background-color:	#599cff;" class="collapse navbar-collapse" ng-class="!navCollapsed && 'in'" ng-click="navCollapsed=true">
      
        <ul class="nav navbar-nav">
        <%-- <div ng-show="usertype=='SU' || usertype=='AU'> --%>
          <li ng-show="usertype=='SU' || usertype=='AU'" class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" ng-controller="DevicesCtrl"  data-ng-init="init('<%=session.getAttribute("name")%>')"><span class="cwhite">System Configuration <b class="caret"></b></span></a>
             <ul class="dropdown-menu">
            <!--  <li><a href="www.google.com">test</a></li> -->
            <li>  <a href="catcrud.html" target="_blank" >User Category</a></li>
           <!--  <li class="divider"></li> -->
            <li>  <a href="deptcrud.html" target="_blank" >Department</a></li>
            <!-- <li class="divider"></li> -->
            <li>  <a href="desigcrud.html" target="_blank">Designation</a></li>
            <!-- <li class="divider"></li> -->
            <li>  <a href="groupcrud.html" target="_blank">User Group</a></li>
           <!--  <li class="divider"></li> -->
            <li>  <a href="testcasecrud.html" target="_blank" >Test Scripts</a></li>
           <!--   <li class="divider"></li>
 -->            <li>  <a href="usercrud.html" target="_blank">User Profile</a></li>
            <!--  <li class="divider"></li> -->
            <li>  <a href="grouptestcrud.html" target="_blank">Test Groups</a></li>
     <!--  <li class="dropdown-submenu" style="margin-left:20px;margin-bottom:5px;cursor:pointer;" ng-repeat="testcase in testcases">{{testcase.testcase}} -->
      <li class="divider"></li>
      </ul>
          </li>
         <!--  </div> -->
        
          <!-- <li><a href="#" ng-click="setActive('reports')"><span class="cwhite">Reports</span></a></li> -->
           <li class="dropdown">
          <a href="#" class="dropdown-toggle"><span class="cwhite">Reports <b class="caret"></b></span></a>
			    <ul class="dropdown-menu">
			    <li style="cursor:pointer;margin-left:5px;">
			    <a href="" ng-click="setActive('reports')">All Reports</a></li>
			   <!--  <li style="cursor:pointer;margin-left:5px;">
			    <a href="" ng-click="setActive('reportsdate')">Reports by date</a></li> -->
			   <!--  <li class="divider"></li>
			     <li class="dropdown-submenu" style="cursor:pointer;" ng-repeat="devicePerModel in devicesToFilter() | filter:filterDevices">
			        <a href="" href="" ng-click="setActive(devicePerModel.brand)" ng-model="devicemodel"> {{devicePerModel.brand}} </a>	
			        <ul class="dropdown-menu">
			        	<li ng-repeat="device in devices | filter:{brand: devicePerModel.brand}"><a href="#">{{device.device}}</a></li>
			    </ul> -->
			    </ul>
               </li>
          <!-- class="active" -->
          <li class="dropdown">
          <a href="#" class="dropdown-toggle"><span class="cwhite">Devices <b class="caret"></b></span></a>
			    <ul class="dropdown-menu">
			    <li style="cursor:pointer;margin-left:5px;">
			    <a href="" ng-click="setActive('devicegroups')">All devices</a></li>
			    <li style="cursor:pointer;margin-left:5px;">
			    <a href="" ng-click="setActive('deviceprops')">Device Properties</a></li>
			   <!--  <li class="divider"></li>
			     <li class="dropdown-submenu" style="cursor:pointer;" ng-repeat="devicePerModel in devicesToFilter() | filter:filterDevices">
			        <a href="" href="" ng-click="setActive(devicePerModel.brand)" ng-model="devicemodel"> {{devicePerModel.brand}} </a>	
			        <ul class="dropdown-menu">
			        	<li ng-repeat="device in devices | filter:{brand: devicePerModel.brand}"><a href="#" ng-click="showdetails(device.device)">{{device.device}}</a></li>
			    </ul> -->
			    </ul>
               </li>
              <!--  <li class="divider"></li>
              </ul>
             </li>
  
              </ul> 
                <ul class="nav navbar-nav"> -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" ng-controller="DevicesCtrl"  data-ng-init="init('<%=session.getAttribute("name")%>')"><span class="cwhite">Testcases <b class="caret"></b></span></a>
             <ul class="dropdown-menu">
              <!-- <li>  <a href="" ng-click="setActive('testcasemapping')">Testcase Mapping</a></li>  -->
             <li>  <a href="" ng-click="setActive('newtestcase')">All Testcases</a></li>
            <!-- li class="divider"></li> -->
    <!--   <li class="dropdown-submenu" style="margin-left:10px;margin-bottom:5px;cursor:pointer;" ng-repeat="testcase in testcases"><a href="#" ng-click="setActive('testcase');setTestcase(testcase.testcase)">{{testcase.testcase}}</a></li> -->
      <li class="divider"></li>
      </ul>
          </li>
          
     <!--    </ul>
              <ul class="nav navbar-nav"> -->
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" ng-controller="DevicesCtrl"  data-ng-init="init('<%=session.getAttribute("name")%>')"><span class="cwhite">Groups <b class="caret"></b></span></a>
          <!--    <ul class="dropdown-menu">
            <li>  <a href="" ng-click="setActive('jdjdjdf')">Create a New Group</a></li>
            <li class="divider"></li>
            <li>  <a href="" ng-click="setActive('ksdkjdsdskj')"> Groups</a></li>
      <li class="dropdown-submenu" style="margin-left:20px;margin-bottom:5px;cursor:pointer;" ng-repeat="testcase in testcases">{{testcase.testcase}}
      <li class="divider"></li>
      </ul> -->
          </li>
          
      <!--   </ul> -->
        <!-- </li>
        </ul> -->
         <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form> 
        <!-- <ul class="nav navbar-nav navbar-right"> -->
         <!--  <li><a href="#"><span class="cwhite">Link</span></a></li> -->
          <li class="dropdown" align="right">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="cwhite"><%=session.getAttribute("name")%> <b class="caret"></b></span></a>
            <ul class="dropdown-menu">
              <li><a href="signout-done.jsp" >Log out</a></li>
           <!--    <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li><a href="#">Separated link</a></li> -->
              
            </ul>
          </li>
        </ul>
       <!--  </ul> -->
      </div>
    </nav>
    </div>
    <div id="content">
    
     <div  ng-show="isActive('newgroup')">
<!-- <div class="page" ng-controller="DevicesCtrl"> -->
<h3>Dropzone {{$index + 1}}</h3>
<ul dnd-list="containers"
    dnd-allowed-types="['containerType']"
    dnd-external-sources="true"
    dnd-dragover="dragoverCallback(event, index, external, type)"
    dnd-drop="dropCallback(event, index, item, external, type, 'containerType')">
    <li ng-repeat="items in containers"
        dnd-draggable="items"
        dnd-type="'containerType'"
        dnd-effect-allowed="copyMove"
        dnd-moved="containers.splice($index, 1)">
        <div class="container-element box box-blue">
            <h3>Container</h3>
            <ul dnd-list="items"
                dnd-allowed-types="['itemType']"
                dnd-horizontal-list="true"
                dnd-external-sources="true"
                dnd-dragover="dragoverCallback(event, index, external, type)"
                dnd-drop="dropCallback(event, index, item, external, type, 'itemType')"
                dnd-inserted="logEvent('Element was inserted at position ' + index, event)"
                class="itemlist">
                <li ng-repeat="item in items"
                    dnd-draggable="item"
                    dnd-type="'itemType'"
                    dnd-effect-allowed="copyMove"
                    dnd-dragstart="logEvent('Started to drag an item', event)"
                    dnd-moved="items.splice($index, 1); logEvent('Item moved', event)"
                    dnd-copied="logEvent('Item copied', event)"
                    dnd-canceled="logEvent('Drag operation canceled', event)"
                    dnd-dragend="logEvent('Drag operation ended', event)">
                    {{item.label}}
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>
    </li>
</ul>


   <!--  </div> -->
    </div>
    
    
    <div  ng-show="isActive('deviceprops')">
<div class="page" ng-controller="DevicesCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search device" ng-model="searchDevice">
      </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <td>
         Sno:
        </td>
        <td>
          <a href="#" ng-click="sortType = 'device'; sortReverse = !sortReverse">
            Device Name 
            <span ng-show="sortType == 'device' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'device' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'model'; sortReverse = !sortReverse">
           Device Model 
            <span ng-show="sortType == 'model' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'model' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'brand'; sortReverse = !sortReverse">
          Brand
            <span ng-show="sortType == 'brand' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'brand' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'version'; sortReverse = !sortReverse">
          Version 
            <span ng-show="sortType == 'version' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'version' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in devices | orderBy:sortType:sortReverse | filter:searchDevice">
      <td>{{$index+1}}</td>
        <td><a href="" ng-click="showdetails(roll.device)">{{ roll.device }}</a></td>
        <td>{{ roll.model }}</td>
        <td>{{ roll.brand }}</td>
        <td>{{ roll.version }}</td>
      </tr>
    </tbody>
    
  </table>
  
</div>
    
    </div>
    
    
  <div ng-show="isActive('reports')">
<!-- jdjdjdjsjdfjfdjhdfjhfdjfjdhf -->
<div class="page" ng-controller="DevicesCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon">Search<!-- <i class="fa fa-search"></i> --></div>
        <input type="text" class="form-control" placeholder="Search Results" ng-model="searchTestcaseResult">
      </div>      
    </div>
    
    <div class="form-group">
      <div class="input-group">
        <!-- <div class="input-group-addon">Search<i class="fa fa-search"></i></div> -->
         <div>
           <select ng-model="searchTestcaseResult" ng-options="item.device as item.device for item in testcaselists | unique:'device'">
            <option value="">--Choose Device--</option>
            </select>
              <select ng-model="searchtestcase" ng-options="item.testcase as item.testcase for item in testcaselists | unique:'testcase'">
            <option value="">--Choose Testcase--</option>
            </select>
             <select ng-model="searchstatus" ng-options="item.status as item.status for item in testcaselists | unique:'status'">
            <option value="">--Choose Status--</option>
            </select>
        </div>
       <!--  <input type="text" class="form-control" placeholder="Search Results" ng-model="searchTestcaseResult"> -->
      </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <td>
         Sno:
        </td>
        <td>
          <a href="#" ng-click="sortType = 'device'; sortReverse = !sortReverse">
            Device ID
            <span ng-show="sortType == 'device' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'device' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'testcase'; sortReverse = !sortReverse">
           Testcase
            <span ng-show="sortType == 'testcase' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'testcase' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'status'; sortReverse = !sortReverse">
          Status
            <span ng-show="sortType == 'status' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'status' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'date'; sortReverse = !sortReverse">
          Date 
            <span ng-show="sortType == 'date' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'date' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'time'; sortReverse = !sortReverse">
          Time taken 
            <span ng-show="sortType == 'time' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'time' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'log'; sortReverse = !sortReverse">
          Log File
            <span ng-show="sortType == 'log' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'log' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in testcaselists | orderBy:sortType:sortReverse | filter:searchTestcaseResult | filter:searchtestcase | filter:searchstatus">
      <td>{{$index+1}}</td>
        <td>{{ roll.device }}</td>
        <td><a href="#" ng-click="showcharts(roll.testcase)">{{ roll.testcase }}</a></td>
        <td>{{ roll.status }}</td>
        <td>{{ roll.date }}</td>
        <td>{{ roll.time }} ms</td>
        <td><!-- {{ roll.logpath }} --><a href ng-click="getlogfile(roll.logpath)">log</a></td>
      </tr>
    </tbody>
    
  </table>
  
</div>
  </div>
    
 
   
  <div ng-show="isActive('reportsdate')">
<!-- jdjdjdjsjdfjfdjhdfjhfdjfjdhf -->
 <body data-ng-app="app">
    <section class="panel panel-default">
      <div class="panel-heading">
        <strong>
          <span class="glyphicon glyphicon-th"></span>
 Datepicker</strong>
      </div>
      <div class="panel-body" data-ng-controller="DevicesCtrl">
        <div class="row">
          <div class="col-sm-4">
            <div class="input-group ui-datepicker">
              <span class="input-group-addon" ng-click="open($event)">
                <i class="fa fa-calendar"></i>
              </span>
              <input type="text" class="form-control" datepicker-popup="{{format}}" 
                ng-model="dt" is-open="opened" min="minDate" max="'2015-06-22'" 
                datepicker-options="dateOptions" date-disabled="disabled(date, mode)" 
                ng-required="true" close-text="Close"
                ng-click="open($event)" />
            </div>
            <div class="callout callout-info">
              <p>Date is: {{dt | date:'fullDate'}}</p>
            </div>
          </div>
           <div class="col-sm-4">
            <div class="input-group ui-datepicker">
              <span class="input-group-addon" ng-click="open1($event)">
                <i class="fa fa-calendar"></i>
              </span>
              <input type="text" class="form-control" datepicker-popup="{{format}}" 
                ng-model="dt1" is-open="opened1" min="minDate1" max="'2015-06-22'" 
                datepicker-options="dateOptions1" date-disabled="disabled1(date, mode1)" 
                ng-required="true" close-text="Close"
                ng-click="open1($event)" />
            </div>
            <div class="callout callout-info">
              <p>Date is: {{dt1 | date:'fullDate'}}</p>
            </div>
          </div>
        <!--   <div class="col-sm-8">
            <p>
              Format:                                                                                                                                      
              <span class="ui-select">
                <select ng-model="format" ng-options="f for f in formats"></select>
              </span>
            </p>
          </div> -->
        </div>
      </div>
    </section>
  </body>
<div class="page" ng-controller="DevicesCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
  
  <form>
   <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon">Search<!-- <i class="fa fa-search"></i> --></div>
        <input type="date" class="form-control" placeholder="Search Results" ng-model="searchTestcaseResult">
      </div>      
    </div>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon">Search<!-- <i class="fa fa-search"></i> --></div>
        <input type="text" class="form-control" placeholder="Search Results" ng-model="searchTestcaseResult">
      </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <td>
         Sno:
        </td>
        <td>
          <a href="#" ng-click="sortType = 'device'; sortReverse = !sortReverse">
            Device ID
            <span ng-show="sortType == 'device' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'device' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'testcase'; sortReverse = !sortReverse">
           Testcase
            <span ng-show="sortType == 'testcase' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'testcase' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'status'; sortReverse = !sortReverse">
          Status
            <span ng-show="sortType == 'status' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'status' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'date'; sortReverse = !sortReverse">
          Date 
            <span ng-show="sortType == 'date' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'date' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'time'; sortReverse = !sortReverse">
          Time taken 
            <span ng-show="sortType == 'time' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'time' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'log'; sortReverse = !sortReverse">
          Log File
            <span ng-show="sortType == 'log' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'log' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in testcaselists | orderBy:sortType:sortReverse | filter:searchTestcaseResult | filter:searchtestcase | filter:searchstatus">
      <td>{{$index+1}}</td>
        <td>{{ roll.device }}</td>
        <td>{{ roll.testcase }}</td>
        <td>{{ roll.status }}</td>
        <td>{{ roll.date }}</td>
        <td>{{ roll.time }} ms</td>
        <td><!-- {{ roll.logpath }} --><a href ng-click="getlogfile(roll.logpath)">log</a></td>
      </tr>
    </tbody>
    
  </table>
  
</div>
  </div>
 <!--         TESTCASES INTEGRATION   -->
 
 
  <div ng-show="isActive('testcase')">
    <div ng-controller="TestcaseListCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
    {{testcaseset}}
   <table class="table table-bordered table-striped">
        <div class="cancel">
     <div ng-show="loader1.loading" class="info">App is being tested. Please wait for results.</div>
</div>
    <thead>
      <tr>
        <td>
         S.No.
        </td>
        <td>
          <a href="#" ng-click="sortType = 'device'; sortReverse = !sortReverse">
            Device ID
            <span ng-show="sortType == 'device' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'device' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'model'; sortReverse = !sortReverse">
           Status
            <span ng-show="sortType == 'model' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'model' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'brand'; sortReverse = !sortReverse">
          Creation Date and Time taken
            <span ng-show="sortType == 'brand' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'brand' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'version'; sortReverse = !sortReverse">
          Log
            <span ng-show="sortType == 'version' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'version' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
     <tbody>
      <tr ng-repeat="device in devices | orderBy:sortType:sortReverse | filter:searchDevice">
      <td>{{$index+1}}</td>
        <td> <a ng-click="showdetails(device.device)" class=" btn glyphicon glyphicon-phone">{{ device.device }}</a></td>
        <td><!-- {{ device.status }} -->
               <div class="cancel">
        <button ng-show="loader1.loading" class="btn btn-success">Loading...
        <i class="fa fa-spinner fa-spin"></i>
        </button>
          <div ng-show="device.status=='Pass'  || device.status == '' ">
          <div class="div-table-row">
     <div ng-show="status1.loading" class="success">Pass</div>
     </div>
</div>
   <div ng-show="device.status=='Fail' || device.status=='FAIL' ">
   <div class="div-table-row">
     <div ng-show="status1.loading" class="error" >{{device.errormsg}}</div>
     </div>
</div>
       
</div>
        </td>
        <td>          <div class="cancel">
                 <div ng-show="status1.loading">{{device.date}}, {{device.time}} ms</div>
     </div></td>
        <td><a href ng-click="getlogfile(device.logpath)">log</a></td>
      </tr>
    </tbody> 

  </table>
   <div align="Right">
        <a ng-click="test(testcaseset);" class=" btn glyphicon glyphicon-expand btn-primary">Review and run test case</a>
    &nbsp; &nbsp;&nbsp;   <a  class=" btn glyphicon glyphicon-remove-sign btn-danger"> Cancel</a>
       </div>
    </div>
 
    </div>
    
    
    
  <!--     END    -->  
    
  <div ng-show="isActive('testcasemapping')">
  <!-- <div ng-include="partials/testcase-list.html"> -->
   <div data-ng-include data-src="'TestcaseMapping.html'"></div>
    </div>  
    
    <div ng-show="isActive('newtestcase')">
       <!-- <div  ng-show="isActive('deviceprops')"> -->
<div class="page" ng-controller="DevicesCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search Testcase" ng-model="searchTestcase">
      </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <!-- <td>
         Sno:
        </td> -->
        <td>
          <a href="#" ng-click="sortType = 'id'; sortReverse = !sortReverse">
            Testcase ID 
            <span ng-show="sortType == 'id' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'testcase'; sortReverse = !sortReverse">
           Testcase Name 
            <span ng-show="sortType == 'testcase' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'testcase' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in testcases | orderBy:sortType:sortReverse | filter:searchTestcase">
       <td>{{$index+1}}</td>
       <!--  <td>{{ roll.device }}</td>
        <td>{{ roll.model }}</td> -->
        <!-- <td>{{ roll.id }}</td> -->
        <td><a href="#" ng-click="showtestcase(roll.testcase)">{{ roll.testcase }}</a></td>
      </tr>
    </tbody>
    
  </table>
  
</div>
    </div>
    
    
    
    
    
    
    
    
    
    
     <div ng-show="isActive('devicegroups')">
   <div align="center" class="span12" ng-controller="DevicesCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')"> 
<div align="center">
<h4 align="left"><!-- <img src="img/bootstrap/mobile-integration-workgroup-squarelogo.png" border="0" alt="MIW" style="margin-bottom:'0px';height:60px;width:'60px;'"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Number of devices connected:{{devices.length}}</h4>
</br></br>
</div>
    <table  class="table table-striped table-condensed" >
        <tbody>
         <tr style="padding-bottom: 20px;" height="130px" ng-repeat="device in devices">
         <td></td><td></td>
       <!-- <td>
       <input type="hidden" ng-init="init(device.device)" ng-model="device.device">
       </td> -->
       <td>
       <div ng-show="device.model=='MOTOROLA'">
       <img src="img/bootstrap/150px-MotoG.png" border="0" alt="MIW" style="margin-bottom:'0px';height:80px;width:50px;"/>
       </div>
        <div ng-show="device.model=='SAMSUNG'">
       <img src="img/bootstrap/ss.jpeg" border="0" alt="MIW" style="margin-bottom:'0px';height:80px;width:50px;"/>
       </div>
       <div ng-show="device.model==''">
       <img src="img/bootstrap/unnamed.png" border="0" alt="MIW" style="margin-bottom:'0px';height:80px;width:50px;"/>
       </div>
       </td>
        <td>  <a ng-click="showdetails(device.device)" class=" btn glyphicon glyphicon-phone">
        <span ng-if="device.model==null">{{device.device}} </span>
      </br></br>  <span ng-if="device.model!=null">{{device.model}} </span>
       </a></td>
        
            <td></td><td></td><td></td><td></td>
            <td>
            </td><td>
            <input type="file" id="install" ng-model="file" />
            <a ng-click="installapk(device.device,file)" style="margin-top:5px;" class="btn glyphicon glyphicon-download btn-primary">Install</a>
            </td>
              <td><input type="text" style="width: 250px; height:25px;" id="upload" ng-model="uploadfile"/>
            <a ng-click="uploadFiles(device.device,uploadfile)" class="btn glyphicon glyphicon-cloud-upload btn-primary">Upload</a></td>
           </td>
             <!-- <td><a ng-click="runselect(device.device,test)" class="btn btn-small btn-primary">Run</a></td> -->
             <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
             <td>  <a ng-click="showapps(device.device)" class="btn glyphicon glyphicon-expand btn-primary">Applications</a></td>
             <td>  <a ng-click="reboot(device.device)" class="btn glyphicon glyphicon-expand btn-primary">Reboot</a></td>
             <td></td>
    	        <td>
    	        </td>
    	        <td></td><td></td><td></td>
             </div>
         </tr> 
        </tbody>
    </table>
</div>
</div>
     </div>
     <div ng-show="isActive('default')">
     <div align="center" style="margin-top:30px;">
        <img  src="MCBLogoStripped.jpg" />
        </div>
<!-- <div class="row" style="margin-top:50px" masonry='{"transitionDuration": "0.4s", "itemSelector": ".buttonBlock"}'> -->
<!-- <div style="margin-top:350px;"> -->
<div align="center" style="margin-top:50px;">
<span style="margin-left:120px;"><a href="" ng-click="setActive('devicegroups')"><i class="fa  fa-android circle" style="font-size:110px;"></i></a> </span>
<span style="margin-left:120px;">
<a href="" ng-click="setActive('newtestcase')"><i class="fa  fa fa-file-o circle" style="font-size:110px;"></i></a></span>
<span style="margin-left:120px;"><a href="" ng-click="setActive('deviceprops')"><i class="fa  fa-search circle" style="font-size:110px;"></i></a></span>
<span style="margin-left:120px;"><a href="" ng-click="setActive('reports')"><i class="fa fa-pie-chart circle" style="font-size:110px;"></i></a></span>
</div>
      
    </div> 
  
    <!-- </div> -->
  </body> 
</html>
