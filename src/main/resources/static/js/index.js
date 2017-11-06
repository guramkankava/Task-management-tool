var module = angular.module("taskManagerApp", ["xeditable"]);

var controller = module.controller("taskController", taskManagerController);

module.run(function(editableOptions) {
  editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
});

function taskManagerController ( $scope, $http) {
	$scope.taskName = "";
	$scope.taskDescription = "";
	$scope.editLabel = "Edit";
	$scope.editMode = false;
	$scope.tasks = {};
	$scope.getTasks = function getTasks () {
		$http.get("tasks").then( function (response) {
			$scope.tasks = response.data;
		} )
	};
	$scope.getTasks();
	
	$scope.createTask = function () {
		if( $scope.taskName !== "" && !$scope.taskDescription !== "") {
			$http.post("/createTask", {name:$scope.taskName, description:$scope.taskDescription}).then( function (response) {
				$scope.tasks = response.data;
				$scope.taskName = "";
				$scope.taskDescription = "";
			})
		}
	};
	
	$scope.updateStatus = function (id) {
		$http.put("/updateStatus/"+ id).then( function (response) {
			$scope.tasks = response.data;
		});
	};
	
	$scope.editTask = function ( task, id ) {
		if($scope.editMode){
			$http.put("/editTask", task).then( function (response) {
				$scope.tasks = response.data;
			});
		}
		$scope.editMode = !$scope.editMode;
		$scope.editLabel = $scope.editMode ? "Save" : "Edit";
	};
	
	$scope.deleteTask = function ( id ) {
		$http.delete("/deleteTask/" + id ).then( function (response) {
			$scope.tasks = response.data;
		});
	};
};

