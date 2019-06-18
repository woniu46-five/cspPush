package com.woniuxy.thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 *Thread 实现了 Runnable接口 
 *
 *需求：
 *	要求开启一个线程，计算1-100之间所有数字的和，
 *	然后将计算的结果返回给主线程，主线中打印结果
 *
 */
//1.继承Thread类
class AThread extends Thread {
	int sum = 0;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum + "," + Thread.currentThread().getName());
	}
}

// 2.实现Runnable接口
class MyRunnable implements Runnable {// 任务
	String name;

	public MyRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + "正在被执行"+","+Thread.currentThread().getName());
	}
}

// 3.实现Callable接口
class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println("...");
		return sum;
	}
}
// 4.通过线程池创建线程
// 常见的四种线程池：单线程池、固定线程池、缓存(可变)线程池、周期性线程池
// 单线程池：里面只有一个线程

public class Base {
	public static void singlePool() {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		// 创建任务，将任务交个线程池执行
		MyRunnable r1 = new MyRunnable("任务1");
		MyRunnable r2 = new MyRunnable("任务2");
		MyRunnable r3 = new MyRunnable("任务3");
		MyRunnable r4 = new MyRunnable("任务4");
		MyRunnable r5 = new MyRunnable("任务5");
		//
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r5);
	}

	// 固定线程池：线程的数量是固定的
	public static void fixedPool() {
		ExecutorService pool = Executors.newFixedThreadPool(3); // 3个线程
		// 创建任务，将任务交个线程池执行
		MyRunnable r1 = new MyRunnable("任务1");
		MyRunnable r2 = new MyRunnable("任务2");
		MyRunnable r3 = new MyRunnable("任务3");
		MyRunnable r4 = new MyRunnable("任务4");
		MyRunnable r5 = new MyRunnable("任务5");
		//
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r5);
	}
	//缓存(可变)线程池：线程池里面的线程数量可以根据任务的多少自动变化，以到达尽快处理任务
	public static void cachePool() {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			MyRunnable runnable = new MyRunnable("任务"+i);
			pool.execute(runnable);
		}
	}
	//周期性线程池：可以在指定的周期内反复执行某些任务
	public static void scheduledPool() {
		ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(1);//1个线程
		//参数1：要执行的任务
		//参数2：第一次执行这个任务时延迟时间
		//参数3：间隔时间
		//参数4：时间单位
		pool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(new Date());
			}
		}, 0, 365, TimeUnit.DAYS);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// AThread thread = new AThread();
		// thread.start();//join() yield()
		// //thread.join();//谁在调用join()方法：主线程，主线程暂停执行等待thread代表的子线程先执行
		// //Thread.yield(); //
		// System.out.println(thread.sum);

		// // 1.创建callable对象
		// MyCallable callable = new MyCallable();
		// // 2.创建任务管理器：管理、调度任务、线程
		// FutureTask<Integer> task = new FutureTask<>(callable);
		// // 3.创建线程
		// Thread thread = new Thread(task);
		// // 4.启动线程
		// thread.start();
		// // 5.通过任务管理器获取数据
		// System.out.println(task.get());//
		// get()阻塞方法，会让当前线程进入阻塞状态，等待子线程执行完毕才会继续执行

		//singlePool();
		//fixedPool();
		//cachePool();
		scheduledPool();
	}
}
