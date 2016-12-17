package io.ridgway.springdemo.utils;

public class Environment {

    public boolean isRunningInJar() {
        return getClass().getProtectionDomain().getCodeSource().getLocation().getProtocol().toLowerCase().equals("jar");
    }

}
