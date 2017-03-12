package infrastructure;

@FunctionalInterface
public interface Metrics {
    void count(final String key);
}
