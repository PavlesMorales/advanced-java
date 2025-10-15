package ru.antonov;


import java.util.logging.Logger;

public class Jlink {

    private static final Logger LOG = Logger.getLogger(Jlink.class.getName());

    public static void main(String[] args) {
        final var javaVersion = System.getProperty("java.version");
        final var javaRuntimeName = System.getProperty("java.runtime.name");
        final var javaVmName = System.getProperty("java.vm.name");
        final var javaHome = System.getProperty("java.home");
        String info = """ 
                                
                version: [%s]
                runtime: [%s]
                vm:      [%s]
                home:    [%s]
                """.formatted(javaVersion, javaRuntimeName, javaVmName, javaHome);
        LOG.info(info);
    }
}