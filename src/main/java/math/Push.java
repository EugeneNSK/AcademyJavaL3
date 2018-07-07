package math;

import exception.CalcException;

import java.util.Map;
import java.util.Stack;

//Загрузка переменных в стэк
public class Push implements Command {
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;
    @In(arg = ArgType.VALUES)
    private Map<String, Double> map;
    @In(arg=ArgType.TOKENS)
    private String[] tokens;

    @Override
    public void execute() throws CalcException {

        try {
//            System.out.println("Сейчас будем пушить. Аргумент: " + tokens[1]);
            Double d = Double.parseDouble(tokens[1]);
//            System.out.println("Пушим double");
            stack.push(d);
        }
        catch (ArrayIndexOutOfBoundsException e1) {
            throw new CalcException("Push: variable not defined");
        }
        catch (NumberFormatException e2) {
//            System.out.println("Не double, а string");
            if (map.get(tokens[1])!= null) {
                Double k = map.get(tokens[1]);
                stack.push(map.get(tokens[1]));
            }
            else{
                throw new CalcException("Push: Wrong value");
            }
        }
        catch (NullPointerException e3) {
        }
//        System.out.println("Стэк после добавления переменных: " + stack);
    }

    @Override
    public String toString() {
        return "Push";
    }
}
