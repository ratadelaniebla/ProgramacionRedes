package client.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
class Client {
    Socket skCliente = null;
    InputStream aux = null;
    ObjectInputStream flujo = null;
    public Client( String host, int puerto ) { 
        try{ 
            skCliente = new Socket( host , puerto );
        } catch( Exception e ) {
            System.out.println( e.getMessage() ); 
        }  
    }
    public void escribeServidor(List<String> mensaje) throws IOException{
        OutputStream aux = skCliente.getOutputStream();
        ObjectOutputStream flujo= new ObjectOutputStream( aux );
        flujo.writeObject( mensaje );
    }
    public String recibe() throws IOException, ClassNotFoundException{
        aux = skCliente.getInputStream();
        flujo = new ObjectInputStream( aux );
        return (String)flujo.readObject();            
    }
    public void cierraCliente() throws IOException{
        skCliente.close();
    }
//    public static void main( String[] arg ) throws IOException, ClassNotFoundException { 
//        Client client = new Client("localhost" , 5000);
//        List<String> l = new ArrayList<String>();
//        l.add("$LISTA$");
//        client.escribeServidor(l);
//        System.out.println("client:  "+client.recibe());
//        client.cierraCliente();
//    } 
}
