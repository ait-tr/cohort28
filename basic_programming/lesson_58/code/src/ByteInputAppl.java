package ait.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputAppl {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("./result/test2")) {
//            System.out.println("Available = " + fin.available());
//            int a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());
//            a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());
//            a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());
//            a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());
//            a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());
//            a = fin.read();
//            System.out.println(a);
//            System.out.println("Available = " + fin.available());

//              Option 1
//            int a = fin.read();
//            while (a != -1){
//                System.out.println(a);
//                a = fin.read();
//            }

//              Option 2
//            int len = fin.available();
//            for (int i = 0; i < len; i++) {
//                int a = fin.read();
//                System.out.println(a);
//            }

//              Option 3
            int len = fin.available();
            byte[] arr = new byte[len];
            fin.read(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
