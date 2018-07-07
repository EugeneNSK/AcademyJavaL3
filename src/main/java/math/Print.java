package math;

import exception.CalcException;

import java.util.Stack;

//Печать элемента стека
public class Print extends Command {
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;

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
