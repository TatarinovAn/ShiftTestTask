package ru.tatarinov;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StatisticsInt {
    private static int max;
    private static int min;

    private static int countElement;

    private static int sum = 0;
    private static int mean;
    private static String fileName;

    public static void readFileInt(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            List<Integer> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);

            max = list.get(list.size() - 1);
            min = list.get(0);
            countElement = list.size();

            for (Integer el : list) {
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
