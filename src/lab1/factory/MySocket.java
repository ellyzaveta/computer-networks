package lab1.factory;

public interface MySocket {
    void sendFloat(float num);
    void sendDouble(double num);
    float receiveFloat();
    double receiveDouble();
    void finish();
}
