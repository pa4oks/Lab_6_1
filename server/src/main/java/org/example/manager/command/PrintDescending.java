package org.example.manager.command;

import java.util.*;

import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

import static org.example.manager.serializer.CollectionManager.priorityQueue;

public class PrintDescending extends Command {
    public PrintDescending() {
        super("print_descending");
    }
    @Override
    public void execute() throws IllegalAccessException {
        // Создаем копию PriorityQueue.  Так как используется naturalOrder(),
        // нам не нужно передавать компаратор.
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        // Преобразуем в ArrayList для сортировки
        List<LabWork> reversedQueue = new ArrayList<>(queueCopy);

        // Сортируем ArrayList в обратном порядке.  Теперь LabWork должен implements Comparable
        reversedQueue.sort(Collections.reverseOrder());

        System.out.println("Элементы в порядке убывания: ");
        for (LabWork labWork : reversedQueue) {
            labWork.ShowLabWork(labWork);
            System.out.println();
        }
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "";
    }
}
