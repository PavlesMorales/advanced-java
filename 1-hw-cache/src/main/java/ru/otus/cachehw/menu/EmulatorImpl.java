package ru.otus.cachehw.menu;

import ru.otus.cachehw.cache.MyCache;
import ru.otus.cachehw.cache.SoftRefCache;
import ru.otus.cachehw.cache.WeakRefCache;
import ru.otus.cachehw.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;

public class EmulatorImpl implements Emulator {

    private static final String SOFT_REF_TYPE = "SOFT";
    private static final String WEAK_REF_TYPE = "WEAK";

    private Path directory;

    private final MyCache<String, String> cache;

    private EmulatorImpl(MyCache<String, String> cache) {
        this.cache = cache;
    }

    public static EmulatorImpl of(String refType) {
        if (SOFT_REF_TYPE.equals(refType)) {
            System.out.println("Create Emulator with SOFT_REF_TYPE");
            return new EmulatorImpl(new SoftRefCache<>(new HashMap<>()));
        } else if (WEAK_REF_TYPE.equals(refType)) {
            System.out.println("Create Emulator with WEAK_REF_TYPE");
            return new EmulatorImpl(new WeakRefCache<>(new HashMap<>()));
        }
        return of();
    }

    public static EmulatorImpl of() {
        System.out.println("Create default Emulator with WEAK_REF_TYPE");
        return new EmulatorImpl(new WeakRefCache<>(new HashMap<>()));
    }

    @Override
    public void setDirectory(String directory) {
        final Path pathToDirectory = Path.of(directory);
        if (!Files.exists(pathToDirectory) || !Files.isDirectory(pathToDirectory)) {
            throw new NotFoundException("Directory not exists: %s".formatted(directory));
        }
        this.directory = pathToDirectory;
    }

    @Override
    public String getFile(String fileName) {
        String content = cache.get(fileName);
        if (Objects.isNull(content)) {
            try {
                content = Files.readString(directory.resolve(fileName));
                cache.put(fileName, content);
            } catch (IOException e) {
                throw new NotFoundException("Error when read file: %s".formatted(fileName));
            }
        }
        return content;
    }

    @Override
    public void uploadFile(String fileName) {
        try {
            String content = Files.readString(directory.resolve(fileName));
            cache.put(fileName, content);
        } catch (IOException e) {
            throw new NotFoundException("Error when upload file to cache: %s".formatted(fileName));
        }
    }
}
