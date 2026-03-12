package seedu.tutor.logic.commands;

import seedu.tutor.commons.core.index.Index;
import seedu.tutor.model.Model;
import seedu.tutor.model.relation.Relation;

/**
 * skeleton code for RelateDeleteCommand
 */
public class RelateDeleteCommand extends RelateCommand {

    public static final String MESSAGE_SUCCESS = "";

    /**
     * Creates a RelateDeleteCommand.
     * This constructor is package-private to restrict creation
     * to the command factory in {@link RelateCommand}.
     */
    RelateDeleteCommand(Index index, Relation relation) {
        //
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
