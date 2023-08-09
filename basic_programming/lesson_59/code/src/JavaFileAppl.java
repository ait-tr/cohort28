package ait.filesystem;

import java.io.File;

public class JavaFileAppl {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        String path = File.separator + "home" + File.separator + "edward" + File.separator + "Pictures" + File.separator + "Wallpaper";
        System.out.println(path);
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println("===============");
        File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getName());
        }
        System.out.println("===============");
        String newPath = path + File.separator + "my";
        File newFile = new File(newPath);
        System.out.println(newFile.exists());
        newFile.mkdir();
        System.out.println(newFile.exists());
        System.out.println(newFile.isDirectory());
        newFile.delete();
        System.out.println(newFile.exists());
    }
}
