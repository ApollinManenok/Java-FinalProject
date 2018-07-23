package by.itacademy.finalproject.menus.serializing.serialization;


import by.itacademy.finalproject.domain.School;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class UploadGroups implements URLSchoolSerialization {
    private static final Logger LOGGER = Logger.getLogger(UploadGroups.class.getName());
    private String source;
    private URL url;
    private School school;

    public UploadGroups(School school, String source) {
        this.school = school;
        try {
            this.source = source;
            this.url = new URL(this.source);
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, "Can't get url from " + this.source, e);
        }
    }

    public UploadGroups(School school, URL url) {
        this.school = school;
        this.url = url;
        this.source = url.getPath();
    }

    @Override
    public School getSchool() {
        return school;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public URL getUrl() {
        return url;
    }
}
