package com.example.terminalioemulator.emulator;

import com.example.terminalioemulator.IOEmulator;

public class JavaEmulator {
    public static void mainEmulator(String[] args) {
        float result = 0;
        IOEmulator.INSTANCE.println("input your variable a");
        float var_a = IOEmulator.INSTANCE.read(Float.class);
        IOEmulator.INSTANCE.println("input your variable b");
        float var_b = IOEmulator.INSTANCE.read(Float.class);
        IOEmulator.INSTANCE.println("input /, +, -, *, &");
        String var_text = IOEmulator.INSTANCE.read(String.class);
        if (var_text.equals("+")) {
            result = var_a + var_b;
        } else if (var_text.equals("-")) {
            result = var_a - var_b;
        } else if (var_text.equals("/")) {
            result = var_a / var_b;
        }else if (var_text.equals("*")) {
            result = var_a * var_b;
        }
        IOEmulator.INSTANCE.print(result);

    }

}