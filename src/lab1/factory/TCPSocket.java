package lab1.factory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPSocket implements MySocket {
    private final DataInputStream  inputStream;
    private final DataOutputStream outputStream;

    public TCPSocket(Socket socket) {
        try {
            this.inputStream = new DataInputStream(socket.getInputStream());    //вхідний потік даних сокета
            this.outputStream = new DataOutputStream(socket.getOutputStream()); //вихідний потік даних сокета
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendFloat(float num) {
        try {
            outputStream.writeFloat(num); //надсилання числа типу float
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendDouble(double num) {
        try {
            outputStream.writeDouble(num); //надсилання числа типу double
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float receiveFloat() {
        try {
            return inputStream.readFloat(); //зчитування числа типу float з вхідного потоку сокета
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double receiveDouble() {
        try {
            return inputStream.readDouble(); //зчитування числа типу double з вхідного потоку сокета
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finish() {
        try {
            inputStream.close();  //закриття вхідного потоку
            outputStream.close(); //закриття вихідного потоку
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
