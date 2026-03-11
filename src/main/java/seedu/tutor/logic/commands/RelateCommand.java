package seedu.tutor.logic.commands;

import seedu.tutor.commons.core.index.Index;
import seedu.tutor.model.relation.Relation;

/**
 * Creates subtype of RelateCommand.
 */
public abstract class RelateCommand extends Command{

    public static final String COMMAND_WORD = "relate";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the relations of the person identified ";

    /**
     * A factory for the creation of subtypes of RelateCommand.
     * @param type Type of {@code RelationCommand} that is intended by the user.
     * @param relation The relation object between two contacts.
     * @return Subtype of RelateCommand.
     */
    public static RelateCommand create(Index index, String type, Relation relation) {

        switch(type) {

        case "add" -> {
            return new RelateAddCommand(index, relation);
        }

        case "delete" -> {
            return new RelateDeleteCommand(index, relation);
        }

        default -> {
            // should not reach here
            return null;
        }

        }
    }
}
