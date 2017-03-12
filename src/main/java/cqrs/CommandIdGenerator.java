package cqrs;

@FunctionalInterface
public interface CommandIdGenerator {
    CommandId generate();
}
