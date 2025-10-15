package ru.otus.cachehw;

import ru.otus.cachehw.menu.Emulator;
import ru.otus.cachehw.menu.EmulatorImpl;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static final int SET_DIR = 1;

    public static final int GET_CONTENT = 2;

    public static final int UPLOAD_CONTENT = 3;

    public static final String MENU = """
                Enter 1, for set directory.
                Enter 2, for get content.
                Enter 3, for upload file.
                Enter any number for Exit.
            """;

    public static final String ENTER_DIRECTORY = "enter directory";
    public static final String ENTER_FILE_NAME = "enter filename";
    public static final String SUCCESS_SET_DIR = "Success set directory: %s%n";
    public static final String SUCCESS_UPLOAD_FILE ="Success upload file to cache: %s%n";
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Emulator emulator;
        if (Objects.nonNull(args) && args.length > 0) {
            String refType = args[0];
            emulator = EmulatorImpl.of(refType);
        } else {
            emulator = EmulatorImpl.of();
        }
        run(emulator, scanner);
    }

    static void run(final Emulator emulator, final Scanner scanner) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            final String input = scanner.nextLine();
            final int userChoice = readIntChoice(input);
            System.out.println(userChoice);
            if (SET_DIR == userChoice) {
                System.out.println(ENTER_DIRECTORY);
                String directory = scanner.nextLine();
                emulator.setDirectory(directory);
                System.out.printf(SUCCESS_SET_DIR, directory);
            } else if (GET_CONTENT == userChoice) {
                System.out.println(ENTER_FILE_NAME);
                String fileName = scanner.nextLine();
                String result = emulator.getFile(fileName);
                System.out.println(result);
            } else if (UPLOAD_CONTENT == userChoice) {
                String fileName = scanner.nextLine();
                emulator.uploadFile(fileName);
                System.out.printf(SUCCESS_UPLOAD_FILE, fileName);
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }

    static int readIntChoice(String in) {
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
