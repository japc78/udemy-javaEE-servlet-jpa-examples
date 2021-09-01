package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Ficha;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		if(user.equals("admin")&&pwd.equals("admin")) {
			//guarda en una cookie los credenciales del usuario
			guardarCredenciales(user,pwd,response);
			Ficha f=new Ficha(user,33,"prueba@gmail.com");
			//obtenemos el objeto HttpSession y guardamos
			//en él la ficha de usuario
			HttpSession s=request.getSession();
			s.setAttribute("ficha", f);
			rd=request.getRequestDispatcher("menu.html");
		}else {
			rd=request.getRequestDispatcher("Error");
		}
		rd.forward(request, response);
		
	}
	private void guardarCredenciales(String user, String pwd, HttpServletResponse response) {
		Cookie ck=new Cookie("credenciales",user+"-"+pwd);
		ck.setMaxAge(10000);
		response.addCookie(ck);
	}

	
}
