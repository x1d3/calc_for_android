package com.example.terminalioemulator.emulator;

import com.example.terminalioemulator.IOEmulator;

public class JavaEmulator {
    public static void mainEmulator(String[] args) {
        // Write your code here
        IOEmulator.INSTANCE.println("");
        IOEmulator.INSTANCE.print(1234);

        int test = IOEmulator.INSTANCE.read(int.class);
    }
}
