package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.process.configuration.Configuration;

/**
 * Creates various instances to start a copy process
 */
public class ProcessFactory {


    public Process newLocalProcess(Configuration config) {
        return new LocalProcess(config.getSource(),config.getDestination());
    }
}
