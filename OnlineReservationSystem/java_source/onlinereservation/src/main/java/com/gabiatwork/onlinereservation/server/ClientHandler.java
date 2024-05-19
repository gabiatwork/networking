package com.gabiatwork.onlinereservation.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String request;
            while ((request = reader.readLine()) != null) {
                // Process request and generate response
                String response = processRequest(request);
                writer.println(response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // Logic to process request and interact with file storage
        return "Response for: " + request;
    }
}
