package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.result.Result;

import java.util.Optional;

/**
 * Created by phip123 on 24.12.2016.
 */
public interface CopyProcess {

    /**
     * Copies everything from source to destination.
     * Files in destination will be overwritten if modified.
     * @param source the source directory
     * @param destination the destination directory
     * @return information about the process
     */
    Optional<Result> start (String source, String destination);

}
