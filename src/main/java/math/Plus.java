package math;

import exception.CalcException;

import java.util.Stack;

// Сложение
public class Plus implements Command {
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute() throws CalcException {

        double summ=0;
        if (stack.size()>=2){
            for (int i=0; i<2; i++){
                summ+= stack.pop();
            }
            stack.push(summ);
//            System.out.println("Stack после сложения :" +stack);
        }
        else{
            throw new CalcException("Plus: not enough stack");
        }
    }

    @Override
    public String toString() {
        return "Plus";
    }
}