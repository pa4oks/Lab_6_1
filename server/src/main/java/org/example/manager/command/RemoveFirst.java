package org.example.manager.command;

import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

import static org.example.manager.serializer.CollectionManager.priorityQueue;

public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("remove first");
    }
    @Override
    public void execute() throws IllegalAccessException {
        priorityQueue.poll();
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "удалить первый элемент из коллекции";
    }
}
