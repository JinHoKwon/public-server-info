package com.jh.app.config;

import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class ApplicationConfiguration {
    public static final File PID_FILE = new File("application.pid");
}
