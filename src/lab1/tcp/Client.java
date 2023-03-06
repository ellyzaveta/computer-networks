package lab1.tcp;

import lab1.Manager;
import lab1.factory.MySocket;
import lab1.factory.SocketFactory;
import lab1.utils.*;

public class Client {

    public static void process(int numOfFloat, int numOfDouble) throws InterruptedException {
        MySocket socket = SocketFactory.getSocket(Option.TCPClient, Data.host, Data.portTCP);
        Thread.sleep(Data.time);
        Console.printStart(Option.TCPClient);

        for (int i = 0; i < numOfFloat; i++) {
            Manager.sendFloat(socket);
            Thread.sleep(Data.time);
        }

        for (int i = 0; i < numOfDouble; i++) {
            Manager.sendDouble(socket);
            Thread.sleep(Data.time);
        }

        Console.printStop(Option.TCPClient);
        socket.finish();
    }

    public static void main(String[] args) throws InterruptedException {
        process(6, 4);
    }
}
