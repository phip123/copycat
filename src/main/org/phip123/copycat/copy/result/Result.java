package org.phip123.copycat.copy.result;

/**
 * Created by phip123 on 24.12.2016.
 */
public interface Result {

    ResultType getResultType();

    /**
     * If the type is not set to error this method will return null
     * @return the exception
     */
    Exception getException();

    static Result getEmptyCopyResult() {
        return new LocalResult(ResultType.EMPTY);
    }

    static Result getExceptionResult(Exception ex) {
        return new LocalResult(ResultType.ERROR,ex);
    }
}
