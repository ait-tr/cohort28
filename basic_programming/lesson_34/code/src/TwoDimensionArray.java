package ait.multiarray;

public class TwoDimensionArray {
    public static void main(String[] args) {
        int[][] arr = new int[5][4];
        arr[2][3] = 100500;
        System.out.println(arr[2][3]);
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(arr[3].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
