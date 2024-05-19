package com.gabiatwork.onlinereservation.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ReservationClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            String command;
            while (true) {
                System.out.println("1. View Events");
                System.out.println("2. Create Reservation");
                System.out.print("Enter choice: ");
                command = scanner.nextLine();

                if (command.equals("1")) {
                    out.println("GET /events");
                } else if (command.equals("2")) {
                    System.out.print("Enter reservation details: ");
                    String reservation = scanner.nextLine();
                    out.println("POST /reservations " + reservation);
                } else {
                    break;
                }

                String response = in.readLine();
                System.out.println("Server response: " + response);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
