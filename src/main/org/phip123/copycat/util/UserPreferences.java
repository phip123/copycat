package org.phip123.copycat.util;

import java.io.File;

/**
 * Created by philipp on 12/25/16.
 */
public class UserPreferences {

    private File defaultDirectory;

    public File getDefaultDirectory() {
        return defaultDirectory;
    }

    public void setDefaultDirectory(File defaultDirectory) {
        this.defaultDirectory = defaultDirectory;
    }
}
