package com.woniuxy.factory;
/*
 * 簇：
 * 	USB2.0			接口
 * 		电脑
 * 		U盘
 * 		键盘
 * 	USB3.0			接口
 * 		电脑
 * 		U盘
 * 		鼠标
 * 1.创建一个公共的接口
 * 2.设置簇接口
 * 3.创建具体的产品类
 * 4.创建工厂接口
 * 
 */
interface Usb{
	public void transferData();
}
interface Usb2 extends Usb{
	
}
interface Usb3 extends Usb{
	
}
//usb2.0 簇
class Computer2 implements Usb2{
	@Override
	public void transferData() {
		System.out.println("computer usb2.0");
	}
}
class Upan2 implements Usb2{
	@Override
	public void transferData() {
		System.out.println("upan usb2.0");
	}
}
//usb3.0簇
class Computer3 implements Usb3{
	@Override
	public void transferData() {
		System.out.println("computer usb3.0");
	}
}
class Upan3 implements Usb3{
	@Override
	public void transferData() {
		System.out.println("upan usb3.0");
	}
}
//公共的接口
interface IUsbFactory{
	public static final double USB2_0 = 2.0;
	public static final double USB3_0 = 3.0;
	//两个方法：用来生产电脑
	public Usb createComputer(double usb);
	//生产U盘
	public Usb createUpan(double usb);
}
//工厂
class Factory implements IUsbFactory{
	@Override
	public Usb createComputer(double usb) {
		if (usb==IUsbFactory.USB2_0) {
			return new Computer2();
		}else if (usb==IUsbFactory.USB3_0) {
			return new Computer3();
		}
		return null;
	}
	@Override
	public Usb createUpan(double usb) {
		return null;
	}
}

public class AbstractFactory {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Usb usb = factory.createComputer(IUsbFactory.USB2_0);
		System.out.println(usb);
	}
}
