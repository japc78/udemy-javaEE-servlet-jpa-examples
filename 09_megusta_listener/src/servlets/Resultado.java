package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultado
 */
@WebServlet("/Resultado")
public class Resultado extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		int contador=(Integer)context.getAttribute("megusta"); 
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		out.println("<html><body><center>");
		out.println("<h1>Total de Me gusta: "+contador +"</h1>");
		out.println("<br/>");
		out.println("<a href='opciones.html'>Volver</a>");
		out.println("</center></body></html>");
	}

}
