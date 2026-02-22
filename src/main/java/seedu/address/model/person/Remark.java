package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class Remark {

    public final String remark;

    public Remark(String input) {
        requireNonNull(input);
        remark = input;
    }

    @Override
    public String toString() {
        return remark;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Address)) {
            return false;
        }

        Remark otherRemark = (Remark) other;
        return remark.equals(otherRemark.remark);
    }

    @Override
    public int hashCode() {
        return remark.hashCode();
    }
}

