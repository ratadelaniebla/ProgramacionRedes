package registro.estudiante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import client.socket.Client;

public class ProcesaEstudiante {
	public ProcesaEstudiante(){
		
	}
	public static void ingresaEstudiante(List<String> datos) throws IOException {
		Client cliente = new Client("localhost" , 5000);
		cliente.enviaSocket(datos);
		cliente.cierraCliente();
	}
	@SuppressWarnings("unchecked")
	public static List<List<String>> consultaEstudiante() throws IOException, ClassNotFoundException {
		Client cliente = new Client("localhost" , 5000);
		List<List<String>> estudiantes = new ArrayList<List<String>>();
		cliente.enviaSocket(Arrays.asList("$LISTA$"));
		estudiantes = (List<List<String>>)cliente.recibe();
		cliente.cierraCliente();
		return estudiantes;
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		for (List<String> string : ProcesaEstudiante.consultaEstudiante()) {
			for (String string2 : string) {
				System.out.println(string2);
			}
		}
	}
}
