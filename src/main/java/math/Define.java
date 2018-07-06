package math;

import exception.CalcException;

import java.util.HashMap;

//Установка
public class Define extends Command {
    @In(arg = "VALUES")
    private HashMap<String, Double> map;
    @In(arg="TOKENS")
    private String[] tokens;

    public Define() {
    }

    public Define(HashMap<String, Double> map, String[] args) {

        this.map = map;
        this.tokens = args;
    }

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