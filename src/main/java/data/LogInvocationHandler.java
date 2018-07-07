package data;

import math.Command;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
    private static final Logger logger = Logger.getLogger(CommandFactory.class);
    private final Command command;

    public LogInvocationHandler(Command command) {
        this.command = command;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("stack before "+ command +" : " + CommandFactory.getStack());
        Object result = method.invoke(command, args);
        logger.info("stack after "+ command +" : " + CommandFactory.getStack());
        return result;
    }

}
