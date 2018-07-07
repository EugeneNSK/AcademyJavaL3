package math;

import exception.CalcException;

import java.util.Stack;

//Удаление последнего элемента стэка
public class Pop implements Command{
    @In(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute() throws CalcException {

        if (stack.size()>0){
            stack.pop();
//            System.out.println("Stack после Pop :" +stack);
        }
        else{
            throw new CalcException("Pop: not enough stack");
        }
    }

    @Override
    public String toString() {
        return "Pop";
    }
}
