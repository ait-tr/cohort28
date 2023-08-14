package ait.tarakan.model;

import java.util.Random;

public class Tarakan implements Runnable{
    static int distance;
    static int minSleepTime = 2;
    static int maxSleepTime = 5;
    static String winner;
    static Random random = new Random();
    String name;

    public Tarakan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getWinner() {
        return winner;
    }

    public static void setDistance(int distance) {
        Tarakan.distance = distance;
    }

    public static void setMinSleepTime(int minSleepTime) {
        Tarakan.minSleepTime = minSleepTime;
    }

    public static void setMaxSleepTime(int maxSleepTime) {
        Tarakan.maxSleepTime = maxSleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            int sleepTime = minSleepTime + random.nextInt(maxSleepTime + 1 - minSleepTime);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }

        if (winner == null) {
            winner = name;
        }

    }

}
