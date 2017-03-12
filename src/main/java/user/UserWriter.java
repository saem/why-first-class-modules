package user;

import common.LongLike;
import common.StringLike;
import cqrs.*;
import infrastructure.*;
import javaslang.control.Try;

public final class UserWriter {

    private final Logger logger;
    private final Metrics metrics;
    private final EventStore db;
    private final CommandIdGeneartor cidGenerator;

    public UserWriter(
            final Logger logger,
            final Metrics metrics,
            final EventStore db,
            final CommandIdGeneartor cidGenerator
    ) {
        this.logger       = logger;
        this.metrics      = metrics;
        this.db           = db;
        this.cidGenerator = cidGenerator;
    }

    public Try<CreateResult> createUser(
            final Username username,
            final PlainTextPassword password,
            final ActorId actorId,
            final ForeignTrace trace
    ) {
        metrics.count("user.create");

        final CreateCommand cmd = new CreateCommand(username, password, cidGenerator.generate(), actorId, trace);

        // some side-effects to the database

        return Try.success(new CreateResult(null));
    }

    public Try<DisableResult> disableUser(
            final UserId userId,
            final ActorId actorId,
            final ForeignTrace trace
    ) {
        metrics.count("user.disable");

        final DisableCommand cmd = new DisableCommand(userId, cidGenerator.generate(), actorId, trace);

        // some side-effects to the database

        return Try.success(new DisableResult(null));
    }

    public static class CreateCommand extends EventStore.Command {
        public final Username username;
        public final PlainTextPassword password;

        public CreateCommand(
                final Username username,
                final PlainTextPassword password,
                final CommandId commandId,
                final ActorId actorId,
                final ForeignTrace trace
        ) {
            super(commandId, actorId, trace);

            this.username = username;
            // not bothering to encrypt here
            this.password = password;
        }
    }

    public static class CreateResult extends EventStore.Result {
        public CreateResult(EventId eventId) {
            super(eventId);
        }
    }

    public static class DisableCommand extends EventStore.Command {
        public final UserId userId;

        public DisableCommand(
                final UserId userId,
                final CommandId commandId,
                final ActorId actorId,
                final ForeignTrace trace
        ) {
            super(commandId, actorId, trace);
            this.userId = userId;
        }
    }

    public static class DisableResult extends EventStore.Result {
        protected DisableResult(EventId eventId) {
            super(eventId);
        }
    }
}

// Lame attempt at other module interfaces


// CQRS stuff

// Data Types because type safe or something, man I wish I had type aliases


// Common Type Junk

