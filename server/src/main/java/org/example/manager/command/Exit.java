package org.example.manager.command;
import org.example.manager.recources.*;
import org.example.manager.serializer.*;
import org.example.manager.command.*;
import org.example.manager.deserializer.*;
import org.example.manager.system.*;

public class Exit extends Command {

    public Exit() {
        super("exit");
    }

    @Override
    public void execute() {
        System.out.println("Завершение программы...");
        System.exit(0); // 0 обычно означает успешное завершение
    }

    @Override
    public String getHelp() {
        return "завершение программы (без сохранения в файл)";
    }
}