package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.result.Result;

/**
 * Created by phip123 on 24.12.2016.
 */
public interface CopyProcess {

    /**
     * Copies everything from source to destination.
     * Source and destination will be set on creation of the instance.
     * Files in destination will be overwritten if modified.
     * @return information about the process
     */
    Result start ();

}
