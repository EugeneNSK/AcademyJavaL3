package math;

import exception.CalcException;

import java.util.Stack;

import static java.lang.Double.NaN;

// Квадратный корень
public class Sqrt extends Command {
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Sqrt() {
    }

    public Sqrt(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        if (stack.size()>0 && stack.lastElement()>0){
            double d = Math.sqrt(stack.pop());
            if(d != NaN) {
                stack.push(d);
                System.out.println("Stack после sqrt :" + stack);
            }
        }
        else{
            throw new CalcException("Sqrt: not enough stack or negative value");
        }
    }
}
