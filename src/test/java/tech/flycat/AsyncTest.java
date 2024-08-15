package tech.flycat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tech.flycat.service.AsyncService;
import tech.flycat.自定义线程池的方法.为方法指定线程池.MethodService;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author <a href="mailto:me@flycat.tech">Bryon Zen</a>
 * @since 2024/8/14
 */
@SpringBootTest(classes = Application.class)
public class AsyncTest {
    @Resource
    private AsyncService asyncService;
    @Resource
    private MethodService methodService;

    @Test
    public void start() throws Exception {
        long start = System.currentTimeMillis();
        asyncService.thisIsAnAsyncMethod();
        long end = System.currentTimeMillis();

        System.out.println("调用完成，用时" + (end - start) + "ms");
        Thread.sleep(6000);
    }

    @Test
    public void testAsyncCompletableFutureMethod() throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture<String> completableFuture = asyncService.thisIsAnAsyncCompletableFutureMethod();
        System.out.println("异步执行的结果为: " + completableFuture.get());
        long end = System.currentTimeMillis();

        System.out.println("调用完成，用时" + (end - start) + "ms");
        Thread.sleep(5000);
    }

    @Test
    public void testAsyncFutureMethod() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> future = asyncService.thisIsAnAsyncFutureMethod();
        System.out.println("异步执行的结果为: " + future.get());
        long end = System.currentTimeMillis();

        System.out.println("调用完成，用时" + (end - start) + "ms");
        Thread.sleep(5000);
    }

    @Test
    public void testMethodService() throws Exception {
        long start = System.currentTimeMillis();
        methodService.test();
        long end = System.currentTimeMillis();

        System.out.println("调用完成，用时" + (end - start) + "ms");
        Thread.sleep(6000);
    }
}
