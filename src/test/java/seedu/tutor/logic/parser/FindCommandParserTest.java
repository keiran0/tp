package seedu.tutor.logic.parser;

import static seedu.tutor.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.tutor.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.tutor.logic.commands.FindCommand;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }


}
