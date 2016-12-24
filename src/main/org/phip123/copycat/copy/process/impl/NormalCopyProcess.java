package org.phip123.copycat.copy.process.impl;

import org.phip123.copycat.copy.process.CopyProcess;
import org.phip123.copycat.copy.result.Result;

import java.util.Optional;

/**
 * Created by phip123 on 24.12.2016.
 */
public class NormalCopyProcess implements CopyProcess {

    public Optional<Result> start(String source, String destination) {
        return Optional.empty();
    }
}
