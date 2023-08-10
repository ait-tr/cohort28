package ait.titanic.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TitanicStatsImpl implements TitanicStats{
    File file;
    String delimeter;

    public TitanicStatsImpl(String file, String delimeter) {
        this.file = new File(file);
        this.delimeter = delimeter;
    }

    public TitanicStatsImpl(File file, String delimeter) {
        this.file = file;
        this.delimeter = delimeter;
    }

    @Override
    public double totalFares() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .map(c -> c[10])
                    .mapToDouble(Double::parseDouble)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Map<String, Double> avgFaresByClasses() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br).collect(
                    Collectors.groupingBy(c -> c[2], Collectors.averagingDouble(c -> Double.parseDouble(c[10]))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public Map<String, Long> totalSurvived() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br).collect(
                    Collectors.groupingBy(c -> c[1].equals("1") ? "Survived" : "Non survived", Collectors.counting()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public Map<String, Long> totalSurvivedByGender() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .collect(Collectors.groupingBy(c -> survivedGender(c[5], c[1]), Collectors.counting()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public Map<String, Long> totalSurvivedChildren() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return getData(br)
                    .filter(c -> c[6] != null && !c[6].isEmpty())
                    .filter(c -> Double.parseDouble(c[6]) < 18)
                    .collect(Collectors.groupingBy(c -> c[1].equals("1") ? "Survived" : "Non survived",
                            Collectors.counting()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private String survivedGender(String gender, String survived) {
        survived = survived.equals("1") ? "survived" : "non survived";
        return gender + " " + survived;
    }

    private Stream<String[]> getData(BufferedReader br) {
        return br.lines().skip(1).map(s -> s.split(delimeter));
    }

}
