package cqrs;

import infrastructure.ForeignTrace;
import javaslang.control.Try;

@FunctionalInterface
public interface EventStore {
    /**
     * Here the traceId is in the command, so that's super if we want that to rest in the database, and the database
     * can carry that forward for logging as well, so that helps
     */
    Try<Result> write(final Command command);

    abstract class Result {
        public final EventId eventId;

        protected Result(final EventId eventId) { this.eventId = eventId; }
    }

    abstract class Command {
        public final CommandId commandId;
        public final ActorId actorId;
        public final ForeignTrace trace;

        protected Command(
                final CommandId commandId,
                final ActorId actorId,
                final ForeignTrace trace
        ) {
            this.commandId = commandId;
            this.actorId   = actorId;
            this.trace     = trace;
        }
    }
}
