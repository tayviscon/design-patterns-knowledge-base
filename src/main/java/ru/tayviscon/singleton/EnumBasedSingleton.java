package ru.tayviscon.singleton;

public enum EnumBasedSingleton {
    INSTANCE("Initial class info");
    private String info;

    private EnumBasedSingleton(String info) {
        this.info = info;
    }

    public EnumBasedSingleton getInstance() {
        return INSTANCE;
    }
}
