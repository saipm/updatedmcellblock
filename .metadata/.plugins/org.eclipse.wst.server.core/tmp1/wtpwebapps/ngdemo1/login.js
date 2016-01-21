var app = angular.module('plunker', ['ui.bootstrap']);

app.controller('MainCtrl', function($scope) {
    $scope.name = 'World';
});

app.controller('DropdownCtrl', function($scope) {
    $scope.items = [
        "The first choice!",
        "And another choice for you.",
        "but wait! A third!"
    ];
});

app.controller('DevicesCtrl', ['$scope','$http', function($scope,$http) {
	$scope.devicemodel='';
	$scope.devicename='';
	 var url = window.location.href.split('/');
	  var baseUrl = url[0] + '//' + url[2]+"/"+url[3]+"/";
	  
$scope.init=function(){
	    $http.get(baseUrl+"web/testcases").
		 success(function(data) {
		   $scope.testcases=data;
		    }).error(function (data, status, headers, config) {
		        alert("error");
	});
	    $http.get(baseUrl+"web/devices/brand").
		 success(function(data) {
		   $scope.devices=data;
		    }).error(function (data, status, headers, config) {
		        alert("error");
	});
	    $scope.setActive = function (name) {
	   // alert("inside::::"+name)
	    	  $scope.thing = name; }

	    	$scope.isActive = function (name) {
	    //	alert("testtststd"+name);
	    	  return ($scope.thing == name); }
	 };

	 
	 
	 var indexedDevices = [];
	    
	    $scope.devicesToFilter = function() {
	        indexedDevices = [];
	        return $scope.devices;
	    }
	    
	    $scope.filterDevices = function(device) {
	        var modelIsNew = indexedDevices.indexOf(device.model) == -1;
	        if (modelIsNew) {
	        	indexedDevices.push(device.model);
	        }
	        return modelIsNew;
	    }
	 
	 
}]);

app.controller('MainController', 
function ($scope) {
$scope.items = [
                    {
                        name: "item1",
                        desc: "Item 1",
                        subitems: [
                            {
                                name: "subitem1",
                                desc: "Sub-Item 1"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            }]
                    },
                    {
                        name: "item2",
                        desc: "Item 2",
                        subitems: [
                            {
                                name: "subitem1",
                                desc: "Sub-Item 1"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            }]
                    },
                    {
                        name: "item3",
                        desc: "Item 3",
                        subitems: [
                            {
                                name: "subitem1",
                                desc: "Sub-Item 1"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            },
                            {
                                name: "subitem2",
                                desc: "Sub-Item 2"
                            }]
                    }
                ];

$scope.default = $scope.items[2];
});

app.controller('ItemController', ['$scope', function (scope) {

                scope.$parent.isopen = (scope.$parent.default === scope.item);

                scope.$watch('isopen', function (newvalue, oldvalue, scope) {
                    scope.$parent.isopen = newvalue;
                });

            }]);

