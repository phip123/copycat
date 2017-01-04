package org.phip123.copycat.copy.process;

import org.phip123.copycat.copy.result.Result;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * This class is used to copy files. Instances are immutable
 */
final class LocalProcess implements Process {

    private final File source;
    private final File destination;
    private int hashCode;
    private final static Logger log = Logger.getLogger(LocalProcess.class.getSimpleName());

    LocalProcess(String source, String destination) {
        this.source = new File(source);
        this.destination = new File(destination);
    }

    /**
     * Starts the copy process. The source and destination folder must be local
     * @return the result of the process
     */
    @Override
    public Result start() {
        log.info("Start " + this.toString());

        return Result.getEmptyCopyResult();
    }

    /**
     * Copies the whole directory {@code source} into the given destination {@code destination}
     * @param source the source directory
     * @param destination the destination directory
     */
    private Result copyDirectory(final Path source, final Path destination) {
        //Files.walk(source)
          //      .reduce(Result.getEmptyCopyResult(),(total,file) -> (copyFile(source,file,destination)  ?  : total));
    }

    /**
     /**
     * Copies the file {@code source} into the given destination directory {@code destination}
     * @param source the file to copy
     * @param destination the directory in which the file will be copied
     * @return if any error happens this method will return false otherwise true
     */
    private boolean copyFile(Path source,Path file,Path destination) {
        Path rel = source.relativize(file);
        final Path finalDestination = source.resolve(rel);

        if (rel.toString().length() > 0) {
            try {
                Files.copy(file, finalDestination);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof LocalProcess)) return false;

        LocalProcess that = (LocalProcess) o;

        return source.equals(that.source) && destination.equals(that.destination);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            hashCode = 31 * source.hashCode();
            hashCode = 31 * hashCode + destination.hashCode();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return "LocalProcess{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
