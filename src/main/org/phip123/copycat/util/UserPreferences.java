package org.phip123.copycat.util;

import java.io.File;
import java.util.prefs.Preferences;

/**
 * Created by philipp on 12/25/16.
 */
public enum UserPreferences {

    INSTANCE;
    private final static String KEY_DIRECTORY = "default_dir";
    private final static String DEFAULT_DIR = "";

    private Preferences preferences;

    UserPreferences () {
        this.preferences = Preferences.userRoot();
    }

    public String getDefaultDirectory() {
        return this.preferences.get(KEY_DIRECTORY,DEFAULT_DIR);
    }

    public void setDefaultDirectory(File defaultDirectory) {
        this.preferences.put(KEY_DIRECTORY,defaultDirectory.getAbsolutePath());
    }
}
