package org.phip123.copycat.copy.result;

/**
 * Represents the result of a copyprocess
 */
class LocalResult implements Result{

    private final ResultType type;

    LocalResult(ResultType type) {
            this.type = type;
    }

    @Override
    public ResultType getResultType() {
        return type;
    }
}
