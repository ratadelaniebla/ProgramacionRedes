package client.socket;

import java.io.*;
import java.net.*;
public class Client {
    Socket skCliente = null;
    
    public Client( String host, int puerto ) { 
        try{ 
            skCliente = new Socket( host , puerto );
        } catch( Exception e ) {
            System.out.println( e.getMessage() ); 
        }  
    }
    public Object recibe() throws IOException, ClassNotFoundException{
    	InputStream aux = null;
    	ObjectInputStream flujo = null;
        aux = skCliente.getInputStream();
        flujo = new ObjectInputStream( aux );
        return flujo.readObject();            
    }
    public void enviaSocket(Object mensaje) throws IOException{
        OutputStream aux = skCliente.getOutputStream();
        ObjectOutputStream flujo= new ObjectOutputStream( aux );
        flujo.writeObject( mensaje );
    }
    public void cierraCliente() throws IOException{
        skCliente.close();
    }
}
