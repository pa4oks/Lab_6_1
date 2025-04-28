package org.example.manager.command;


import java.util.HashMap;


import static org.example.manager.serializer.CommandManager.commandList;

public class Help extends Command {
    public Help() {
        super("help");
    }
    @Override
    public void execute() {
        commandList.forEach((key, command) -> {
            System.out.println(key + ": " + command.getHelp());
        });
    }

    @Override
    public String getHelp() {
        return "выводит справку по доступным командам";
    }

   /* public static void register(HashMap<String,Command> stringCommandHashMap) {
        Help help = new Help();
        stringCommandHashMap.put(help.getName(), help);
    }*/
}

