package data;

import math.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public static List<Command> pars(InputStream is){

        Command cmd = null;
        List<Command> commands = new ArrayList<>();
        String [] args;

        Scanner sc = new Scanner(is);

            while (sc.hasNext()) { //Парсим
                args = sc.nextLine().split(" "); //Массив элементов, разделенных " "

//                Построчный вывод содержимого файла
//                for (String t : args) { System.out.print(t + " ");}
//                System.out.println();

                cmd = CommandFactory.create(args);

                commands.add(cmd);
            }

        return commands;
    }

}
