package ru.tatarinov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFiles {
    private static String path = "";
    private static String prefix = "";
    private static boolean switchAdd = false;

    private static OutputFiles outputFiles;

    public boolean isSwitchAdd() {
        return switchAdd;
    }

    public void setSwitchAdd(boolean switchAdd) {
        this.switchAdd = switchAdd;
    }


    private OutputFiles() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
        System.out.println(this.prefix + " set");
    }

    public static OutputFiles getInstance() {
        if (outputFiles == null) {
            return new OutputFiles();
        }
        return outputFiles;
    }

    public void createStringFile(String str) {
        File file = new File(path + prefix + "strings.txt");
        try (FileWriter writer = new FileWriter(file, switchAdd)) {
            // запись всей строки
            String text = str;
            writer.write(text);
            writer.flush();
           // StatisticsStr.readFileStr(file);
        } catch (IOException ex) {

            System.out.println("Не удалось записать в strings.txt данные");
        }


    }

    public void createIntegerFile(String str) {
        File file = new File(path + prefix + "integers.txt");
        try (FileWriter writer = new FileWriter(file, switchAdd)) {
            // запись всей строки
            String text = str;
            writer.write(text);
            writer.flush();
            //StatisticsInt.readFileInt(file);
        } catch (IOException ex) {
            System.out.println("Не удалось записать в integers.txt данные");
        }
    }

    public void createFloatsFile(String str) {
        File file = new File(path + prefix + "floats.txt");
        try (FileWriter writer = new FileWriter(file, switchAdd)) {
            // запись всей строки
            String text = str;
            writer.write(text);

            writer.flush();
           // StatisticsFloat.readFileFloat(file);
        } catch (IOException ex) {
            System.out.println("Не удалось записать в floats.txt данные");
        }
    }
}
