package mylabs;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThredPoolExecutorTester {
    /**
     * – corePoolSize : 풀 사이즈를 의미한다. 최초 생성되는 스레드 사이즈이며 해당 사이즈로 스레드가 유지된다. 해당 Job의 맞게 적절히 선택해야 한다. 많다고 성능이 잘나오는 것도 아니고 적다고 안나오는 것도 아니다. 충분히 테스트하면서 적절한 개수를 선택해야 한다.
     * – maximumPoolSize : 해당 풀에 최대로 유지할 수 있는 개수를 의미한다. 이 역시 Job에 맞게 적절히 선택해야 한다.
     * – keepAliveTime : corePoolSize보다 스레드가 많아졌을 경우 maximumPoolSize까지 스레드가 생성이 되는데 keepAliveTime 시간만큼 유지했다가 다시 corePoolSize 로 유지되는 시간을 의미한다. (그렇다고 무조건 maximumPoolSize까지 생성되는 건 아니다.)
     * – unit : keepAliveTime 의 시간 단위를 의미한다.
     * – workQueue : corePoolSize보다 스레드가 많아졌을 경우, 남는 스레드가 없을 경우 해당 큐에 담는다.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        /**
         * capacity == 9, corePoolSize == 1 이면 1초에 1개 씩 총 10개 찍고 종료
         * capacity == 8, corePoolSize == 1 이면 1초에 2개 씩 총 10개 찍고 종료
         * capacity == 7, corePoolSize == 1 이면 1초에 3개 씩 총 10개 찍고 종료
         * capacity == 6, corePoolSize == 1 이면 1초에 4개 씩 총 10개 찍고 종료 >>
         * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task codingTest.kakaoMobility.Solution3$Task@266474c2 rejected from java.util.concurrent.ThreadPoolExecutor@6f94fa3e[Running, pool size = 3, active threads = 3, queued tasks = 6, completed tasks = 0]
         * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
         * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
         * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
         * 	at codingTest.kakaoMobility.Solution3.main(Solution3.java:38)
         *
         * 	왜냐하면.... corePoolSize 지금 돌릴 수 있는 사이즈가 1개고 남는 사이즈를 큐에 담으니 10개의 잡이 돌아가야 하는데 큐 사이즈가 6이니 나머지 4개는 멀티 스레드로 돌아야하는데 maximumPoolSize가 3이기때문에 exception 발생
         *
         */
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(9);
        /**
         LinkedBlockingQueue 와 SynchronousQueue는 BlockingQueue의 구현체들이다. 다른점이 있다면 SynchronousQueue 버퍼공간이 존재 하지 않는다.
         */
//        SynchronousQueue<Runnable> queue = new SynchronousQueue<>();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 5 ,3, TimeUnit.MILLISECONDS, queue);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
        executorService.awaitTermination(5, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

}
