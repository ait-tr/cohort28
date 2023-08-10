package ait.titanic;

import ait.titanic.service.TitanicStats;
import ait.titanic.service.TitanicStatsImpl;

import java.util.Map;

public class TitanicAppl {
    public static void main(String[] args) {
        TitanicStats stats = new TitanicStatsImpl("train.csv", ",");
        System.out.println("Total fares: " + stats.totalFares());
        Map<String, Double> avgFares = stats.avgFaresByClasses();
        avgFares.forEach((k, v) -> System.out.println("Class " + k + " average fares is: " + v));
        Map<String, Long> survived = stats.totalSurvived();
        survived.forEach((k, v) -> System.out.println("Total " + k + " = " + v));
        survived = stats.totalSurvivedByGender();
        survived.forEach((k, v) -> System.out.println(k + " = " + v));
        survived = stats.totalSurvivedChildren();
        survived.forEach((k, v) -> System.out.println("Children " + k + " = " + v));
    }
}
