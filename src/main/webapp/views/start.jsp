<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"  ng-app="battleship">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>BattleShip - Main</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/css/dashboard.css" />" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">BattleShip</a>
        </div>
        
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="./Settings">Game Settings </a></li>
            <li class="active"><a href="./Start">Start<span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div ng-controller="gameController" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h2>Game Status : {{game.gameStatus}}
        		<a class="btn btn-success" href="./Game?action=newGame" >New Game</a>
        </h2>
        <h2 ng-show="game.gameStatus=='ON_GOING'" >It's {{game.players[game.playerTurn].name}}'s Turn</h2>
        <h2 ng-show="game.gameStatus=='GAME_OVER'" >The Winner is : {{game.players[game.winner].name}}</h2>
        <hr>
        <div ng-repeat="player in game.players">
        		 <h2 class="sub-header">{{player.name}} <span ng-show="currentPlayer == $index" >(Me)</span></h2>
        		 <h3 ng-show="player.nonPlacedShips > 0" >Non Placed Ships : {{player.nonPlacedShips}}</h3>
        		 <h3 ng-show="player.nonPlacedShips == 0"  >Attacked Ships : {{player.attackedShips}}</h3>
        		 <h3 ng-show="player.nonPlacedShips == 0"  >Safe Ships : {{player.numberOfShips - player.attackedShips}}</h3>
        		 <div class="table-responsive">
	            <table class="table table-bordered">
	              <tbody>
	              	<tr ng-repeat="row in player.grid.cells">
	              			<td ng-repeat="cell in row track by $index" class="tdCell">
	              				<div 
	              					ng-show="currentPlayer == $parent.$parent.$index" 
	              					calss="cell"
	              				>
	              					<button 	              					
	              					 ng-click="placeShip($parent.$parent.$index,$parent.$index,$index)" 
	              					 ng-show="cell =='EMPTY'" class="cell empty" 
	              					 ng-disabled="game.gameStatus != 'ON_GOING' || game.players[currentPlayer].nonPlacedShips == 0 || currentPlayer != game.playerTurn"
	              					 >
	              					 </button>
	              					<button 
	              						ng-show="cell =='SHIP'" class="cell ship" 
	              						ng-disabled="true"
	              						>
	              					Ship
	              					</button>
	              					<button 
	              						ng-show="cell =='SUNKEN_SHIP'" class="cell sunken_ship" 
	              						ng-disabled="true"
	              						>
	              						Sunken Ship
	              					</button>
	              					<button 
	              						ng-show="cell =='ALREADY_TAKEN'" class="cell already_taken" 
	              						ng-disabled="true"
	              						>
	              						Already taken
	              					</button>
	              					
	              					
	              				</div>
	              				<div 
	              					ng-show="currentPlayer != $parent.$parent.$index" 
	              					class="cell"
	              					
	              					 >
	              					 <button 
	              					 	ng-show="cell == 'EMPTY' || cell=='SHIP'" class="cell attack"
	              					 	ng-disabled="game.gameStatus != 'ON_GOING' ||  game.players[currentPlayer].nonPlacedShips > 0 || currentPlayer != game.playerTurn"
	              					 	ng-click="attack($parent.$parent.$index,$parent.$index,$index)" 
	              					 >
	              					 	Attack
	              					 </button>
	              					 <button 
	              					 	ng-show="cell == 'ALREADY_TAKEN'" class="cell already_taken"
	              					 	ng-disabled="true"
	              					 >
	              					  Already taken
	              					 </button>
	              					 <button 
	              					 	ng-show="cell == 'SUNKEN_SHIP'" class="cell sunken_ship"
	              					 	ng-disabled="true"
	              					 >
	              					  Sunken Ship
	              					 </button>
	              					 
	              				</div>
	              			</td>
	              	</tr>
	              </tbody>
	            </table>
	          </div>
        </div>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="<c:url value="/js/angular.min.js" />"></script>
    <script src="<c:url value="/js/script.js" />"></script>
    
   
  </body>
</html>
