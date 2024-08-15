package tech.flycat.自定义线程池的方法.为方法指定线程池;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/15
 */
@Service
public class MethodService {
    @Async(value = "taskExecutorForMethodService")
    public void test() {
        System.out.println("为方法指定线程池，线程名称：" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("为方法指定线程池，线程名称：" + Thread.currentThread().getName() + "结束");
    }
}
