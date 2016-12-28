package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.result.Result;

/**
 * Is used to copy files. Must be on the local drive. Is immutable
 */
class NormalCopyProcess implements CopyProcess {

    private final String source;
    private final String destination;

    NormalCopyProcess (String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public Result start() {
        return Result.emptyCopyResult();
    }
}
