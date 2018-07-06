package math;

import exception.CalcException;

import java.util.Stack;

//Печать элемента стека
public class Print extends Command {
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Print() {
    }

    public Print(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        if (stack.size()>0){
            System.out.println("Верхний элемент стэка: "+ stack.peek());
        }
        else{
            throw new CalcException("Print: not enough stack");
        }
    }
}
