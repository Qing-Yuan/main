package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.Mode;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.menu.MenuItem;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;

public class AddItemToMenuCommand extends Command {
    public static final String COMMAND_WORD = "addToMenu";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: "
            + PREFIX_CODE + "CODE "
            + PREFIX_NAME + "NAME "
            + PREFIX_PRICE + "PRICE "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CODE + "A02 "
            + PREFIX_NAME + "French Fries "
            + PREFIX_PRICE + "2.00";
    public static final String MESSAGE_SUCCESS = "New menu item added: %1$s";
    public static final String MESSAGE_DUPLICATE_MENU_ITEM = "This item already exists in the menu";
    public static final String MESSAGE_INCORRECT_MODE = "Incorrect Mode, unable to execute command. Enter menuMode";
    
    private final MenuItem toAdd;
    
    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddItemToMenuCommand(MenuItem item) {
        requireNonNull(item);
        toAdd = item;
    }
    
    @Override
    public CommandResult execute(Mode mode, Model model, CommandHistory history) throws CommandException {
        requireAllNonNull(mode, model);
        
        ObservableList<String> commandHistories = history.getHistory();
        int indexToCheck = commandHistories.size() - 1;
        if (!commandHistories.get(indexToCheck).equals("menuMode")) {
            throw new CommandException(MESSAGE_INCORRECT_MODE);
        }
        
        if (model.hasMenuItem(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MENU_ITEM);
        }
        
        model.addMenuItem(toAdd);
        model.updateRestOrRant();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddItemToMenuCommand // instanceof handles nulls
                && toAdd.equals(((AddItemToMenuCommand) other).toAdd));
    }
}
