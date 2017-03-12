package infrastructure;

import infrastructure.ForeignTrace;

@FunctionalInterface
public interface Logger {
    /**
     * The crappy thing here is that I have to pass in levels, or create lots of little methods
     *
     * So on the one hand I lose this nice little grouping of methods, auto-completetion and all that jazz...
     * or I have lots of little functions I need to pass into the classes such as the one above to
     */
    void log(final Level level, final ForeignTrace traceId, final String message);

    interface Level {}

    enum BasicLogLevels implements Level {
        TRACE,
        DEBUG,
        ERROR,
        WARN
    }
}

