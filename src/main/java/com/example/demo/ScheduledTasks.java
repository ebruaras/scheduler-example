package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {
    private static final Logger logger=LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm:ss");
    //Bir önceki task başladıktan sonra 3 saniye içinde 
    @Scheduled(fixedRate = 3000)
    public void ScheduledTaskWithFixedRate(){
        logger.info("Fixed rate task: Execution time -{}",dateTimeFormatter.format(LocalDateTime.now()));
    }
    //Bir önceki task bittikten 2 saniye sonra
    @Scheduled(fixedDelay = 2000)
    public void ScheduleTaskWithFixedDelay() {
        logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }
    //Uygulama başladıktan 5 saniye sonra her saniye
    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void ScheduleTaskWithInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    //Her 5 saniyede bir
    @Scheduled(cron = "*/5 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

}
