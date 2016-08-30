<%@page import="java.util.List"%>
<%@page import="registro.estudiante.ProcesaEstudiante"%>

<html>
<head>
<link rel="stylesheet" media="screen" href="Estilo.css" />
<script type="text/javascript">
	function cargaFormulario(){
		window.open("index.jsp", "_self");
	}
	</script>
</head>
<body>
	<!--Título-->
	<h1>Consulta de Estudiantes Matriculados</h1>
	<!--Contenedor-->
	<div id="container">
		<input id="tab-1" type="radio" name="tab-group"
			onclick="cargaFormulario()" /> <label for="tab-1">Matricular</label>
		<input id="tab-2" type="radio" name="tab-group" checked="checked" />
		<label for="tab-2">Consultas</label>

		<!--Contenido a mostrar/ocultar-->
		<div id="content">
			<!--Contenido de la Pestaña 2-->
			<div id="content-2">
				<table border="1">
					<tr>
						<th align="center"><b>Nombres</b></th>
						<th align="center"><b>Apellidos</b></th>
						<th align="center"><b>C&eacute;dula</b></th>
						<th align="center"><b>Fecha de nacimiento</b></th>
						<th align="center"><b>Domicilio</b></th>
						<th align="center"><b>G&eacute;nero</b></th>
						<th align="center"><b>Estado Civil</b></th>
						<th align="center"><b>Matricula Cancelada</b></th>
					</tr>
					<%
	                    for (List<String> string : ProcesaEstudiante.consultaEstudiante()) {
	                 %><tr>
						<%
	                    	for (String string2 : string) {
	                    		%><td>
							<%System.out.println(string2);
	                    		out.println(string2);
	                    		%>
						</td>
						<%
	                    	}
	                 %>
					</tr>
					<%
	                    };
                    %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>