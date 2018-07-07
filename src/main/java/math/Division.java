package math;

import exception.CalcException;

import java.util.Map;
import java.util.Stack;

// Деление
public class Division implements Command {
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute() throws CalcException {

        if (stack.size()>=2){
            double div=stack.pop();
            div/=stack.pop();
            stack.push(div);
//            System.out.println("Stack после деления :" +stack);
        }
        else{
            throw new CalcException("Division: not enough stack");
        }
    }

    @Override
    public String toString() {
        return "Division";
    }
}
