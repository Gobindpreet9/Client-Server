
//date created 08-08-19
//Purpose of program is to create a a client to test communication with a server

package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(Socket socket = new Socket("localhost", 5000)){
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//Dont forget to initialize auto-flush in printwriter or message may not be sent
            Scanner enter = new Scanner(System.in);
            String retrieve, send;
            while(true){
                System.out.printf("Enter message :");
                send = enter.next();
                writer.println(send);
                if(!(send.equals("quit"))){
                    while(!isr.ready()){ }
                    retrieve= reader.readLine();
                    System.out.println("Recieved "+(retrieve));

                }else
                    break;

            }


        }catch (Exception e){
            System.out.printf(e.getMessage());
        }

    }
}
