package tasks123;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */
public class getFileFromArray {
    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream("src/tasks123/example.txt")){
            byte[] array = new byte[50];
            int readData;

            // читаем пока кончится файл (не встрерим -1)
            while ((readData = inputStream.read(array)) > 0) {
                System.out.print(new String(array, 0, readData));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
