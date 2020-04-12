package tasks123;

import java.io.*;
import java.util.Scanner;

public class FileViewer {
    public static void main(String[] args) {
        final String FILE_NAME = "src/tasks123/bigFile.txt";
        final int SIZE_VOLUME = 1800;
        Scanner scanner = new Scanner(System.in);

        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("Размер файла " + file.length() + " байт");
            System.out.println("Страниц от 1 до " + (file.length() % SIZE_VOLUME == 0 ? file.length() / SIZE_VOLUME :
                    file.length() / SIZE_VOLUME + 1));
        } else {
            System.out.println("Файл не найден");
        }


        try (FileInputStream inputStream = new FileInputStream(file)) {

            byte[] array = new byte[SIZE_VOLUME];
            int readData = 0;

            System.out.println("Номер страницы: ");
            int number = scanner.nextInt();

            long time = System.currentTimeMillis();

            for (int i = 0; i < number; i++) {
                readData = inputStream.read(array);
            }
            try {
                System.out.print(new String(array, 0, readData));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Нет такой страницы!");
            }

        System.out.println();
        System.out.println("Выполнено за " + (System.currentTimeMillis() - time) + " мсек.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
