package seedu.tutor.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.tutor.logic.Messages.MESSAGE_DUPLICATE_FIELDS;
import static seedu.tutor.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.tutor.logic.parser.CliSyntax.PREFIX_NEW_SUBJECT;
import static seedu.tutor.logic.parser.CliSyntax.PREFIX_OLD_SUBJECT;

import java.util.HashSet;
import java.util.Set;

import seedu.tutor.logic.commands.ChangeSubjectCommand;
import seedu.tutor.logic.parser.exceptions.ParseException;
import seedu.tutor.model.label.Label;

/**
 * Parses input arguments and returns a new ChangeSubjectCommand object
 */
public class ChangeSubjectCommandParser implements Parser<ChangeSubjectCommand> {

    private static final String SUBJECT_NAME_ERROR = "Subject name should be alphanumerical.";

    /**
     * Parses the given {@code String} of arguments in the context of the ChangeSubjectCommand
     * and returns a ChangeSubjectCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ChangeSubjectCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NEW_SUBJECT, PREFIX_OLD_SUBJECT);


        // errors
        if (argMultimap.getAllValues(PREFIX_NEW_SUBJECT).isEmpty()
                || argMultimap.getAllValues(PREFIX_OLD_SUBJECT).isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ChangeSubjectCommand.MESSAGE_USAGE));
        }

        Set<String> oldSubject = new HashSet<>();
        Set<String> newSubject = new HashSet<>();
        if (!argMultimap.getAllValues(PREFIX_OLD_SUBJECT).isEmpty()) {
            oldSubject.addAll(argMultimap.getAllValues(PREFIX_OLD_SUBJECT));
        }
        if (!argMultimap.getAllValues(PREFIX_NEW_SUBJECT).isEmpty()) {
            newSubject.addAll(argMultimap.getAllValues(PREFIX_NEW_SUBJECT));
        }

        if (oldSubject.size() != 1 || newSubject.size() != 1) {
            throw new ParseException(String.format(MESSAGE_DUPLICATE_FIELDS + ChangeSubjectCommand.MESSAGE_USAGE));
        }

        Set<Label> oldSubjectLabel;
        Set<Label> newSubjectLabel;

        try {
            oldSubjectLabel = ParserUtil.parseLabel(oldSubject);
            newSubjectLabel = ParserUtil.parseLabel(newSubject);
        } catch (ParseException pe) {
            throw new ParseException(SUBJECT_NAME_ERROR);
        }

        return new ChangeSubjectCommand((Label) oldSubjectLabel.toArray()[0], (Label) newSubjectLabel.toArray()[0]);
    }
}
