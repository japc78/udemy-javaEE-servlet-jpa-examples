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
	<form action="actualizar" method="post" class="form-horizontal" >
		<input type="hidden" name="idCurso" value="${requestScope.curso.idCurso}"/>
		<div class="form-group">
			<label class="control-label col-sm-2">Denominaci�n:</label>
			<input  type="text" name="denominacion" class="form-control" style="width:30%" value="${requestScope.curso.denominacion}"/>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Duraci�n:</label>
			<input  type="text" name="duracion" class="form-control" style="width:30%" value="${requestScope.curso.duracion}"/>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Precio:</label>
			<input  type="text" name="precio" class="form-control" style="width:30%" value="${requestScope.curso.precio}"/>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default" style="width:30%">Guardar</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>