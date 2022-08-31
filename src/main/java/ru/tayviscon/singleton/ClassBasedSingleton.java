package ru.tayviscon.singleton;

public final class ClassBasedSingleton {
    private static ClassBasedSingleton INSTANCE;
    private String info = "Initial info class";

    private ClassBasedSingleton() {
    }

    public static ClassBasedSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ClassBasedSingleton();
        }

        return INSTANCE;
    }
}