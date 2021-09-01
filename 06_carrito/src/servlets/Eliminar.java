package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;

@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(); 
		List<Item> carrito = (List<Item>) s.getAttribute("carrito");
		if( carrito!=null) {
			int pos = Integer.parseInt(request.getParameter("pos"));		
			carrito.remove(pos);
		} 
		request.getRequestDispatcher("VerCarrito").forward(request, response);
	}

}
