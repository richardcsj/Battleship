angular.module('battleship', [])
  .controller('gameController', function($scope,$http,$interval) {
	  
	  $http.get("./Game?action=getCurrentPlayer")
	  	.then(function(response){
	  		$scope.currentPlayer = response.data;
	  	})
	  $scope.attack = function(playerIndex,row,col){
		  $http.get("./Game?action=attack&player="+playerIndex+"&row="+row+"&col="+col)
		  	.then(function(response){
		  		$scope.game = response.data;
		  	});
		  }
	  $scope.placeShip = function(playerIndex,row,col){
		  $http.get("./Game?action=placeShip&player="+playerIndex+"&row="+row+"&col="+col)
		  	.then(function(response){
		  		$scope.game = response.data;
		  	});
	  }
	  var getGame = function(){
		  $http.get("./Game?action=getGame")
		    .then(function(response) {
		        $scope.game = response.data;
		    });
	  }
	  
	  $interval(getGame,1000);
	  
  });