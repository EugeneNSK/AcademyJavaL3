package math;

import exception.CalcException;

import java.util.Stack;

import static java.lang.Double.NaN;

// Квадратный корень
public class Sqrt implements Command {
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute() throws CalcException {

        if (stack.size()>0 && stack.lastElement()>0){
            double d = Math.sqrt(stack.pop());
            if(d != NaN) {
                stack.push(d);
//                System.out.println("Stack после sqrt :" + stack);
            }
        }
        else{
            throw new CalcException("Sqrt: not enough stack or negative value");
        }
    }

    @Override
    public String toString() {
        return "Sqrt";
    }
}
