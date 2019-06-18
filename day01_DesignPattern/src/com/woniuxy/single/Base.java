/**
 * <p>Class:Base.java</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: www.woniuxy.com/</p>
 * @author xw
 * @version 1.0
 */
package com.woniuxy.single;

/*
 * 引用：
 * 	
 */

//饱汉
class Full{
	//1.创建一个指向本类对象的私有、静态的引用
	private static Full instance = null;
	//2.将所有构造方法私有化
	private Full(){
		
		System.out.println("hello");
	}
	//3.提供一个静态方法用于提供本类对象
	public static synchronized Full getInstance() {//Full.class
		if (instance==null) {
			instance = new Full();
		}
		return instance;
	}
}
// 饿汉
class Hungry{
	private static Hungry instance = new Hungry();
	private Hungry(){
		
	}
	public static Hungry newInstance() {
		return instance;
	}
}

//怎么创建线程
//1.继承Thread
//2.实现Runnable接口
class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(Full.getInstance());
	}
}



public class Base {
	public static void main(String[] args) {		
		for (int i = 0; i < 100; i++) {
			new MyThread().start();
		}
	}
}








