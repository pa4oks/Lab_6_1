package org.example.manager.command;


import org.example.manager.recources.*;

import java.util.Scanner;

import static org.example.manager.serializer.CollectionManager.*;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }
    @Override
    public void execute() throws IllegalAccessException {
        priorityQueue.clear();
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "очистить коллекцию";
    }
}
