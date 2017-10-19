package ch.heigvd.nackeskratta.controllers;

import ch.heigvd.nackeskratta.services.dao.FurnituresManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nadir Benallal
 */
public class GeneratorServlet extends HttpServlet {
	
	@EJB
	FurnituresManagerLocal furnitureManager;

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/generate.jsp").forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On lance la génération
		try {
			int nbToGenerate = Integer.parseInt(request.getParameter("nb_elements"));

			if (nbToGenerate < 2000000) { //Nombre max d'élément : 2 millions
				furnitureManager.generate(nbToGenerate);
			}

		} catch (NumberFormatException e) {
			//On fait rien, l'utilisateur a entrée un nombre trop grand
		}
		request.getRequestDispatcher("/WEB-INF/generate.jsp").forward(request, response);
	}
}
