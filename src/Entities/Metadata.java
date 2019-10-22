package Entities;

import java.io.File;

public class Metadata {
    private final File instance;
    private final int registrySize;

    public Metadata(File instance, int registrySize) {
        this.instance = instance;
        this.registrySize = registrySize;
    }
    
}
