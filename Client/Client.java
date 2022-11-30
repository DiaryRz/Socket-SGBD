package client;
import java.io.*;
import java.net.*;
import java.util.*;
import relation.*;
import exception.*;
/*
 * www.codeurjava.com
 */
public class Client {

    public void client() throws Exception {
    
    final Socket clientSocket;
    final BufferedReader in;
    final PrintWriter ff;
    final Scanner sc = new Scanner(System.in);
    
    
        try {
        
            clientSocket = new Socket("localhost",5000);
            
            //flux pour envoyer
            ff = new PrintWriter(clientSocket.getOutputStream());
            //flux pour recevoir
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            

            String msg;
            
                while(true){
                    msg = sc.nextLine();
                    ff.println(msg);
                    ff.flush();

                    ObjectInputStream in2 = new ObjectInputStream(clientSocket.getInputStream());
                    try
                    {
                        Table t = (Table)in2.readObject();
                        for(int i = 0 ; i < t.getTableau().length  ; i++)
                        {
                            for(int j= 0 ; j < t.getTableau()[0].length ; j++)
                            {
                                System.out.print(t.getTableau()[i][j]+"\t"+"\t");
                            }
                            System.out.print("\n");
                        }
                    }catch(Exception e){}
                }
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

