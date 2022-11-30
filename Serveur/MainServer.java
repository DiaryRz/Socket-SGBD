package main;
import server.*;
public class MainServer{
    public static void main(String[] args)
    {
        try{
            Server appel = new Server();
            appel.Serveur();
        }catch(Exception e){System.out.println(e);}
        
    }
}