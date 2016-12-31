package org.phip123.copycat.copy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Created by phip123 on 12/30/16.
 */
public class LocalProcessTest {

    private static final Logger log = Logger.getLogger(LocalProcessTest.class.getSimpleName());
    private static final String SEP = FileSystems.getDefault().getSeparator();
    private static final String ROOT = System.getProperty("user.dir") + SEP + "src" + SEP + "test" + SEP + "resources" + SEP;
    private static final String SRC_TEST_DIR = ROOT + "src_test_dir" + SEP;
    private static final String DEST_TEST_DIR = ROOT + "dest_test_dir" + SEP;
    private static final String CONTENT_DIR = ROOT + "content" + SEP;
    private static final Path SRC_PATH = Paths.get(SRC_TEST_DIR);
    private static final Path DEST_PATH = Paths.get(DEST_TEST_DIR);


    @BeforeAll
    public static void setup() throws Exception {
        cleanDirectory(SRC_PATH);
        cleanDirectory(DEST_PATH);
        copyTestContent();
    }

    @AfterAll
    public static void cleanup() throws Exception {
        cleanDirectory(SRC_PATH);
        cleanDirectory(DEST_PATH);
    }


    @Test
    public void testCopy() throws Exception {
        //Files.walk(SRC_PATH).forEach(System.out::println);
    }


    /**
     * Copies the test content {@code CONTENT_DIR} into the test directory {@code SRC_TEST_DIR}
     * Will delete the directory {@code SRC_TEST_DIR} with it's content, if it exists
     * @throws Exception if IO fails or user doesn't have permissions to write. In addition if the content directory
     * doesn't exist will throw an IllegalStateException
     */
    private static void copyTestContent() throws Exception{
        Path src = Paths.get(SRC_TEST_DIR);
        Path content = Paths.get(CONTENT_DIR);

        if (!Files.isDirectory(content)) throw new IllegalStateException("No content to copy. Abort tests.");
        if (Files.exists(src)) cleanDirectory(src);

        Files.createDirectory(src);

        Files.walk(content)
                .forEach(file -> {
                    try {
                        Path rel = content.relativize(file);
                        Files.copy(file, src.resolve(rel));
                    } catch (IOException e) {
                        log.warning("error copy \n" + e.getMessage());
                    }
                });
    }

    /**
     * Deletes the given directory with all it's content. If the directory doesn't exist, nothing happens
     * http://stackoverflow.com/questions/35988192/java-nio-most-concise-recursive-directory-delete
     * @param path the directory to delete
     */
    private static void cleanDirectory (Path path) {
        try {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException ex) {
        }
    }

}
