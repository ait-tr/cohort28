package ait.tarakan;

import ait.tarakan.model.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TarakanRaceAppl {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of tarakans:");
        int nTarakans = Integer.parseInt(br.readLine());
        System.out.println("Distance:");
        int distance = Integer.parseInt(br.readLine());
        Tarakan.setDistance(distance);
        Thread[] tarakans = startRace(nTarakans);
        waitFinish(tarakans);
        System.out.println("Congratulations to Tarakan " + Tarakan.getWinner());

    }

    private static void waitFinish(Thread[] tarakans) {
        for (int i = 0; i < tarakans.length; i++) {
            try {
                tarakans[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static Thread[] startRace(int nTarakans) {
        Thread[] threads = new Thread[nTarakans];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Tarakan("Tarakan#" + (i + 1)));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return threads;
    }
}
