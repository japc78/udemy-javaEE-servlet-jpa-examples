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
	<h1>Datos del curso</h1>
	<br/>
	<form  class="form-horizontal" >
		<div class="form-group">
			<label class="control-label col-sm-2">Denominaci�n: ${requestScope.curso.denominacion}</label>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Duraci�n: ${requestScope.curso.duracion}</label>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Precio: ${requestScope.curso.precio}</label>
			
		</div>
		<a href="toVolver">Volver</a>
	</form>
</div>
</body>
</html>