package ru.otus.cachehw.menu;

public interface Emulator {

    void setDirectory(String directory);

    String getFile(String fileName);

    void uploadFile(String fileName);
}
