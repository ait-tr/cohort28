package ait.charstream;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter console = new PrintWriter(System.out, true);
//        System.out.println("Enter file name:");
        console.println("Enter file name:");
//        console.flush();
        String str = br.readLine();
        PrintWriter pw = new PrintWriter(new FileWriter(str, true));
        System.out.println("Please write your text here:");
        str = br.readLine();
        while(!"exit".equalsIgnoreCase(str)){
            pw.println(str);
            pw.flush();
            System.out.println("Please write your text here:");
            str = br.readLine();
        }
//        pw.flush();
//        pw.println(str);
        pw.close();
        console.close();
    }
}
