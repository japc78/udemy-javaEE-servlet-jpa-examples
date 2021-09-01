package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Curso;
import modelo.service.CursosService;

/**
 * Servlet implementation class AltaAction
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		Curso curso=new Curso(0, 
				request.getParameter("denominacion"), 
				Integer.parseInt(request.getParameter("duracion")), 
				Double.parseDouble(request.getParameter("precio")));
		service.nuevoCurso(curso);
	}

}
