package ch.heigvd.nackeskratta.controllers;

import ch.heigvd.nackeskratta.model.Furniture;
import ch.heigvd.nackeskratta.services.dao.FurnituresManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brofm_000
 */
public class EditorServlet extends HttpServlet {

	@EJB
	FurnituresManagerLocal furnitureManager;

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

		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		int colorId = Integer.parseInt(request.getParameter("color"));
		int materialId = Integer.parseInt(request.getParameter("material"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		double price = Double.parseDouble(request.getParameter("price"));

		furnitureManager.updateFurniture(id, name, materialId, categoryId, price, colorId);

		displayRespond(request, response);
	}

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

		displayRespond(request, response);
	}

	private void displayRespond(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//On affiche à partir de l'id passé en paramètre
		long id = Long.parseLong(request.getParameter("id"));

		Furniture furniture = furnitureManager.getFurnitureById(id);
		request.setAttribute("furniture", furniture);

		request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
	}

}
