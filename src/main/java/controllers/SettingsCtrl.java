package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Game;

/**
 * Servlet implementation class Main
 */
public class SettingsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Game game;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingsCtrl() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.game = Game.getInstance();
		request.setAttribute("numberOfRows", this.game.getGridRows());
		request.setAttribute("numberOfCols", this.game.getGridCols());
		request.setAttribute("numberOfShips", this.game.getNumberOfShips());
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.game = Game.getInstance();
	    int numberOfRows= Integer.parseInt(request.getParameter("numberOfRows"));
		int numberOfCols= Integer.parseInt(request.getParameter("numberOfCols"));
		int numberOfShips= Integer.parseInt(request.getParameter("numberOfShips"));
		String playerName = request.getParameter("playerName");
		boolean added = this.game.addPlayer(playerName);
		this.game.setGameSettings(numberOfRows, numberOfCols, numberOfShips);
		if(added) {
			int currentPlayer = this.game.getPlayers().size()-1;
			Cookie cookie = new Cookie("currentPlayer",""+currentPlayer);
			cookie.setMaxAge(60*60); //1hour
			response.addCookie(cookie);	
		}
		response.sendRedirect("Start");

	}

}
