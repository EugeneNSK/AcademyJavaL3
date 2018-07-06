package math;

import exception.CalcException;

import java.util.Stack;

// Вычитание
public class Minus extends Command {
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Minus() {
    }

    public Minus(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        if (stack.size()>=2){
            double razn = -stack.pop();
            razn += stack.pop();
            stack.push(razn);

            System.out.println("Stack после вычитания :" + stack);
        }
        else{
            throw new CalcException("Minus: not enough stack");
        }
    }
}
