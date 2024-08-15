package tech.flycat.自定义线程池的方法.继承AsyncConfigurer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/15
 */
@Configuration
@ConfigurationProperties(prefix = "spring.task.execution.custom")
public class AsyncTaskExecutionProperties {
    private Pool pool = new Pool();
    // 线程名称前缀
    private String threadNamePrefix = "asyncTask-";

    public static class Pool {
        // 线程池队列大小
        private int queueCapacity = 128;
        // 核心线程池数量
        private int coreSize = Runtime.getRuntime().availableProcessors();
        // 最大线程数量
        private int maxSize = Runtime.getRuntime().availableProcessors() * 4;
        // 是否允许核心线程关闭
        private boolean allowCoreThreadTimeout = false;
        // 空闲线程超时时间
        private Long keepAlive = 60L;

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }

        public int getCoreSize() {
            return coreSize;
        }

        public void setCoreSize(int coreSize) {
            this.coreSize = coreSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public boolean isAllowCoreThreadTimeout() {
            return allowCoreThreadTimeout;
        }

        public void setAllowCoreThreadTimeout(boolean allowCoreThreadTimeout) {
            this.allowCoreThreadTimeout = allowCoreThreadTimeout;
        }

        public Long getKeepAlive() {
            return keepAlive;
        }

        public void setKeepAlive(Long keepAlive) {
            this.keepAlive = keepAlive;
        }
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
}
