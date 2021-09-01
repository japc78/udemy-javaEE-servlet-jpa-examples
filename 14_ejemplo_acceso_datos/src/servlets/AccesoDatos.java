package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccesoDatos
 */
@WebServlet("/AccesoDatos")
public class AccesoDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url="jdbc:mysql://localhost:3306/agenda";
		String sql1="insert into contactos(nombre,email,telefono)";
		sql1+="values('pruebajava','pruebajava@gmail.com',66666)";
		String sql2="select * from contactos";
		try(Connection cn=DriverManager.getConnection(url,"root","root")){
			Statement st1=cn.createStatement();
			st1.execute(sql1);
			ResultSet rs=st1.executeQuery(sql2);
			while(rs.next()) {
				out.println("<h1>"+rs.getString("nombre")+"-"+rs.getInt("telefono")+"</h1>");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


}
