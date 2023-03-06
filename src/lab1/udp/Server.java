package lab1.udp;

import lab1.Manager;
import lab1.factory.MySocket;
import lab1.factory.SocketFactory;
import lab1.utils.Console;
import lab1.utils.Data;
import lab1.utils.Option;

public class Server {

    public static void process(int numOfFloat, int numOfDouble) {
        MySocket socket = SocketFactory.getSocket(Option.UDPServer, Data.host, Data.portUDP);
        Console.printStart(Option.UDPServer);

        for (int i = 0; i < numOfFloat; i++) {
            Manager.receiveFloat(socket);
        }

        for (int i = 0; i < numOfDouble; i++) {
            Manager.receiveDouble(socket);
        }

        Console.printStop(Option.UDPServer);
        socket.finish();
    }

    public static void main(String[] args) {
        process(6, 4);
    }
}


