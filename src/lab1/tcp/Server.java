package lab1.tcp;

import lab1.Manager;
import lab1.factory.MySocket;
import lab1.factory.SocketFactory;
import lab1.utils.Console;
import lab1.utils.Data;
import lab1.utils.Option;

public class Server {

    public static void process(int numOfFloat, int numOfDouble) {
        MySocket socket = SocketFactory.getSocket(Option.TCPServer, Data.host, Data.portTCP);
        Console.printStart(Option.TCPServer);

        for (int i = 0; i < numOfFloat; i++) {
            Manager.receiveFloat(socket);
        }

        for (int i = 0; i < numOfDouble; i++) {
            Manager.receiveDouble(socket);
        }

        Console.printStop(Option.TCPServer);
        socket.finish();
    }

    public static void main(String[] args) {
        process(6, 4);
    }

}
