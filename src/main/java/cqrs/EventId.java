package cqrs;

import common.LongLike;

public final class EventId extends LongLike<EventId> {
    private EventId(final Long rawLong) { super(rawLong); }

    public static EventId unsafeFromLong(final long unsafeLong) { return new EventId(unsafeLong); }
}
