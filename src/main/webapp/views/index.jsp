<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
            <li class="active"><a href="./Settings">Game Settings <span class="sr-only">(current)</span></a></li>
            <li><a href="./Start">Start</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Game Settings</h2>
          <div class="table-responsive">
          <form action="./Settings" method="POST" >
          
            <table class="table table-striped">
              <tbody>
               <tr>
                  <td>Player Name : </td>
                  <td><input class="form-control" type="text" name="playerName" placeholder="Please enter your name" /></td>
                </tr>
                <tr>
                  <td>Number Of Rows : </td>
                  <td><input class="form-control" type="number" name="numberOfRows" value="${ numberOfRows }" /></td>
                </tr>
                <tr>
                 <td>Number Of Columns : </td>
                  <td><input class="form-control" type="number" name="numberOfCols" value="${ numberOfCols }" />
                  <input class="form-control" type="hidden" name="numberOfShips" value="${ numberOfShips }" /></td>
                  </td>
                </tr>
                
                <tr>
                  <td><input class="btn btn-success" type="submit" value="Start" /></td>
                </tr>
              </tbody>
            </table>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   
  </body>
</html>
