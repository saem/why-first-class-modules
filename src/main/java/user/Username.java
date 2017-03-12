package user;

import common.StringLike;

public final class Username extends StringLike<Username> {
    private Username(final String usernameString) { super(usernameString); }

    public static Username unsafeFromString(final String unsafeString) { return new Username(unsafeString); }
}
