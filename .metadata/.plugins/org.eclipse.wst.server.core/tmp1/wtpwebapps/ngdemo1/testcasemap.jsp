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
    <title>{{testcaseset}}</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <!-- <link rel="stylesheet" href="app.css"> -->
  </head>
  <body ng-app="plunker">
     <!--  <div ng-show="isActive('testcase')"> -->
    <div ng-controller="TestcaseListCtrl" data-ng-init="init('<%=session.getAttribute("name")%>')">
    <b>{{testcaseset}}</b> </br>
    </br>
    <div ng-show="!showcheck">
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
       <td>  <input type="checkbox" ng-model="myTestcases.selected[$index]" ng-true-value="{{device.device}}" ng-false-value=""/></td>
        <td> <a ng-click="showdetails(device.device)" class=" btn glyphicon glyphicon-phone">{{ device.device }} {{device.brand}}</a></td>
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
  </div>
    <div ng-show="showcheck">
   <table class="table table-bordered table-striped">
        <div class="cancel">
     <div ng-show="loader1.loading" class="info">App is being tested. Please wait for results.</div>
</div>
    <thead>
      <tr>
     <!--    <td>
         S.No.
        </td> -->
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
      <tr ng-repeat="device in testlist | orderBy:sortType:sortReverse | filter:searchDevice">
       <!-- <td> --> <!--  <input type="checkbox" ng-model="myTestcases.selected[$index]" ng-true-value="{{device.device}}" ng-false-value=""/> --><!-- </td> -->
        <td> <a ng-click="showdetails(device.device)" class=" btn glyphicon glyphicon-phone">{{ device.device }} {{device.brand}}</a></td>
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
  </div>
  <div ng-show="showcheck">
   <div align="Right">
        <a ng-click="testsub(testcaseset,testlist);" class=" btn glyphicon glyphicon-expand btn-primary">Review and run test case</a>
    &nbsp; &nbsp;&nbsp;  <!--  <a  class=" btn glyphicon glyphicon-remove-sign btn-danger"> Cancel</a> -->
       </div>
       </div>
         <div ng-show="!showcheck" align="Right" >
            <div class="row" style="font-family:calibri;">
                       <button type="button" ng-click="submitform(myTestcases.selected,devices);showcheck=!showcheck;"><b>Next</b></button>
                      </div>
                       </div>
    </div>
 
    </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.js">
      </script>  
   
  </body>
</html>