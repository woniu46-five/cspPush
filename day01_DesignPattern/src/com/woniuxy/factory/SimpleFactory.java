
package com.woniuxy.factory;

/*
 * 工厂：造汽车
 * 简单工厂：
 * 	1.创建抽象类，是所有工厂的父类
 * 	2.创建工厂类：赋值造汽车
 * 	3.创建一个所有商品的父类
 *  4.创建子类
 */

//工厂类
class BmwFactory{
	//指定造成类型
	public static final int CAR_TYPE_SUV = 1;
	public static final int CAR_TYPE_CAR = 2;
	public static final int CAR_TYPE_MOTO = 3;
	public Traffic createCar(int type) {
		if (type==CAR_TYPE_CAR) {
			//造一个汽车
			return new B740("7系");
		}else if (type==CAR_TYPE_SUV) {
			//造suv
			return new X5("红色的x5");
		}else if (type==CAR_TYPE_MOTO) {
			//造摩托
			return new Moto("宝马拉力车!");
		}
		return null;
	}
}
abstract class Traffic{
	public String name;
	public Traffic(String name) {
		super();
		this.name = name;
	}
}
class X5 extends Traffic{
	public X5(String name) {
		super(name);
	}
}
class B740 extends Traffic{
	public B740(String name) {
		super(name);
	}
}
class Moto extends Traffic{
	public Moto(String name) {
		super(name);
	}
}

public class SimpleFactory {
	public static void main(String[] args) {
		BmwFactory factory = new BmwFactory();
		
		Traffic traffic = factory.createCar(BmwFactory.CAR_TYPE_MOTO);
		System.out.println(traffic);
	}
}
