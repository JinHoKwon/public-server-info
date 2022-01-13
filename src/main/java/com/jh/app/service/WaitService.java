package com.jh.app.service;

import com.jh.app.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WaitService {
    public Map<String, Object> wait(int secs) throws Exception {
        LocalDateTime startAt = LocalDateTime.now();

        for (int i = 0; i < secs; i++) {
            log.info("currentAt : {}", LocalDateTime.now().format(DateTimeUtils.dateTimeFormatter));
            Thread.sleep(1000);
        }

        LocalDateTime finishAt = LocalDateTime.now();

        Map<String, Object> waitResult = new HashMap<>();
        waitResult.put("startAt", startAt.format(DateTimeUtils.dateTimeFormatter));
        waitResult.put("finishAt", finishAt.format(DateTimeUtils.dateTimeFormatter));
        waitResult.put("elapsedAt", Duration.between(startAt, finishAt).toMillis());
        return waitResult;
    }
}
