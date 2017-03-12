package cqrs;

@FunctionalInterface
public interface CommandIdGeneartor {
    CommandId generate();
}
