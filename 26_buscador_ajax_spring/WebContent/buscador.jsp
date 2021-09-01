<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<script type="text/javascript">
	var objAjax=new XMLHttpRequest();
	function buscar(){
		//obtenemos el valor introducido en el campo de texto
		//para mandarlo como parámetro en la petición
		var texto=document.getElementById("nombre").value;
		//configuramos la url con los parámetros a enviar al controller
		var url="buscar";
		url+="?nom="+texto;
		//configurar datos de la peticion
		objAjax.open("GET", url, true);
		//definir función de retrollamada
		objAjax.onreadystatechange=procesarRespuesta;
		//lanzar la petición
		objAjax.send(null);

	}
	function procesarRespuesta(){
		//si la respuesta está disponible, se procesa
		if(objAjax.readyState==4){
			//trasnforma la cadena de texto en una estructura JSON
			var json=JSON.parse(objAjax.responseText);
			var respuesta="<ul>";
			//recorre el array de objetos y para cada uno genera un elemento de lista
			json.forEach(function(ob){
				respuesta+="<li>"+ob.nombre+" - "+ob.email+" - "+ob.telefono+"</li>";
			});
			respuesta+="</ul>";
			document.getElementById("resultado").innerHTML=respuesta;
		}
		
	}

</script>
</head>
<body>
<div class="container">
	<h1>Página de búsqueda de contactos</h1>
	<br/>
	<div class="form-group">
			<label class="control-label col-sm-2">Introduce nombre:</label>
			<input type="text" id="nombre" onkeyup="buscar();" class="form-control" style="width:30%"/>
		</div>
	
	<br/>
	<div id="resultado">
		
	</div>
	<br/><br/>
	<a href="volver">Volver</a>
</div>
	

</body>
</html>