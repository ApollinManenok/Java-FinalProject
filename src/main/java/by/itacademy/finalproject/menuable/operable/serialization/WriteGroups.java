package by.itacademy.finalproject.menuable.operable.serialization;


import by.itacademy.finalproject.domain.School;

import java.io.File;

public abstract class WriteGroups implements FileSchoolSerialization {
    private File file;
    private String source;
    private School school;

    public WriteGroups(School school, File file) {
        this.school = school;
        this.source = file.getName();
        this.file = file;
    }

    public WriteGroups(School school, String source) {
        this.school = school;
        this.source = source;
        this.file = new File(this.source);
    }

    @Override
    public School getSchool() {
        return school;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String getSource() {
        return source;
    }
}
