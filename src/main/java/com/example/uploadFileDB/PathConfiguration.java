package com.example.uploadFileDB;

import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class PathConfiguration {
    private final String location = "scaricati";

    public Path getPathLocation(){
        return Path.of(location);
    }
}
