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

@WebServlet("/VerCarrito")
public class VerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		HttpSession s = request.getSession(); 
		List<Item> carrito = (List<Item>) s.getAttribute("carrito");
		//si el carrito existe se muestra
		if(carrito!=null)  {		
				String cab = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" + 
						"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
						"</head>";
				
				
				out.println("<html><head>"+cab+"<body><div class='container'>");
				
				String cad = "<table class='table table-striped table-bordered'>" + 
						"<thead> <tr> <th>Producto</th> <th>Unidades</th> <th>Precio</th>" + 
						"<th> </th> </tr> </thead> <tbody> ";
				String fil = "";
				for (int i=0; i<carrito.size();i++ ) {
					fil += "<tr><td>" + carrito.get(i).getItem() + "</td> "
							 + "<td>" + carrito.get(i).getUnidades()+ "</td>"
							 + "<td>" + carrito.get(i).getValor() + "</td> "
							 + "<td> <a href='Eliminar?pos="+i+"'> Eliminar</a> </td></tr>"; 
				}
				fil += "</tbody></table>";
				out.println(cad);
				out.println(fil);
				out.println("<a href='opciones.html' class='btn btn-primary' style='width:20%'> Volver </a>");
				out.println("<a href='Vaciar' class='btn btn-warning' style='width:20%'> Vaciar Carrito</a>");
				out.println("<a href='Cerrar' class='btn btn-danger' style='width:20%'> Desconectar</a>");
				out.println("</div></body></html>");			
		}else {
			request.getRequestDispatcher("opciones.html").forward(request, response);
		}
	}
}
