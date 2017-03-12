package common;

import javaslang.control.Try;

public abstract class StringLike<T extends StringLike> {
    private final String value;

    protected StringLike(final String value) {
        this.value = validated(value).get();
    }

    private Try<String> validated(final String id) {
        return Try.success(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final StringLike<?> that = (StringLike<?>) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
