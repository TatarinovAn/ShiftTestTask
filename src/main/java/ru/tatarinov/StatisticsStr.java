package ru.tatarinov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class StatisticsStr {
    private static int countElement;
    private static int maxLength;
    private static int minLength;
    private static String fileName;

    public static void readFileStr(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            List<String> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }

            list.sort(Comparator.comparingInt(String::length));
            //  Collections.sort(list);

            maxLength = list.get(list.size() - 1).length();
            minLength = list.get(0).length();
            countElement = list.size();

            fileName = file.getName();

        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл");
        }


    }

    public static void getShortStatistics() {
        System.out.println(fileName);
        System.out.println("Колличество элементов в файле " + countElement);
    }

    public static void getFullStatistics() {
        System.out.println(fileName);
        System.out.println("Колличество элементов в файле " + countElement);
        System.out.println("Максимальная длина " + maxLength);
        System.out.println("Минимальная длина " + minLength);
    }
}
