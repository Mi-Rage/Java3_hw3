package serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    // Запускать первым. Затем клиента.
    public static void main(String[] args) {

        Person personIn;

        // Создаем сервер и выделяем сокет для подключения
        try (ServerSocket server = new ServerSocket(8189);
            Socket socket = server.accept()) {
            System.out.println("Client connected.");

            // Формируем поток получения данных
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Ready to accept.");

                // Потоку получения передаем сформированный ранее поток in
                try (ObjectInputStream objIn = new ObjectInputStream(in)) {
                    // Получаем подопытного
                    personIn = (Person) objIn.readObject();
                    // Рассматриваем что получили и завершаем работу
                    System.out.println("Object accepted: " + personIn);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
