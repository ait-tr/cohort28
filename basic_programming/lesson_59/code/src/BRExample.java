package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;

public class BRExample {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        System.out.println("Input your name: ");
        String name = br.readLine();
        System.out.println("Hello, " + name + "!");

        // включить bw на запись в файл
        String outputFileName = "file.txt";
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            // String value = name;
            writter.write(name + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
