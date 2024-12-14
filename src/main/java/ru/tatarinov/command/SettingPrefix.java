package ru.tatarinov.command;

import ru.tatarinov.OutputFiles;
import ru.tatarinov.command.Instruction;

import java.io.IOException;

public class SettingPrefix implements Instruction {
    private final OutputFiles outputFiles = OutputFiles.getInstance();

    @Override
    public String getCommand() {
        return "-p";
    }

    @Override
    public void call(String prefix) throws IOException {
        if (prefix.charAt(0) != '-') {
            outputFiles.setPrefix(prefix);
        } else {
            throw new IOException("Incorrect prefix");
        }
    }
}
