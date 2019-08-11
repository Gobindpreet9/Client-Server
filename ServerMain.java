
//date created 08-08-2019
//purpose of program is to act as a server and continuously scan
//for clients wanting to connect

package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {
	// write your code here

        try(ServerSocket ss = new ServerSocket(5000)){
            while(true){
                Socket socket= ss.accept();
                System.out.println("Client connected");
                Communicate com = new Communicate(socket);
                com.start();
         //       new Communicate(ss.accept()).start();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
