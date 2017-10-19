/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nackeskratta.controllers;

import ch.heigvd.nackeskratta.services.dao.FurnituresManager;
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
public class InsertionServlet extends HttpServlet {

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
        //Furniture furniture = furnitureManager.getRandomFurniture();	
	//request.setAttribute("furniture", furniture);		
	request.getRequestDispatcher("/WEB-INF/insert.jsp").forward(request, response);
    }
}
