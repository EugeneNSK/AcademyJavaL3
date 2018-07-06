package main;

import data.Parser;
import exception.CalcException;
import math.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Run {
    public static void main(String[] args) throws CalcException {

        InputStream is;
        System.out.println("Запускаем консольный калькулятор");
        try {

            if (args.length > 0) {
                System.out.println("Указан атрибут консоли: " + args[0]);
                is = new FileInputStream(new File(args[0]));
            } else {
                System.out.println("Атрибут консоли не указан. Комады будут считываться из консоли");
                is = System.in;
            }

            for (Command c : Parser.pars(is)) {
                System.out.println("Выполняем команду: " + c);
                c.execute();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}
