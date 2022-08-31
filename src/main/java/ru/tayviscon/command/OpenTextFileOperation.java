package ru.tayviscon.command;

public class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;
    @Override
    public String execute() {
        return textFile.open();
    }
}
