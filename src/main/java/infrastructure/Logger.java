package infrastructure;

@FunctionalInterface
public interface Logger {
    /**
     * The crappy thing here is that I have to pass in levels, or create lots of little methods
     *
     * So on the one hand I lose this nice little grouping of methods, auto-completion and all that jazz...
     * or I have lots of little functions I need to pass into various classes in order to support different levels
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