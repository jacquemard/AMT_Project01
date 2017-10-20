/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nackeskratta.controllers;

import ch.heigvd.nackeskratta.model.Furniture;
import ch.heigvd.nackeskratta.services.dao.FurnituresManagerLocal;
import java.io.IOException;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Remi
 */
public class FurnituresServlet extends HttpServlet {

	@EJB
	FurnituresManagerLocal furnitureManager;

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

		String pageStr = request.getParameter("page");
		int page = 0;
		if (pageStr != null && !pageStr.isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		final int NUMBER_PER_PAGE = 20;

		// Meubles
		LinkedList<Furniture> furnitures = furnitureManager.getFurnitures(page, 20);
		request.setAttribute("furnitures", furnitures);

		// Pages
		int numberOfFurnituresTot = furnitureManager.getNumberOfFurniture();
		int numberOfPages = (int) Math.ceil(numberOfFurnituresTot / NUMBER_PER_PAGE);

		int firstPage = page - 3;
		if(firstPage < 0)
			firstPage = 0;
		int lastPage = page + 3;
		if(lastPage > numberOfPages - 1)
			lastPage = numberOfPages -1 ;
		
		request.setAttribute("firstPage", firstPage + 1);
		request.setAttribute("lastPage", lastPage + 1);
		request.setAttribute("currentPage", page + 1);
                
		// ---
		request.getRequestDispatcher("/WEB-INF/furnitures.jsp").forward(request, response);
	}

}
