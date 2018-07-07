package math;

import exception.CalcException;

import java.util.Map;

//Установка
public class Define extends Command {
    @In(arg = ArgType.VALUES)
    private Map<String, Double> map;
    @In(arg= ArgType.TOKENS)
    private String[] tokens;

    @Override
    public void execute() throws CalcException {

        try {
            String key = tokens[1];
            Double val = Double.parseDouble(tokens[2]);
            System.out.println( "key: " + key + " : val: " + val);
            map.put(key, val);
        }
        catch (ArrayIndexOutOfBoundsException ex1){
            throw new CalcException("Define: Переменная не определена");
        }
        catch (NumberFormatException ex2){
            throw new CalcException("Define: Значение переменной указано неверно");
        }
        catch (NullPointerException ex3) {
            throw new CalcException("Define: NPE");
        }
    }
}