package lab1.factory;

import lab1.utils.Option;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFactory {

    public static MySocket getSocket(Option option, String host, int port) {

        return switch (option) {

            case TCPClient -> {
                try {
                    yield new TCPSocket(new Socket(host, port));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case TCPServer -> {
                try {
                    yield new TCPSocket(new ServerSocket(port).accept());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            case UDPClient -> new UDPClientSocket(host, port);

            case UDPServer -> new UDPServerSocket(port);
        };
    }

}
