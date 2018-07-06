package math;

import exception.CalcException;

import java.util.Stack;

// Умножение
public class Multi extends Command {
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Multi() {
    }

    public Multi(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        double mult=1;

        if (stack.size()>=2){
            for (int i=0; i<2; i++){
                mult*= stack.pop();
            }
            stack.push(mult);
        }
        else{
            throw new CalcException("Empty stack by Multi");
        }

        System.out.println("Stack после умножения :" +stack);
    }
}
