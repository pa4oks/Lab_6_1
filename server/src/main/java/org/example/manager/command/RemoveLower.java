package org.example.manager.command;
import java.util.Scanner;
import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

import static org.example.manager.serializer.CollectionManager.priorityQueue;

public class RemoveLower extends Command{
    public RemoveLower(){
        super("remove_lower");
    }
    @Override
    public void execute() {
        long id;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите id элемента, элементы меньшие которого хотите удалить");
            try {
                String input = in.nextLine();
                id = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        long lastElementUnderDelete = id;
        priorityQueue.removeIf(item -> item.getId() < lastElementUnderDelete);
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
