package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalTutorMap;

import org.junit.jupiter.api.Test;

import seedu.address.model.TutorMap;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyTutorMap_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyTutorMap_success() {
        Model model = new ModelManager(getTypicalTutorMap(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalTutorMap(), new UserPrefs());
        expectedModel.setTutorMap(new TutorMap());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
