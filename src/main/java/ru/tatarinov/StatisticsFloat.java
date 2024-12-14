package ru.tatarinov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class StatisticsFloat {
    private static float max;
    private static float min;

    private static int countElement;

    private static float sum = 0;
    private static float mean;
    private static String fileName;

    public static void readFileFloat(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            List<Float> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(Float.parseFloat(scanner.next()));
            }
            Collections.sort(list);

            max = list.get(list.size() - 1);
            min = list.get(0);
            countElement = list.size();

            for (Float el : list) {
                sum += el;
            }

            mean = sum / countElement;
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
        System.out.println("Максимальный элемент " + max);
        System.out.println("Минимальный элемент " + min);
        System.out.println("Сумма элементов " + sum);
        System.out.println("Среднее значение " + mean);
    }

}
