package org.phip123.copycat.copy.result;

/**
 * Represents the result of a copyprocess
 */
public class CopyResult implements Result{

    private final ResultType type;

    CopyResult(ResultType type) {
            this.type = type;
    }

    @Override
    public ResultType getResultType() {
        return type;
    }
}
