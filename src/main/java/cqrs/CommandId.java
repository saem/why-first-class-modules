package cqrs;

import common.LongLike;

public final class CommandId extends LongLike<CommandId> {
    private CommandId(final Long rawLong) { super(rawLong); }

    public static CommandId unsafeFromLong(final long unsafeLong) { return new CommandId(unsafeLong); }
}
