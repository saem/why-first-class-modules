package user;

import common.LongLike;

public final class UserId extends LongLike<UserId> {
    private UserId(final Long rawLong) { super(rawLong); }

    public static UserId unsafeFromLong(final long unsafeLong) { return new UserId(unsafeLong); }
}
