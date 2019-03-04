package seedu.address.logic;

import java.nio.file.Path;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyRestOrRant;
import seedu.address.model.order.OrderItem;
import seedu.address.model.person.Person;
import seedu.address.model.table.Table;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the RestOrRant.
     *
     * @see seedu.address.model.Model#getRestOrRant()
     */
    ReadOnlyRestOrRant getRestOrRant();


    /** Returns an unmodifiable view of the filtered list of order items */
    ObservableList<OrderItem> getFilteredOrderItemList();

    /** Returns an unmodifiable view of the filtered list of tables */
    ObservableList<Table> getFilteredTableList();


    /**
     * Returns an unmodifiable view of the list of commands entered by the user.
     * The list is ordered from the least recent command to the most recent command.
     */
    ObservableList<String> getHistory();

    /**
     * Returns the user prefs' RestOrRant orders file path.
     */
    Path getOrdersFilePath();

    /**
     * Returns the user prefs' RestOrRant tables file path.
     */
    Path getTablesFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Selected order item in the filtered order item list.
     * null if no order item is selected.
     *
     * @see seedu.address.model.Model#selectedOrderItemProperty()
     */
    ReadOnlyProperty<OrderItem> selectedOrderItemProperty();

    /**
     * Selected table in the filtered table list.
     * null if no table is selected.
     *
     * @see seedu.address.model.Model#selectedTableProperty()
     */
    ReadOnlyProperty<Table> selectedTableProperty();

    /**
     * Sets the selected order item in the filtered order item list.
     *
     * @see seedu.address.model.Model#setSelectedOrderItem(OrderItem)
     */
    void setSelectedOrderItem(OrderItem orderItem);

    /**
     * Sets the selected order item in the filtered table list.
     *
     * @see seedu.address.model.Model#setSelectedTable(Table)
     */
    void setSelectedTable(Table table);

    /**
     * Changes current mode of RestOrRant.
     */
    void changeMode(Mode mode);
}
