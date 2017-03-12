package common;

import javaslang.control.Try;

public abstract class LongLike<T extends LongLike> {

    private final long value;

    protected LongLike(final long value) {
        this.value = validated(value).get();
    }

    private Try<Long> validated(final long id) {
        return Try.success(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final LongLike<?> that = (LongLike<?>) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }

    public long toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
