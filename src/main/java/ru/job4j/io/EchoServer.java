package ru.job4j.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty();
                         str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                        } else if (str.contains("Any")) {
                            out.write("What.".getBytes());
                        } else if (str.contains("Exit")) {
                            socket.close();
                            break;
                        }
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
           LOG.error("Exception in log Example ", e);
        }
    }
}
