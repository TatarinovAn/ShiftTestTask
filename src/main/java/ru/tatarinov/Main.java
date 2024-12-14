package ru.tatarinov;

import ru.tatarinov.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Instruction> map = new HashMap<>();
        map.put("-o", new SettingPath());
        map.put("-p", new SettingPrefix());
        map.put("-a", new SwitchAdd());
        map.put("-s", new ShortStatistics());
        map.put("-f", new FullStatistics());

//обработка
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-o")) {
                    System.out.println("-o");
                    if (!map.containsKey(args[i + 1])) {
                        map.get("-o").call(args[i + 1]);
                    } else {
                        map.get("-o").call("");
                    }
                }

                if (args[i].equals("-p")) {
                    if (!map.containsKey(args[i + 1])) {
                        map.get("-p").call(args[i + 1]);
                    } else {
                        map.get("-p").call("");
                    }
                }

                if (args[i].equals("-a")) {
                    map.get("-a").call(null);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//чтение файлов
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains(".txt")) {
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(args[i]))) {
                    ProcessInputFile.inFile(reader);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


// статистика
        try {
            for (int i = 0; i < args.length; i++) {

                if (args[i].equals("-s")) {
                    map.get("-s").call(null);
                }

                if (args[i].equals("-f")) {
                    map.get("-f").call(null);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
