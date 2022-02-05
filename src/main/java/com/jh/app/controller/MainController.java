package com.jh.app.controller;

import com.jh.app.model.ServerInfo;
import com.jh.app.service.ServerInfoService;
import com.jh.app.service.WaitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    // 정보 조회
    private final ApplicationContext applicationContext;
    private final ServerInfoService serverInfoService;
    private final WaitService waitService;

    @GetMapping("/health_check")
    ResponseEntity healthCheck() {
        return ResponseEntity.ok(Collections.singletonMap("status", "UP"));
    }

    @GetMapping("/health")
    ResponseEntity health() {
        return ResponseEntity.ok(Collections.singletonMap("status", "OK"));
    }

    @GetMapping
    ServerInfo serverInfo() {
        log.info("request serverInfo.");
        return serverInfoService.getServerInfo();
    }

//    @GetMapping("/env/list")
//    ResponseEntity getEnvValues() {
//        return ResponseEntity.ok(serverInfoService.getEnvValues());
//    }
//
//    @GetMapping("/env")
//    ResponseEntity getEnvValue(@RequestParam String name) {
//        return ResponseEntity.ok(Collections.singletonMap(name, serverInfoService.getEnvValue(name)));
//    }

    @GetMapping("/wait")
    ResponseEntity wait(@RequestParam int secs) throws Exception {
        return ResponseEntity.ok(waitService.wait(secs));
    }

    @GetMapping("/shutdown")
    void shutdown() {
        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
