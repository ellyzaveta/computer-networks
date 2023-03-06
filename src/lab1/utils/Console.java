package lab1.utils;

import java.time.LocalTime;

public class Console {
    public static void printFloatSendMessage(float num) {
        System.out.print(LocalTime.now());
        System.out.printf(": float %f sent\n", num);
    }

    public static void printDoubleSendMessage(double num) {
        System.out.print(LocalTime.now());
        System.out.printf(": double %f sent\n", num);
    }

    public static void printFloatReceiveMessage(float num) {
        System.out.print(LocalTime.now());
        System.out.printf(": float %f received\n", num);
    }

    public static void printDoubleReceiveMessage(double num) {
        System.out.print(LocalTime.now());
        System.out.printf(": double %f received\n", num);
    }

    public static void printStart(Option option) {
        if(option == Option.UDPServer || option == Option.TCPServer) System.out.println("server has started.");
        else System.out.println("client has started.");
    }

    public static void printStop(Option option) {
        if(option == Option.UDPServer || option == Option.TCPServer) System.out.println("server has finished.");
        else System.out.println("client has finished.");
    }
}
