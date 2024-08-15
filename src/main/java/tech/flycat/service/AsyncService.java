package tech.flycat.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/14
 */
@Service
public class AsyncService {
    @Async
    public void thisIsAnAsyncMethod() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "结束");
    }

    @Async
    public CompletableFuture<String> thisIsAnAsyncCompletableFutureMethod() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "结束");
        return CompletableFuture.completedFuture("异步方法执行完毕");
    }

    @Async
    public Future<String> thisIsAnAsyncFutureMethod() {
        System.out.println("线程名称：" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "结束");
        return CompletableFuture.completedFuture("异步方法执行完毕");
    }
}
