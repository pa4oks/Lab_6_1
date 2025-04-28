package org.example.manager.command;

import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

public class Save extends Command {

    private final CSVCollectionManager csvCollectionManager;

    public Save(CSVCollectionManager csvCollectionManager) {
        super("save");
        this.csvCollectionManager = csvCollectionManager;
    }

    @Override
    public void execute() throws IllegalAccessException {
        csvCollectionManager.saveDataToFile(false); // false = перезапись
        System.out.println("Коллекция сохранена в файл.");
    }

    @Override
    public String getHelp() {
        return "сохранить коллекцию в файл";
    }
}