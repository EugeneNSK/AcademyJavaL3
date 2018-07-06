package math;

import exception.CalcException;

public abstract class Command {

    abstract public void execute() throws CalcException;
}
