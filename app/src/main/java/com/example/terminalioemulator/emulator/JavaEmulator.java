package com.example.terminalioemulator.emulator;

import com.example.terminalioemulator.IOEmulator;

public class JavaEmulator {
    public static float degree(String name_of_val, Boolean type_of_operation ) {
        Boolean working_val = false;
       /* if(type_of_operation==false){

        }

        */
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
        float x = 0;
        while (working_val == false) {
            String num_of_activity = IOEmulator.INSTANCE.read(String.class);
            if (num_of_activity == "0") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" пико"+name_of_val);
                x = variable * (10^(-12));
                working_val = true;
            } else if (num_of_activity == "1") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" нано"+name_of_val);
                x = variable * (10^(-9));
                working_val = true;
            } else if (num_of_activity == "2") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" микро"+name_of_val);
                x = variable * (10^(-6));
                working_val = true;
            } else if (num_of_activity == "3") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" милли"+name_of_val);
                x = variable * (10^(-3));
                working_val = true;
            } else if (num_of_activity == "4") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" кило"+name_of_val);
                x = variable * (10^(3));
                working_val = true;
            } else if (num_of_activity == "5") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" мега"+name_of_val);
                x = variable * (10^(6));
                working_val = true;
            } else if (num_of_activity == "6") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" гига"+name_of_val);
                x = variable * (10^(9));
                working_val = true;
            } else if (num_of_activity == "7") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" тера"+name_of_val);
                x = variable * (10^(12));
                working_val = true;
            } else if (num_of_activity == "8") {
                IOEmulator.INSTANCE.println("Вы ввели "+variable+" "+name_of_val);
                x = variable;
                working_val = true;
            } else {
                IOEmulator.INSTANCE.println("ОШИБКА! попробуйте еще раз");
            }
        }
        return x;
    }
    public static float translator( String req_val ) {
        float phis_var = 0;
        Boolean working_val = false;
        while (working_val==false) {
            if (req_val == "I") {
                IOEmulator.INSTANCE.println("Введите силу тока!");
                phis_var = degree("Ампер", true);
                working_val = true;
            } else if (req_val == "U") {
                IOEmulator.INSTANCE.println("Введите напряжение!");
                phis_var = degree("Вольт", true);
                working_val = true;
            } else if (req_val == "R") {
                IOEmulator.INSTANCE.println("Введите Сопротивление!");
                phis_var = degree("Ампер", true);
                working_val = true;
            } else if (req_val == "delta t") {
                IOEmulator.INSTANCE.println("Изменение температуры");
                phis_var = degree("K", true);
                working_val = true;
            } else if (req_val == "A") {
                IOEmulator.INSTANCE.println("Введите работу!");
                phis_var = degree("Дж", true);
                working_val = true;
            } else if (req_val == "t") {
                IOEmulator.INSTANCE.println("температуру");
                phis_var = degree("K", true);
                working_val = true;
            } else if (req_val == "q") {
                IOEmulator.INSTANCE.println("Введите заряд");
                phis_var = degree("Кулон", true);
                working_val = true;
            } else {
                IOEmulator.INSTANCE.println("ОШИБКА!Попробуйте еще раз");
            }
        }
        return phis_var;
    }

    public static void mainEmulator(String[] args) {
        float result = 0;
        int out = 1;
        IOEmulator.INSTANCE.println("Добро пожаловать в feasy calc! Для решения физического примера введите название одной из предложенных формул\n" +
                "ДЛЯ нахождения силы тока введите: I или i \n"+
                "ДЛЯ нахождения напряжения введите: U или u \n"+
                "ДЛЯ нахождения сопротивления введите: R или r \n"+
                "ДЛЯ нахождения закона Ома введите: Om или om или OM \n"+
                "ДЛЯ нахождения работы электрического тока введите: A или a \n"+
                "ДЛЯ нахождения мощности введите: P или p \n"+
                "ДЛЯ нахождения количества теплоты введите: Q или q \n"+
                "ДЛЯ перевода значения из одних единиц в другие введите b: TR или tr \n"+
                "0 для выхода"
        );
        while(out!=0) {
            String var_text = IOEmulator.INSTANCE.read(String.class);
            if (var_text.equals("I") || var_text.equals("i")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти силу тока!");
                float x = translator("q");
                IOEmulator.INSTANCE.println("Введите время в секундах!");
                float y = IOEmulator.INSTANCE.read(Float.class);
                result = x/y;
            } else if (var_text.equals("U") || var_text.equals("u")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти напряжение!");
                float x = translator("A");
                float b = translator("q");
                result = x/b;
            } else if (var_text.equals("R") || var_text.equals("r")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти сопротивление!");
                float x = translator("U");
                float b = translator("I");
                result = x/b;
            } else if (var_text.equals("OM") || var_text.equals("om") | var_text.equals("Om")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти закон Ома!");
                float x = translator("U");
                float b = translator("R");
                result = x/b;
            } else if (var_text.equals("A") || var_text.equals("a")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти работу электрического тока!");
                float x = translator("I");
                float b = translator("U");
                float z = translator("delta t");
                result = x*b*z;
            } else if (var_text.equals("P") || var_text.equals("p")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти мощность!");
                float x = translator("U");
                float b = translator("I");
                result = x*b;
            } else if (var_text.equals("Q") || var_text.equals("q")) {
                IOEmulator.INSTANCE.println("Вы выбрали найти количество теплоты!");
                float x = translator("I");
                float b = translator("R");
                float z = translator("delta t");
                result = x*b*z;
            } /*else if (var_text.equals("TR") || var_text.equals("Tr")) {
                IOEmulator.INSTANCE.println("Вы выбрали перевести значение!");
                float x = translator("A");
                float b = translator("q");
                result = var_a / var_b;
            }*/
            else if (var_text.equals("0")) {
                IOEmulator.INSTANCE.println("До свидания!");
                out = 0;
            }
            else{
                IOEmulator.INSTANCE.println("Такое значение пока что отсутсвует, попробуйте ввести еще раз");
            }
            IOEmulator.INSTANCE.print(result);
        }
    }

}