<%@page import="registro.estudiante.ProcesaEstudiante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%

	String n_nombres = request.getParameter( "n_nombres" );
	String n_apellidos= request.getParameter( "n_apellidos" );
	String n_cedula= request.getParameter( "n_cedula" );
	String n_fNacimiento= request.getParameter( "n_fNacimiento" );
	String n_fDomicilio=request.getParameter( "n_fDomicilio" );
	String n_genero = request.getParameter( "n_genero" );
	String n_eCivil = request.getParameter( "n_eCivil" );
	String n_vMatricula = request.getParameter( "n_vMatricula" );
	
	List<String> estudiante = new ArrayList<String>();
	estudiante.add(n_nombres);
	estudiante.add(n_apellidos);
	estudiante.add(n_cedula);
	estudiante.add(n_fNacimiento);
	estudiante.add(n_fDomicilio);
	estudiante.add(n_genero);
	estudiante.add(n_eCivil);
	estudiante.add(n_vMatricula);
	try{
		ProcesaEstudiante.ingresaEstudiante(estudiante);
		%><center>
	<h1>Estudiante Guardado</h1>
</center>
<%
	}catch(Exception e){
		%><center>
	<h1>Ocurrio un error al enviar el formulario... Intente mas tarde.</h1>
</center>
<%
	}
%>
