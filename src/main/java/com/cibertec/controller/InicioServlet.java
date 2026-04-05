package com.cibertec.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final Logger LOG = LogManager.getLogger(InicioServlet.class);
	private static final long serialVersionUID = 1L;
       
    public InicioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("esto es un mensaje informativo");
		LOG.error("Esto es un mensaje de error");
		LOG.debug("esto es un mensaje de depurACION");
		LOG.warn("Esto es un mensaje de advertencia");
		LOG.trace("ESTO ES PARA TRAZABILIDAD");
		LOG.fatal("ESTO ES UN MENSAJE FATAL");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
