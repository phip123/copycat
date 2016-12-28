package org.phip123.copycat.copy.process.configuration;

/**
 * Created by phip123 on 28.12.2016.
 */
public interface Configuration {

    void setSource(String source);
    String getSource();
    void setDestination(String destination);
    String getDestination();


    static LocalConfiguration getLocalConfig() {
        return new LocalConfiguration();
    }
}
