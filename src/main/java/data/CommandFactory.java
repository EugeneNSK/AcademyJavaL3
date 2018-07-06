package data;

import math.Command;
import math.In;

import java.io.File;
import java.io.FileReader;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

public class CommandFactory {

    private static Stack <Double> stack = new Stack();
    private static Map <String, Double> map = new HashMap<>();
    private static String [] tokens;

    private static Properties prop;

    static {

        //Загружаем проперти-файл: команда = класс

        prop = new Properties();
        try {
            FileReader fr = new FileReader(new File("commands.properties"));
            prop.load(fr);
            fr.close();
        } catch (Exception e) {
            System.out.println("Ошибка загрузки конфига");
        }

    }

    public static Command create (String[] args){

        Command cmd = null;
        Class<?> aClass;
        tokens = args;

        //Фабрика обращается к properties.getProperty(DEFINE)
        //нам возвращается имя класса String s = 'com.jcourse.lab1.surname.Define'

        //Может не быть элемента args[0]
        String s = prop.getProperty(args[0]);
        System.out.println("Класс из файла проперти: "+ s);

        //Class<?> aClass = Class.forName(s)
        //Создаем объект command с помощью aClass.newInstance();

        try {
            aClass = Class.forName(s);
            System.out.println("Загружаем класс aClass: "+ aClass);

            cmd = (Command) aClass.newInstance();
            System.out.println("Создаем объект сmd: "+ cmd);


            //У класса получаем список всех полей getDeclaredFields
            //проходимся по всем полям, находим те, которые помечены аннотацией In
            //берем аннотацию Annotation a = field.getAnnotation()

            Field [] classFields = aClass.getDeclaredFields();

            for (Field field:classFields){
                field.setAccessible(true); //разрешение редактирования private полей
                System.out.println("Fields: "+ field);
                Annotation a = field.getAnnotation(In.class);
                System.out.println("Fields: "+ field+ ": Annotation: " + a);
                String str = a.toString();
                System.out.println("Annotation to String "+ str);

                //смотрим на аргумент arg
                //switch(arg)
                //case STACK: field.set(command, stack)
                //case DEFINITIONS: field.set(command, definitions)
                //case PARAMS: field.set(command, params)
                switch (str){
                    case "@math.In(arg=STACK)":{
                        field.set(cmd, stack);
                        break;
                    }
                    case "@math.In(arg=VALUES)":{
                        field.set(cmd, map);
                        break;
                    }
                    case "@math.In(arg=TOKENS)":{
                        field.set(cmd, tokens);
                        break;
                    }
                }
            }

            //Фабрика возврщает готовый объект command, у которого установлены все поля

        } catch (ClassNotFoundException e) {
            System.out.println("Класс из файла Properties не найден");
        } catch (InstantiationException e) {
            System.out.println("Ошибка создания экземпляра класса: InstantiationException");
        } catch (IllegalAccessException e) {
            System.out.println("Ошибка создания экземпляра класса: IllegalAccessException");
        }

        return cmd;
    }

    public static Stack<Double> getStack() {
        return stack;
    }
}
