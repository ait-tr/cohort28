package ait.byteio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputAppl {
    public static void main(String[] args) {
        try (FileOutputStream fout = new FileOutputStream("./result/test2");) {
            // FileOutputStream fout = new FileOutputStream("./result/test2", true);
            fout.write(65);
            fout.write(1);
            fout.write(27);
            fout.write(257);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
