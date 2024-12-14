package ru.tatarinov.command;

import ru.tatarinov.OutputFiles;

import java.io.IOException;

public class SettingPath implements Instruction {

    private final OutputFiles outputFiles = OutputFiles.getInstance();

    @Override
    public String getCommand() {
        return "-o";
    }

    @Override
    public void call(String newPath) throws IOException {

        if (newPath.charAt(0) != '-') {

            outputFiles.setPath(newPath);
        } else {
            throw new IOException("Incorrect path");
        }

    }
}
