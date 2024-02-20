package com.example.terminalioemulator.emulator;

import com.example.terminalioemulator.IOEmulator;

public class JavaEmulator {
    public static float degree(String name_of_val, Boolean type_of_operation) {
        IOEmulator.INSTANCE.println("Введите данные, а после выберите тип введенных вами единиц ");
        float variable = IOEmulator.INSTANCE.read(Float.class);

        IOEmulator.INSTANCE.println("Выберите тип введенных единиц\n" +
                "Для пико введите 0\n" +
                "Для нано введите 1\n" +
                "Для микро введите 2\n" +
                "Для милли введите 3\n" +
                "Для кило введите 4\n" +
                "Для мега введите 5\n" +
                "Для гига введите 6\n" +
                "Для тера введите 7\n"+
                "Для стандартной величины введите 8\n");

        String num_of_activity = IOEmulator.INSTANCE.read(String.class);
        float x = 0;

        switch (num_of_activity) {
            case "0":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " пико" + name_of_val);
                x = variable * (float)Math.pow(10, -12);
                break;
            case "1":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " нано" + name_of_val);
                x = variable * (float)Math.pow(10, -9);
                break;
            case "2":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " микро" + name_of_val);
                x = variable * (float)Math.pow(10, -6);
                break;
            case "3":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " милли" + name_of_val);
                x = variable * (float)Math.pow(10, -3);
                break;
            case "4":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " кило" + name_of_val);
                x = variable * (float)Math.pow(10, 3);
                break;
            case "5":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " мега" + name_of_val);
                x = variable * (float)Math.pow(10, 6);
                break;
            case "6":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " гига" + name_of_val);
                x = variable * (float)Math.pow(10, 9);
                break;
            case "7":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " тера" + name_of_val);
                x = variable * (float)Math.pow(10, 12);
                break;
            case "8":
                IOEmulator.INSTANCE.println("Вы ввели " + variable + " " + name_of_val);
                x = variable;
                break;
            default:
                IOEmulator.INSTANCE.println("ОШИБКА! Попробуйте еще раз");
        }
        return x;
    }

    public static float translator(String req_val) {
        float phis_var = 0;

        switch (req_val) {
            case "I":
                IOEmulator.INSTANCE.println("Введите силу тока!");
                phis_var = degree("Ампер", true);
                break;
            case "U":
                IOEmulator.INSTANCE.println("Введите напряжение!");
                phis_var = degree("Вольт", true);
                break;
            case "R":
                IOEmulator.INSTANCE.println("Введите сопротивление!");
                phis_var = degree("Ом", true);
                break;
            case "delta t":
                IOEmulator.INSTANCE.println("Введите изменение температуры!");
                phis_var = degree("K", true);
                break;
            case "A":
                IOEmulator.INSTANCE.println("Введите работу!");
                phis_var = degree("Дж", true);
                break;
            case "P":
                IOEmulator.INSTANCE.println("Введите мощность!");
                phis_var = degree("Вт", true);
                break;
            case "Q":
                IOEmulator.INSTANCE.println("Введите количество теплоты!");
                phis_var = degree("Дж", true);
                break;
            default:
                IOEmulator.INSTANCE.println("ОШИБКА! Попробуйте еще раз");
        }
        return phis_var;
    }

    public static void mainEmulator(String[] args) {
        float result = 0;
        int out = 1;
        IOEmulator.INSTANCE.println("Добро пожаловать в feasy calc! Для решения физического примера введите название одной из предложенных формул\n" +
                "Для нахождения силы тока введите: I или i \n"+
                "Для нахождения напряжения введите: U или u \n"+
                "Для нахождения сопротивления введите: R или r \n"+
                "Для нахождения работы электрического тока введите: A или a \n"+
                "Для нахождения мощности введите: P или p \n"+
                "Для нахождения количества теплоты введите: Q или q \n"+
                "0 для выхода"
        );
        while (out != 0) {
            String var_text = IOEmulator.INSTANCE.read(String.class);
            switch (var_text) {
                case "I":
                case "i":
                    IOEmulator.INSTANCE.println("Вы выбрали найти силу тока!");
                    float x = translator("A");
                    IOEmulator.INSTANCE.println("Введите время в секундах!");
                    float y = IOEmulator.INSTANCE.read(Float.class);
                    result = x / y;
                    break;
                case "U":
                case "u":
                    IOEmulator.INSTANCE.println("Вы выбрали найти напряжение!");
                    float x1 = translator("A");
                    float b1 = translator("q");
                    result = x1 / b1;
                    break;
                case "R":
                case "r":
                    IOEmulator.INSTANCE.println("Вы выбрали найти сопротивление!");
                    float x2 = translator("U");
                    float b2 = translator("I");
                    result = x2 / b2;
                    break;
                case "A":
                case "a":
                    IOEmulator.INSTANCE.println("Вы выбрали найти работу электрического тока!");
                    float x3 = translator("I");
                    float b3 = translator("U");
                    float z3 = translator("delta t");
                    result = x3 * b3 * z3;
                    break;
                case "P":
                case "p":
                    IOEmulator.INSTANCE.println("Вы выбрали найти мощность!");
                    float x4 = translator("U");
                    float b4 = translator("I");
                    result = x4 * b4;
                    break;
                case "Q":
                case "q":
                    IOEmulator.INSTANCE.println("Вы выбрали найти количество теплоты!");
                    float x5 = translator("I");
                    float b5 = translator("R");
                    float z5 = translator("delta t");
                    result = (float)Math.pow(x5, 2) * b5 * z5;
                    break;
                case "0":
                    IOEmulator.INSTANCE.println("До свидания!");
                    out = 0;
                    break;
                default:
                    IOEmulator.INSTANCE.println("Такое значение пока что отсутствует, попробуйте ввести еще раз");
            }
            IOEmulator.INSTANCE.print(result+"\n");
        }
    }
}
