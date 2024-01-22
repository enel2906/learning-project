package org.example.app.runner;

import org.example.app.thread.user.LogoutPeriod;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.example.app.service.SessionService;

@Component
public class ConfigRunner implements ApplicationRunner {

    private final SessionService sessionService;
    private final LogoutPeriod logoutPeriod;
    public ConfigRunner(SessionService sessionService, LogoutPeriod logoutPeriod){
        this.sessionService = sessionService;
        this.logoutPeriod = logoutPeriod;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Xóa toàn bộ dữ liệu trong collection session khi ứng dụng khởi động
        sessionService.deleteAllSessions();
        logoutPeriod.start();
    }
}
