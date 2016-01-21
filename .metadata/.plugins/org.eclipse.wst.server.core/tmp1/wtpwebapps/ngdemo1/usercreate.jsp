<!doctype html>
<html ng-app="plunker">
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css"> 
    <script src="example.js"></script>
    <script src="js/controllers.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
  
  <style>
  .dropdown-submenu{position:relative;}
.dropdown-submenu>.dropdown-menu{top:0;left:100%;margin-top:-6px;margin-left:-1px;-webkit-border-radius:0 6px 6px 6px;-moz-border-radius:0 6px 6px 6px;border-radius:0 6px 6px 6px;}
.dropdown-submenu:hover>.dropdown-menu{display:block;}
.dropdown-submenu>a:after{display:block;content:" ";float:right;width:0;height:0;border-color:transparent;border-style:solid;border-width:5px 0 5px 5px;border-left-color:#cccccc;margin-top:5px;margin-right:-10px;}
.dropdown-submenu:hover>a:after{border-left-color:#ffffff;}
.dropdown-submenu.pull-left{float:none;}.dropdown-submenu.pull-left>.dropdown-menu{left:-100%;margin-left:10px;-webkit-border-radius:6px 0 6px 6px;-moz-border-radius:6px 0 6px 6px;border-radius:6px 0 6px 6px;}
  </style>  
  </head>
  <body data-ng-controller="CreateCtrl"  data-ng-init="init()" align="center">
  <div align="center" style="border:1px solid black">
  <div ng-show="msgcheck"></br><b>{{msg}}</b></br></div>
  <!-- <form   role="form" > -->
  <h4>Account Details</h4></br>
  <label>Enter User Name:</label>
  <input type="text" ng-model="name" placeholder="Enter Name" ng-model="name"/> 
  </br></br>
  <label style="margin-right:80px;">Select User role:</label>
  <select data-ng-options="p.name for p in roles" data-ng-model="role">
</select>
</br></br>
 <label>Select User Designation:</label>
 <select data-ng-options="p.name for p in designations" data-ng-model="designation">
</select>
</br></br>
<label>Select User Department:</label>
<select data-ng-options="p.deptName for p in departments" data-ng-model="dept">
</select>
</br></br>
<h4><b>Functional Requirements</b></h4>
</br>
<label>Show Dashboard:
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<input type="checkbox" ng-model="checkboxModel.value1" ng-true-value="YES" ng-false-value="NO">
  </label><br/>
  <label>Access Testcases:
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <input type="checkbox" ng-model="checkboxModel.value2"
           ng-true-value="YES" ng-false-value="NO">
   </label><br/>
</br>
 <div ng-show="checkboxModel.value2=='YES'">

  <div style="width:200px;"ng-repeat="testcase in testcases">&nbsp;&nbsp;
   <label><input type="checkbox" ng-model="myTestcases.selected[testcase.id]" ng-true-value="{{testcase.testcase}}" ng-false-value="">{{testcase.testcase}}</label>
  </div>
{{myTestcases.selected.6}}
 </div>
</br>
  <button type="submit" ng-click="postdata(name,role,designation,dept,checkboxModel.value1,checkboxModel.value2,myTestcases.selected);clearall();msgcheck=!msgcheck;" name="submit" value="submit">Submit</button>
 </br></br>
  </div>
   </body>
   </html>