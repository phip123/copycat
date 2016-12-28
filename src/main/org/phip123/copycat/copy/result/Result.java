package org.phip123.copycat.copy.result;

/**
 * Created by phip123 on 24.12.2016.
 */
public interface Result {

    ResultType getResultType();

    static Result emptyCopyResult() {
        return new LocalResult(ResultType.EMPTY);
    }

}
