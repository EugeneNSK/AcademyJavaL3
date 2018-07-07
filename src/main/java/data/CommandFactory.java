package data;

import math.Command;
import math.In;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

public class CommandFactory {

    private static final Logger logger = Logger.getLogger(CommandFactory.class);

    private static Stack <Double> stack = new Stack();
    private static Map <String, Double> map = new HashMap<>();
    private static String [] tokens;

    private static Properties prop;

    static {

        prop = new Properties();
        try {
            prop.load(CommandFactory.class.getClassLoader().getResourceAsStream("commands.properties"));
        } catch (Exception e) {
            System.out.println("Ошибка загрузки конфига");
        }

    }

    public static Command create (String[] args){

        Command cmd = null;
        Class<?> aClass;
        tokens = args;
        String s = prop.getProperty(args[0]);

        try {
            aClass = Class.forName(s);
            cmd = (Command) aClass.newInstance();
            Field [] classFields = aClass.getDeclaredFields();

            for (Field field:classFields){
                field.setAccessible(true); //разрешение редактирования private полей
                In annotation = field.getAnnotation(In.class);

                switch (annotation.arg()){
                    case STACK:{
                        field.set(cmd, stack);
                        break;
                    }
                    case VALUES:{
                        field.set(cmd, map);
                        break;
                    }
                    case TOKENS:{
                        field.set(cmd, tokens);
                        break;
                    }
                }
            }

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
