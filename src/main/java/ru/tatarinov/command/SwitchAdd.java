package ru.tatarinov.command;

import ru.tatarinov.OutputFiles;
import ru.tatarinov.command.Instruction;

public class SwitchAdd implements Instruction {
    private final OutputFiles outputFiles = OutputFiles.getInstance();

    @Override
    public String getCommand() {
        return "-a";
    }

    @Override
    public void call(String str) {
        outputFiles.setSwitchAdd(true);
    }
}
