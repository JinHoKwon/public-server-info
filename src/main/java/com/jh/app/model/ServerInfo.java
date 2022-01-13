package com.jh.app.model;

import lombok.Data;

@Data
public class ServerInfo {
    String applicationName;
    String applicationVersion;
    String hostname;
    String ip;
    String osName;
    String processId;
    int threadCount;
    int availableProcessors;
    String physicalMemorySize;
    String[] profiles;
}
