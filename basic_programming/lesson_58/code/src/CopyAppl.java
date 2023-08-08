package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        System.out.println("Source: " + args[0]);
        System.out.println("Destination: " + args[1]);
        try (FileInputStream fin = new FileInputStream(args[0]); FileOutputStream fout = new FileOutputStream(args[1]);) {
            int a = fin.read();
            while (a != -1) {
                fout.write(a);
                a = fin.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Problem with access to data");
        }
    }
}
