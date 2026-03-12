package seedu.tutor.logic.commands;

import seedu.tutor.commons.core.index.Index;
import seedu.tutor.model.Model;
import seedu.tutor.model.relation.Relation;

/**
 * skeleton code for RelateAddCommand
 */
public class RelateAddCommand extends RelateCommand {

    public static final String MESSAGE_SUCCESS = "";

    /**
     * Creates a RelateAddCommand.
     * This constructor is package-private to restrict creation
     * to the command factory in {@link RelateCommand}.
     */
    RelateAddCommand(Index index, Relation relation) {
        //
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
