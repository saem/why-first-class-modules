package infrastructure;

import common.StringLike;

public final class ForeignTrace extends StringLike<ForeignTrace> {
    private ForeignTrace(final String string) { super(string); }

    public static ForeignTrace unsafeFromString(final String unsafeString) { return new ForeignTrace(unsafeString); }
}
