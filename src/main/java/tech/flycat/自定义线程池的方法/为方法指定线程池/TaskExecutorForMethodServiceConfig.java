package tech.flycat.自定义线程池的方法.为方法指定线程池;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/15
 */
@Configuration
public class TaskExecutorForMethodServiceConfig {
//    @Bean(name = "taskExecutorForMethodService")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(8);
        taskExecutor.setMaxPoolSize(16);
        taskExecutor.setQueueCapacity(128);
        taskExecutor.setAllowCoreThreadTimeOut(false);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("taskExecutorForMethodService-");
        return taskExecutor;
    }
}
