<!doctype html>
<html ng-app="plunker">
  <head>
  <script data-require="angular.js@1.2.8" data-semver="1.2.8" src="https://code.angularjs.org/1.2.8/angular.js"></script>
    <link data-require="bootstrap@*" data-semver="3.2.0" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.css" />
    <link data-require="bootstrap-css@~3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />
    <link data-require="font-awesome@*" data-semver="4.2.0" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <script data-require="ui-bootstrap@*" data-semver="0.11.0" src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.min.js"></script>
    <script src="example.js"></script>
     <script src="moment.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css"> 
    <link rel="stylesheet" href="newcss.css"> 
    <script type="text/javascript">

  </script>
    
<style>
  body{
  background-color:white;
  }
 

  body{
font-family:Arial, Helvetica, sans-serif; 
font-size:17px;
}

    body{
 /*  background:#567; */
  font-family:'Open Sans',sans-serif;
}


.form{
    padding:20px
}

html, body{
    background-color: white;
}
    </style>
    
    </head>
    
    <body>
    <div class="page"ng-controller="DevicesCtrl as ctrl" ng-init="init()">
    <!-- <div ng-repeat="device in devices">
 
    </div> -->
    <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search device" ng-model="searchDevice">
      </div>      
    </div>
  </form>
  <div ng-show="!showcheck">
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <td>
          Sno.
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
      <td>  <input type="checkbox" ng-model="myTestcases.selected[$index]" ng-true-value="{{roll.device}}" ng-false-value=""/></td>
        <td>{{ roll.device }}</td>
     <!--    <td ng-show="showcheck"> <select name="group" data-ng-options="s.testcase for s in testcases" data-ng-model="group"  ng-change="change(group.id)" required></select></td> -->
        <td>{{ roll.model }}</td>
        <td>{{ roll.brand }}</td>
        <td>{{ roll.version }}</td>
      </tr>
      <!--  {{myTestcases.selected}} -->
    </tbody>
    
  </table>
  </div>
  <div ng-show="showcheck">
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
      <!--   <td>
          Sno.
        </td> -->
        <td>
          <a href="#" ng-click="sortType = 'device'; sortReverse = !sortReverse">
            Device Name 
            <span ng-show="sortType == 'device' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'device' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'testcase'; sortReverse = !sortReverse">
            Testcase Name 
            <span ng-show="sortType == 'testcase' && !sortReverse"><i class="fa fa-caret-down"></i>
            </span>
            <span ng-show="sortType == 'testcase' && sortReverse" class="fa fa-caret-up"></span>
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
      <tr ng-repeat="roll in testlist | orderBy:sortType:sortReverse | filter:searchDevice">
        <td>{{ roll.device }}</td>
        <td></td>
        <!-- <td> <select name="testcase" data-ng-options="s.testcase for s in testcases" data-ng-model="myTestcases1.selected[s.testcase]" required></select></td> -->
        <td>{{ roll.model }}</td>
        <td>{{ roll.brand }}</td>
        <td>{{ roll.version }}</td>
      </tr>
   <!--    {{myTestcases.selected}} -->
    </tbody>
    
  </table>
  
    <div style="margin-left:800px" >
            <div class="row" style="font-family:calibri;">
                       <button type="button" ng-click="submitTests(myTestcases1.selected,devices);showcheck=!showcheck;"><b>Review and Run Test Case</b></button>
               </div>
                       </div>
  </div>
  

                        
   <div ng-show="!showcheck" style="margin-left:900px" >
            <div class="row" style="font-family:calibri;">
                       <button type="button" ng-click="submitform(myTestcases.selected,devices);showcheck=!showcheck;"><b>Next</b></button>
                      </div>
                       </div>
</div>
 
    </body>
    
    </html>