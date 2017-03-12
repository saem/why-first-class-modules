package cqrs;

import common.LongLike;

public final class ActorId extends LongLike<ActorId> {
    private ActorId(final Long rawLong) { super(rawLong); }

    public static ActorId unsafeFromLong(final long unsafeLong) { return new ActorId(unsafeLong); }
}
