<html>
<head>
<link rel="stylesheet" media="screen" href="Estilo.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.7.2.custom.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
   $("#id_fNacimiento").datepicker();
});
</script>
<script type="text/javascript">
	function cargarEstudiantes(){
		window.open("consulta_estudiantes.jsp", "_self");
	}
	function popitup() {
		var id_nombre = document.getElementById('id_nombre').value;
		var id_apellidos = document.getElementById('id_apellidos').value;
		var id_cedula = document.getElementById('id_cedula').value;
		var id_fNacimiento = document.getElementById('id_fNacimiento').value;
		var id_fDomicilio = document.getElementById('id_fDomicilio').value;
		var id_genero = document.getElementById('id_genero').value;
		var id_eCivil = document.getElementById('id_eCivil').value;
		var id_vMatricula = document.getElementById('id_vMatricula').value;
		var url = "guada_matricula.jsp?";
		url = url+"n_nombres="+id_nombre+"&"+
		"n_apellidos="+id_apellidos+"&"+
		"n_cedula="+id_cedula+"&"+
		"n_fNacimiento="+id_fNacimiento+"&"+
		"n_fDomicilio="+id_fDomicilio+"&"+
		"n_genero="+id_genero+"&"+
		"n_eCivil="+id_eCivil+"&"+
		"n_vMatricula="+id_vMatricula;
		
		newwindow=window.open(url,'name','height=200,width=450, top=400, left=600');
		if (window.focus) {newwindow.focus()}
		
	}
	</script>
</head>
<body>
	<!--Título-->
	<h1>Matriculaci&oacute;n de Estudiantes</h1>
	<!--Contenedor-->
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group" checked="checked" />
		<label for="tab-1">Matricular</label> <input id="tab-2" type="radio"
			name="tab-group" onclick="cargarEstudiantes();" /> <label for="tab-2">Consultas</label>

		<!--Contenido a mostrar/ocultar-->
		<div id="content">
			<!--Contenido de la Pestaña 1-->
			<div id="content-1" >
				<form id="matriculacion" action="guada_matricula.jsp" method="get">
					<table>
						<tr>
							<td>Nombres:</td>
							<td><input type="text" name="n_nombres" id="id_nombre" /></td>
						</tr>
						<tr>
							<td>Apellidos:</td>
							<td><input type="text" name="n_apellidos" id="id_apellidos" /></td>
						</tr>
						<tr>
							<td>C&eacute;dula</td>
							<td><input type="text" name="n_cedula" id="id_cedula" /></td>
						</tr>
						<tr>
							<td>Fecha de nacimiento:</td>
							<td><input type="text" name="n_fNacimiento"
								id="id_fNacimiento" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>Domicilio:</td>
							<td><input type="text" name="n_fDomicilio"
								id="id_fDomicilio" /></td>
						</tr>
						<tr>
							<td>G&eacute;nero</td>
							<td><select id="id_genero" name="n_genero">
									<option value="">Seleccione una opcion</option>
									<option value="Masculino">Masculino</option>
									<option value="Femenino">Femenino</option>
							</select></td>
						</tr>
						<tr>
							<td>Estado Civil:</td>
							<td><select id="id_eCivil" name="n_eCivil">
									<option value="">Seleccione una opcion</option>
									<option value="Soltero">Soltero</option>
									<option value="Casado">Casado</option>
									<option value="Divorciado">Divorciado</option>
									<option value="Uni&oacute;n Libre">Uni&oacute;n Libre</option>
							</select></td>
						</tr>
						<tr>
							<td>Valor de la Matricula:</td>
							<td><input type="text" name="n_vMatricula" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"
								id="id_vMatricula" /></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>
								<button type="button" onclick="popitup()">Enviar
									Formulario</button>
							</td>
						</tr>
					</table>
				</form>

			</div>
			
		</div>
	</div>
</body>
</html>