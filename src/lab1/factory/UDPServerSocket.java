package lab1.factory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class UDPServerSocket implements MySocket {
    private final DatagramSocket socket;
    private int                  senderPort;
    private InetAddress          senderAddress;
    private DatagramPacket       datagramPacket;

    public UDPServerSocket(int port) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendFloat(float num) {
        byte[] buffer = new byte[4]; //масив байтів, в який буде записано число типу float
        ByteBuffer.wrap(buffer).putFloat(num);
        datagramPacket = new DatagramPacket(buffer, buffer.length, senderAddress, senderPort); //об'єкт, в який записується повідомлення
        try {
            socket.send(datagramPacket); //надсилання повідомлення
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendDouble(double num) {
        byte[] buffer = new byte[8]; //масив байтів, в який буде записано число типу float
        ByteBuffer.wrap(buffer).putDouble(num);
        datagramPacket = new DatagramPacket(buffer, buffer.length, senderAddress, senderPort); //об'єкт, в який записується повідомлення
        try {
            socket.send(datagramPacket); //надсилання повідомлення
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float receiveFloat() {
        byte[] buffer = new byte[4]; //масив байтів, в який буде записано число типу float
        datagramPacket = new DatagramPacket(buffer, buffer.length); //об'єкт, в який записується повідомлення
        try {
            socket.receive(datagramPacket);              //отримання повідомлення
            senderAddress = datagramPacket.getAddress(); //отримання адреси відправника повідомлення
            senderPort = datagramPacket.getPort();       //отримання порта відправника повідомлення
            DataInputStream inputStream =
                    new DataInputStream(new ByteArrayInputStream(datagramPacket.getData())); //вхідний потік для зчитування повідомлення
            return inputStream.readFloat(); //зчитування числа типу float з вхідного потоку
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double receiveDouble() {
        byte[] buffer = new byte[8]; //масив байтів, в який буде записано число типу double
        datagramPacket = new DatagramPacket(buffer, buffer.length); //об'єкт, в який записується повідомлення
        try {
            socket.receive(datagramPacket);              //отримання повідомлення
            senderAddress = datagramPacket.getAddress(); //отримання адреси відправника повідомлення
            senderPort = datagramPacket.getPort();       //отримання порта відправника повідомлення
            DataInputStream inputStream =
                    new DataInputStream(new ByteArrayInputStream(datagramPacket.getData())); //вхідний потік для зчитування повідомлення
            return inputStream.readDouble(); //зчитування числа типу double з вхідного потоку
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finish() {
        socket.close();
    }
}
