package org.phip123.copycat.util;

import java.io.File;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 * Created by philipp on 12/25/16.
 */
public enum UserPreferences {

    INSTANCE;
    private final static Logger log = Logger.getLogger(UserPreferences.class.getSimpleName());
    private final static String KEY_DIRECTORY = "default_dir";
    private final static String DEFAULT_DIR = System.getProperty("user.home");

    private Preferences preferences;

    UserPreferences () {
        this.preferences = Preferences.userRoot();
    }

    public File getDefaultDirectory() {
        return new File(this.preferences.get(KEY_DIRECTORY,DEFAULT_DIR));
    }

    public void setDefaultDirectory(File defaultDirectory) {
        this.preferences.put(KEY_DIRECTORY,defaultDirectory.getAbsolutePath());
    }

}
