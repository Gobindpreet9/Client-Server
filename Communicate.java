package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Communicate extends Thread {
    private Socket socket;

    public Communicate(Socket socket){
        this.socket=socket;
    }

    public void run(){
        try{
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader input = new BufferedReader(isr);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
             do{
                 while (!isr.ready()){ }
                 String repeat = input.readLine();
                 System.out.println("Recieved : "+repeat);
                 if (repeat.equals("quit")){
                     break;
                 }
                 output.println(repeat);

             }while(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}}