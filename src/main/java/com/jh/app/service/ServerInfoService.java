package com.jh.app.service;

import com.jh.app.config.ApplicationConfiguration;
import com.jh.app.model.ServerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServerInfoService {
    private final Environment environment;

    public ServerInfo getServerInfo() {
        try {
            ServerInfo serverInfo = new ServerInfo();
            InetAddress inetAddress = InetAddress.getLocalHost();
            serverInfo.setApplicationName(environment.getProperty("spring.application.name"));
            serverInfo.setApplicationVersion(environment.getProperty("spring.application.version"));
            serverInfo.setHostname(inetAddress.getHostName());
            serverInfo.setIp(inetAddress.getHostAddress());
            serverInfo.setOsName(System.getProperty("os.name"));
            serverInfo.setProcessId(new String(Files.readAllBytes(ApplicationConfiguration.PID_FILE.toPath()), StandardCharsets.UTF_8));
            serverInfo.setThreadCount(java.lang.Thread.activeCount());
            serverInfo.setProfiles(environment.getActiveProfiles());
            serverInfo.setAvailableProcessors(Runtime.getRuntime().availableProcessors());
            com.sun.management.OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean)
                    java.lang.management.ManagementFactory.getOperatingSystemMXBean();
            serverInfo.setPhysicalMemorySize(FileUtils.byteCountToDisplaySize(os.getTotalPhysicalMemorySize()));
            return serverInfo;
        } catch (Exception e) {
            return new ServerInfo();
        }
    }

    public String getEnvValue(String value) {
        return System.getenv(value);
    }

    public Map<String, String> getEnvValues() {
        return System.getenv();
    }
}
