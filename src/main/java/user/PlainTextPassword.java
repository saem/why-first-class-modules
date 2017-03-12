package user;

import common.StringLike;

public final class PlainTextPassword extends StringLike<PlainTextPassword> {
    private PlainTextPassword(final String hashedPasswordString) { super(hashedPasswordString); }

    public static PlainTextPassword unsafeFromString(final String unsafeString) { return new PlainTextPassword(unsafeString); }
}
