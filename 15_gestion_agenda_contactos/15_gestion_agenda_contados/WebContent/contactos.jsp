<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.AgendaContactos,beans.Contacto,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="cache-control" content="max-age=0"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<meta http-equiv="pragma" content="no-cache"/>

<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
			<tr><th>Nombre</th><th>Email</th><th>Telefono</th><th></th></tr>
			<%AgendaContactos agenda=new AgendaContactos();
			List<Contacto> contactos=agenda.recuperarContactos();%>
			<%for(Contacto c:contactos){ %>
				<tr>
					<td><%=c.getNombre() %></td>
					<td><%=c.getEmail() %></td>
					<td><%=c.getTelefono() %></td>
					<td><a href="EliminarContacto?idContacto=<%=c.getIdContacto()%>">Eliminar</a></td>
				</tr>
			<%} %>
		
		</table>
		<br/><br/>
		<a href="inicio.html">Volver</a>
	</center>
</body>
</html>