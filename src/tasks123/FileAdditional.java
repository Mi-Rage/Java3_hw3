package tasks123;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
 */

public class FileAdditional {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<InputStream> arrayInput = new ArrayList<>();

        arrayInput.add(new FileInputStream("src/tasks123/1.txt"));
        arrayInput.add(new FileInputStream("src/tasks123/2.txt"));
        arrayInput.add(new FileInputStream("src/tasks123/3.txt"));
        arrayInput.add(new FileInputStream("src/tasks123/4.txt"));
        arrayInput.add(new FileInputStream("src/tasks123/5.txt"));

        SequenceInputStream inputStream = new SequenceInputStream(Collections.enumeration(arrayInput));

        int readData;

        try (FileOutputStream outputStream = new FileOutputStream("src/tasks123/result12345.txt")) {
            while ((readData = inputStream.read()) != -1) {
                outputStream.write(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
