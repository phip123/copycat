package org.phip123.copycat.copy.result;

import java.util.Optional;

/**
 * Represents the result of a copyprocess
 */
final class LocalResult implements Result{

    private final ResultType type;
    private final Exception exception;

    LocalResult(ResultType type) {
            this.type = type;
            this.exception = null;
    }

    public LocalResult(ResultType error, Exception ex) {
        this.type = error;
        this.exception = ex;
    }

    @Override
    public ResultType getResultType() {
        return type;
    }

    @Override
    public Exception getException() {
        return exception;
    }
}
