package com.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    // 门槛
    static final int THRESHOLD = 100;

    long[] array;

    int start;

    int end;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 如果任务小于100，直接计算
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));
            return sum;
        }

        // 任务大，分为两个
        int middle = (end+start)/2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subTask1 = new SumTask(this.array, start, middle);
        SumTask subTask2 = new SumTask(this.array, middle, end);
        invokeAll(subTask1,subTask2);
        Long subRes1 = subTask1.join();
        Long subRes2 = subTask2.join();
        Long res = subRes1 + subRes2;
        System.out.println("result = (" + subRes1 + " + " + subRes2 + ") ==> " + res);
        return res;
    }

    public static void main(String[] args) {

        long[] array = new long[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        // fork/join task
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = pool.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
}
