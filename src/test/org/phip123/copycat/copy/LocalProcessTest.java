package org.phip123.copycat.copy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Created by philipp on 12/30/16.
 */
public class LocalProcessTest {

    private static final Logger log = Logger.getLogger(LocalProcessTest.class.getSimpleName());
    private static final String SEP = FileSystems.getDefault().getSeparator();
    private static final String ROOT = System.getProperty("user.dir") + SEP + "src" + SEP + "test" + SEP + "resources" + SEP;
    private static final String SRC_TEST_DIR = ROOT + "src_test_dir" + SEP;
    private static final String DEST_TEST_DIR = ROOT + "dest_test_dir" + SEP;
    private static final String CONTENT_DIR = ROOT + "content" + SEP;


    @BeforeAll
    public static void setup() throws Exception {
        cleanDirectory(SRC_TEST_DIR);
        cleanDirectory(DEST_TEST_DIR);
        copyTestContent(SRC_TEST_DIR);
    }

    private static void copyTestContent(String pathName) throws Exception{

    }

    private static void cleanDirectory (String pathName) {
        try {
            Path path = Paths.get(pathName);
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException ex) {

        }
    }

    @Test
    public void testCopy() {

    }

}
