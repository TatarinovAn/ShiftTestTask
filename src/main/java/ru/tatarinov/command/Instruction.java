package ru.tatarinov.command;

import java.io.IOException;
import java.util.Scanner;

public interface Instruction {
    String getCommand();

    void call(String str) throws IOException;
}
