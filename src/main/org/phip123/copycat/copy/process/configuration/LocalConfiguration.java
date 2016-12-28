package org.phip123.copycat.copy.process.configuration;

/**
 * Created by phip123 on 24.12.2016.
 */
class LocalConfiguration implements Configuration {

    private String source;
    private String destination;

    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
