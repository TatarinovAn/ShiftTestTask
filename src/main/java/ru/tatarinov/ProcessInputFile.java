package ru.tatarinov;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessInputFile {
    public static void inFile(BufferedReader bufferedReader) throws IOException {

        OutputFiles outputFiles = OutputFiles.getInstance();
        String line;

        StringBuilder stringBufferStr = new StringBuilder();
        StringBuilder stringBufferInt = new StringBuilder();
        StringBuilder stringBufferFloat = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.matches("^([-+]?([0-9]+))[.,]+[0-9]+[eE]?[-]?[0-9]*")) {
                stringBufferFloat.append(line).append("\n");
            } else if (line.matches("[-+]?\\d+[eE]?[-]?[0-9]*")) {
                stringBufferInt.append(line).append("\n");
            } else {
                stringBufferStr.append(line).append("\n");
            }
        }
        if (!stringBufferStr.isEmpty()) {
            outputFiles.createStringFile(stringBufferStr.toString());
        }

        if (!stringBufferInt.isEmpty()) {
            outputFiles.createIntegerFile(stringBufferInt.toString());
        }

        if (!stringBufferFloat.isEmpty()) {
            outputFiles.createFloatsFile(stringBufferFloat.toString());
        }


        bufferedReader.close();
    }
}
