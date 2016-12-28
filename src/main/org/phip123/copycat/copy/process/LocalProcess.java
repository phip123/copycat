package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.result.Result;

/**
 * This class is used to copy files. Instances are immutable
 */
class LocalProcess implements Process {

    private final String source;
    private final String destination;

    LocalProcess(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Starts the copy process. The source and destination folder must be local
     * @return the result of the process
     */
    @Override
    public Result start() {
        return Result.getEmptyCopyResult();
    }
}
