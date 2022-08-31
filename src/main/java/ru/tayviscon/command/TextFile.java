package ru.tayviscon.command;

public class TextFile {
    private String name;

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
