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
 * Servlet implementation class ActualizarAction
 */
@WebServlet("/ActualizarAction")
public class ActualizarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		Curso curso=service.buscarCurso(Integer.parseInt(request.getParameter("idCurso")));
		if(curso!=null) {
			curso.setDenominacion(request.getParameter("denominacion"));
			curso.setDuracion(Integer.parseInt(request.getParameter("duracion")));
			curso.setPrecio(Double.parseDouble(request.getParameter("precio")));
			service.actualizarCurso(curso);
		}
	}

}
