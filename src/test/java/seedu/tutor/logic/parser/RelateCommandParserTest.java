package seedu.tutor.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.tutor.logic.commands.RelateCommand;
import seedu.tutor.logic.parser.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RelateCommandParserTest {

    private RelateCommandParser parser = new RelateCommandParser();
    String[] success_args = new String[] {"1 a\\test/test/test/test", "1 d\\1/1/1/1",
            "10    d\\   h sdw /  ewd as   qwe/adw  xdww/  dwdsd       qwdqw"};
    String[] failure_args = new String[] {"", "1", "1 a\\test", "1 a\\test/test", "1 a\\test/test/test",
            "1 a\\test/test/test/test/test", "a\\test/test/test/test"};

    @Test
    public void parser_RelateCommand_success() {
        for (String args: success_args) {
            Object o = new Object();
            try {
                o = parser.parse(args);
            } catch (ParseException pe) {
                assert(false);
            }
            assertFalse(!(o instanceof RelateCommand));
        }
    }

    @Test
    public void parser_RelateCommand_failure() {
        int errorCount = failure_args.length;
        int testCount = 0;
        for (String args: failure_args) {
            Object o = new Object();
            try {
                o = parser.parse(args);
            } catch (ParseException pe) {
                testCount += 1;
            }
            if (o instanceof RelateCommand) {System.out.println(args);}
        }
        assertEquals(errorCount, testCount);
    }
}
