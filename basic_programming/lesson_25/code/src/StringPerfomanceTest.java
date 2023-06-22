package ait.builder;

public class StringPerfomanceTest {
    private static final int N_ITERATION = 100_000;
    private static final String WORD = "meow";

    public static void main(String[] args) {
        //String
        String str = "";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATION; i++) {
            str = str + WORD;
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        //StringBuilder
        StringBuilder builder = new StringBuilder("");
        t1 = System.currentTimeMillis();
        for (int i = 0; i < N_ITERATION; i++) {
            builder.append(WORD);
        }
        str = builder.toString();
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
