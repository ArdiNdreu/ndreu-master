package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
         try{
            ServerSocket server = new ServerSocket(3000);
            System.out.print("creo il server\n");
            Socket s = server.accept();
            System.out.print("creo la socket\n");        

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out =  new DataOutputStream(s.getOutputStream());

           Random random = new Random();
           double number = random.nextDouble(1);
            System.out.println(random);
            int n = 0;
            int cont = 0;
            for(int i=0;i<5;i++){
                int g=0;
                n = Integer.parseInt(in.readLine());
                if(n < number)
                    g = 1;
                else if(n > number)
                    g = 2;
                else 
                    g = 3;
                out.writeBytes(g + "\n"); 

      

            out.writeBytes(cont + "\n");
           }
            server.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
   
}
}