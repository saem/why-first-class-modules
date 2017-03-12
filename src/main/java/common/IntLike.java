package common;

import javaslang.control.Try;

public abstract class IntLike<T extends IntLike> {

    private final int value;

    protected IntLike(final int value) {
        this.value = validated(value).get();
    }

    private Try<Integer> validated(final int id) {
        return Try.success(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final IntLike<?> that = (IntLike<?>) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    public int toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
