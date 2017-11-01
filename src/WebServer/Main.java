package WebServer;

import org.apache.xmlrpc.WebServer;
import ganug_restapi.URLConnection;

public class Main {
    public static void main(String[] args) { 
        WebServer server = new WebServer(1718);
        
       
        server.addHandler("absen", new URLConnection());      
         
        server.start();
        System.out.println("Server berjalan pada port 1718 . . ."); 
    }  

    }