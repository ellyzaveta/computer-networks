package lab1;

import lab1.factory.MySocket;
import lab1.utils.Console;
import lab1.utils.Data;

public class Manager {
    //надсилання числа типу float
    public static void sendFloat(MySocket socket) {
        float num = Data.getRandFloat();    //генерація випадкового числа типу float
        socket.sendFloat(num);              //надсилання згенерованого числа
        Console.printFloatSendMessage(num); //виведення повідомлення про надсилання числа
    }

    //надсилання числа типу double
    public static void sendDouble(MySocket socket) {
        double num = Data.getRandDouble();   //генерація випадкового числа типу double
        socket.sendDouble(num);              //надсилання згенерованого числа
        Console.printDoubleSendMessage(num); //виведення повідомлення про надсилання числа
    }

    //отримання числа типу float
    public static void receiveFloat(MySocket socket) {
        Console.printFloatReceiveMessage(socket.receiveFloat());  //отримання числа типу float і виведення відповідного повідомлення
    }

    //отримання числа типу double
    public static void receiveDouble(MySocket socket) {
        Console.printDoubleReceiveMessage(socket.receiveDouble()); //отримання числа типу double і виведення відповідного повідомлення
    }
}
