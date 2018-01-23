<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>BattleShip - Home</title>

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
        <div class="col-sm-12 main">
          <h2 class="sub-header">Welcome To BattleShip Game</h2>
          <img src="<c:url value="/images/logo.png"/>" />
          <a class="btn btn-primary btn-block" href="./Settings" >Play Now</a>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   
  </body>
</html>
