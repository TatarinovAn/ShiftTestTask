package ru.tatarinov.command;

import ru.tatarinov.OutputFiles;
import ru.tatarinov.StatisticsFloat;
import ru.tatarinov.StatisticsInt;
import ru.tatarinov.StatisticsStr;
import ru.tatarinov.command.Instruction;

import java.io.File;
import java.io.IOException;

public class ShortStatistics implements Instruction {
    private final OutputFiles outputFiles = OutputFiles.getInstance();

    @Override
    public String getCommand() {
        return "-s";
    }

    @Override
    public void call(String str) throws IOException {
        File fileInt = new File(outputFiles.getPath() + outputFiles.getPrefix() + "integers.txt");
        File fileFloat = new File(outputFiles.getPath() + outputFiles.getPrefix() + "floats.txt");
        File fileStr = new File(outputFiles.getPath() + outputFiles.getPrefix() + "strings.txt");

        if (fileInt.exists()) {
            StatisticsInt.readFileInt(fileInt);
            StatisticsInt.getShortStatistics();
        }
        if (fileFloat.exists()) {
            StatisticsFloat.readFileFloat(fileFloat);
            StatisticsFloat.getShortStatistics();
        }
        if (fileStr.exists()) {
            StatisticsStr.readFileStr(fileStr);
            StatisticsStr.getShortStatistics();
        }
    }
}
