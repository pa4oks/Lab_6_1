package org.example.manager.command;

import java.util.Scanner;
import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

import static org.example.manager.serializer.CollectionManager.removeByID;

public class RemoveById extends Command {
    public RemoveById() {
        super("remove_by_id");
    }
    @Override
    public void execute() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        long id;
        while (true) {
            System.out.println("Введите ID: ");
            try {
                String input = in.nextLine();
                id = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        removeByID(id);
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return " удалить элемент из коллекции по его id";
    }
}
