package main;

import data.CommandFactory;
import data.Parser;
import exception.CalcException;
import math.Command;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class RunTest{

    @Test
    public void main(){

        Class<?> aClass = getClass();
        InputStream is = aClass.getClassLoader().getResourceAsStream("data");

        List<Command> commands = Parser.pars(is);
        commands.forEach(c-> {
            try {
                c.execute();
            } catch (CalcException e) {
                e.printStackTrace();
            }
        });
        assertEquals(5.0, CommandFactory.getStack().peek(), 0.1);
    }

}