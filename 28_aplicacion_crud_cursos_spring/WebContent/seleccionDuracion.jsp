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
	<h1>Selecci�n duraci�n</h1>
	<br/>
	<form action="cursosDuracion" method="get" class="form-horizontal" >
		<div class="form-group">
			<label class="control-label col-sm-2">Introduce duraci�n m�xima:</label>
			<input  type="text" name="duracion" class="form-control" style="width:30%"/>
		</div>		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default" style="width:30%">Aceptar</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>