package server;
import java.io.*;
import java.net.*;
import java.util.*;
import fonction.*;
import relation.*;
import exception.*;

public class Server {
 
    public void Serveur() throws Exception {
    
        final ServerSocket serveurSocket ;
        final Socket clientSocket ;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc=new Scanner(System.in);
        
            serveurSocket = new ServerSocket(5000);
            clientSocket = serveurSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            Fonction appelFonction = new Fonction();
        
             //= new String();
            Table tab = new Table();
            while(true){
                // try
                // {
                    String msg = in.readLine();
                    RequetteException Rqapp = new RequetteException();
                    ObjectOutputStream obj = new ObjectOutputStream(clientSocket.getOutputStream());
                    obj.writeObject(appelFonction.Requette(msg));
                // }catch(Exception e){System.out.println(e);} 
            }
            
    }
}