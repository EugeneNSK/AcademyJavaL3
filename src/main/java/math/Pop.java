package math;

import exception.CalcException;

import java.util.Stack;

//Удаление последнего элемента стэка
public class Pop extends Command{
    @In(arg = "STACK")
    private Stack<Double> stack;

    public Pop() {
    }

    public Pop(Stack<Double> stack) {

        this.stack = stack;
    }

    @Override
    public void execute() throws CalcException {

        if (stack.size()>0){
            stack.pop();
            System.out.println("Stack после Pop :" +stack);
        }
        else{
            throw new CalcException("Pop: not enough stack");
        }
    }
}
