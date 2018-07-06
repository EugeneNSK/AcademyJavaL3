package math;

import exception.CalcException;

import java.util.Map;
import java.util.Stack;

// Деление
public class Division extends Command {
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Division() {
    }

    public Division(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        if (stack.size()>=2){
            double div=stack.pop();
            div/=stack.pop();
            stack.push(div);
            System.out.println("Stack после деления :" +stack);
        }
        else{
            throw new CalcException("Division: not enough stack");
        }
    }
}
