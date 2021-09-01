package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="menu.html";
		switch(op) {
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				url="menu.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				url="menu.html";
				break;
			case "doActualizar":
				request.getRequestDispatcher("ActualizarAction").include(request, response);
				url="menu.html";
				break;
			case "doRecuperar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="curso.jsp";
				break;
			case "doRecuperarActualizar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url="cursoActualizar.jsp";
				break;
			case "toNuevo":
				url="nuevo.html";
				break;
			case "toActualizar":
				request.setAttribute("url", "Controller?op=doRecuperarActualizar");
				url="buscador.jsp";
				break;
			case "toRecuperar":
				request.setAttribute("url", "Controller?op=doRecuperar");
				url="buscador.jsp";
				break;
			case "toEliminar":
				request.setAttribute("url", "Controller?op=doEliminar");
				url="buscador.jsp";
				break;
			case "toVolver":
				url="menu.html";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
