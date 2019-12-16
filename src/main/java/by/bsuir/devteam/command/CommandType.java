package by.bsuir.devteam.command;

import by.bsuir.devteam.command.common.ShowBusinessAnalystsCommand;
import by.bsuir.devteam.command.common.ShowDevelopersCommand;
import by.bsuir.devteam.command.common.ShowTL_SP;
import by.bsuir.devteam.command.common.ShowTestersCommand;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {

    DEVELOPERS_SHOW(new ShowDevelopersCommand()),
    TESTERS_SHOW(new ShowTestersCommand()),
    BUSINESS_ANALYSTS_SHOW(new ShowBusinessAnalystsCommand()),
    TL_SP_SHOW(new ShowTL_SP());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCurrentCommand() {
        return command;
    }

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType env : CommandType.values()) {
            lookup.put(env.toString(), env);
        }
    }

    public static CommandType getCommand(String type) {
        return lookup.get(type);
    }
}
