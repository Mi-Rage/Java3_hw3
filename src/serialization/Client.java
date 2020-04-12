package serialization;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // Пытаемся подключиться к серверу
        try (Socket s = new Socket("127.0.0.1", 8189)) {
            System.out.println("Socket connected");
            // Формируем поток вывода
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("Socket ready");

            // Создаём подопытного для сериализации
            Person personOut = new Person("Wasya", 25, "Russia");
            System.out.println("Object before serialization: " + personOut);

            // В поток вывода передаём сформированный ранее поток out
            try (ObjectOutputStream objOut = new ObjectOutputStream(out)) {
                // Передаём объект
                objOut.writeObject(personOut);

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Object send!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}