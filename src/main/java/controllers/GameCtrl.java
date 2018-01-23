package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Game;
import util.JSONConverter;

/**
 * Servlet implementation class Game
 */
public class GameCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameCtrl() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Game game = Game.getInstance();
		String action = request.getParameter("action");
		// defining the PrintWriter object
		PrintWriter out = response.getWriter();			
		// setting the response type
		response.setContentType("application/json");	
		switch(action) {
			case "getGame" : 	
				// converting object to json using Gson api.
				out.println(JSONConverter.convert(game));				
				break;
			case "newGame" : 
				Game.initGame();
				game = Game.getInstance();
				response.sendRedirect("Settings");
			case "getCurrentPlayer":
				int currentPlayer=-1;
				for(Cookie cookie : request.getCookies() ) {
					if(cookie.getName().equals("currentPlayer")) {
						currentPlayer = Integer.parseInt(cookie.getValue());
					}
				}
				out.println(currentPlayer);
				break;
			case "attack":
				int playerToAtack = Integer.parseInt(request.getParameter("player"));
				int rowToAttack =  Integer.parseInt(request.getParameter("row"));
				int colToAttack =  Integer.parseInt(request.getParameter("col"));
				game.attack(playerToAtack,rowToAttack,colToAttack);
				break;
			case "placeShip":
				int playerToPlace = Integer.parseInt(request.getParameter("player"));
				int rowToPlace =  Integer.parseInt(request.getParameter("row"));
				int colToPlace =  Integer.parseInt(request.getParameter("col"));
				game.placeShip(playerToPlace,rowToPlace,colToPlace);
				break;
			
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
