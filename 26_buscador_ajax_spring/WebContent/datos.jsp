<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Buscador de cursos</h1>
	<br/>
	<f:form action="alta" method="post" class="form-horizontal" modelAttribute="contacto">
		<div class="form-group">
			<label class="control-label col-sm-2">Nombre:</label>
			<f:input  path="nombre" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>
			<f:input path="email" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Teléfono:</label>
			<f:input path="telefono" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default" style="width:30%">Guardar</button>
			</div>
		</div>
	</f:form>
</div>
</body>
</html>