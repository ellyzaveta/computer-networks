package lab1.udp;

import lab1.Manager;
import lab1.factory.MySocket;
import lab1.factory.SocketFactory;
import lab1.utils.Console;
import lab1.utils.Data;
import lab1.utils.Option;

public class Client {

    public static void process(int numOfFloat, int numOfDouble) throws InterruptedException {
        MySocket socket = SocketFactory.getSocket(Option.UDPClient, Data.host, Data.portUDP);
        Console.printStart(Option.UDPClient);

        for (int i = 0; i < numOfFloat; i++) {
            Manager.sendFloat(socket);
            Thread.sleep(Data.time);
        }

        for (int i = 0; i < numOfDouble; i++) {
            Manager.sendDouble(socket);
            Thread.sleep(Data.time);
        }

        Console.printStop(Option.UDPClient);
        socket.finish();
    }

    public static void main(String[] args) throws InterruptedException {
        process(6, 4);
    }
}
