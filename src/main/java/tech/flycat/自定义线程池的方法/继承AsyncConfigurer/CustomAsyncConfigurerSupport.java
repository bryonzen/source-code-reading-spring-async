package tech.flycat.自定义线程池的方法.继承AsyncConfigurer;

import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import javax.annotation.Resource;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/15
 */
//@Component
public class CustomAsyncConfigurerSupport extends AsyncConfigurerSupport {
    private final AtomicInteger threadCount = new AtomicInteger(0);

    @Resource
    private AsyncTaskExecutionProperties asyncTaskExecutionProperties;

    @Override
    public Executor getAsyncExecutor() {
        // 获取配置
        AsyncTaskExecutionProperties.Pool pool = asyncTaskExecutionProperties.getPool();
        // 工作队列
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(pool.getQueueCapacity());
        // 线程创建工厂
        ThreadFactory threadFactory = r -> {
            String threadName = asyncTaskExecutionProperties.getThreadNamePrefix() + threadCount.incrementAndGet();
            return new Thread(r, threadName);
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(pool.getCoreSize(), pool.getMaxSize(), pool.getKeepAlive(), TimeUnit.SECONDS, workQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(pool.isAllowCoreThreadTimeout());
        return threadPoolExecutor;
    }
}
