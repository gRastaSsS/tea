package edu.fluffytiger.tea.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class MainConfig {
    @Value("${tasks.threads}")
    private Integer threads;

    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler pool = new ThreadPoolTaskScheduler();
        pool.setPoolSize(threads);
        pool.setThreadNamePrefix("Task_Scheduler");
        return pool;
    }
}
