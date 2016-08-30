package server.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexionBD.ConectionDataBase;

public class Server extends Thread {
	private ServerSocket skServidor = null;
	private Socket skCliente = null;
	static Server server = null;
	static ConectionDataBase baseDatos = null;
	
	InputStream aux = null;
	ObjectInputStream flujo = null;
	
	public Server(int puerto) throws IOException {
		skServidor = new ServerSocket(puerto);
		
	}

	public void enviaEstudiantesCliente(List<List<String>> mensaje) throws IOException {
		OutputStream aux = skCliente.getOutputStream();
		ObjectOutputStream flujo = new ObjectOutputStream(aux);
		flujo.writeObject(mensaje);
	}

	public Object recibe() throws IOException, ClassNotFoundException, InterruptedException {
		aux = skCliente.getInputStream();
		flujo = new ObjectInputStream(aux);
		return flujo.readObject();
	}

	public void finServervidor() throws IOException {
		skCliente.close();
	}

	public static void main(String[] arg) throws IOException, ClassNotFoundException, InterruptedException {
		
		server = new Server(5000);
		Thread t1 = new Thread(server);
//		baseDatos = new ConectionDataBase("root", "");
//		baseDatos.getConetionMySql("localhost", "3306", "proyecto_final");
		baseDatos = new ConectionDataBase("adempiere", "adempiere");
		baseDatos.getConetionOracle("132.142.160.203", "1521", "idempier");
		t1.start();
		
	}
	
		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			
			try {
				List<String> datos = null;
				boolean bandera = true;
				while(bandera){
					skCliente = skServidor.accept();
					datos = (List<String>) server.recibe();
					if ("$LISTA$".equals(datos.get(0))){
						List<List<String>> estudiantes = new ArrayList<List<String>>();
						estudiantes = baseDatos.executeSelect(
								" select nombres, apellidos, cedula, nacimiento, domicilio, genero, estado_civil, matricula "
								+ " from alumnos ", null);
						server.enviaEstudiantesCliente(estudiantes);
					}else{
						if(datos != null){
							baseDatos.executeDML(
									"insert into alumnos (nombres, apellidos, cedula, nacimiento, domicilio, genero, estado_civil, matricula)"
											+ " values(?,?,?,?,?,?,?,?) ",
									datos);
							datos= null;
						}
					}
				}
			} catch (ClassNotFoundException | IOException  | InterruptedException | SQLException ex) {
				Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
			}
			finally {
				baseDatos.closeConection();
			}
	}

}

