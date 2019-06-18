package com.woniuxy.factory;
/*
 * 1.需要一个公共的接口，是所有工厂应该事实现的
 * 2.创建一个食物抽象类,是所有食物的父类，实现接口
 * 3.创建一些食物类，实现接口
 * 
 * 4.创建一个工厂的接口，所有的工厂都应该实现这个接口
 * 5.创建工厂类
 * 
 */
interface IFood{
	public void eat();
}

abstract class AbsFood implements IFood{
	String name;
	public AbsFood(String name) {
		super();
		this.name = name;
	}
}

class Meat extends AbsFood{
	public Meat(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("meat");
	}
}

class Milk extends AbsFood{
	public Milk(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("milk");
	}
}
class Bug extends AbsFood{
	public Bug(String name) {
		super(name);
	}
	@Override
	public void eat() {
		System.out.println("bug");
	}
}
//工厂的接口
interface IFoodFactory{
	public AbsFood createFood(int type);
}
class FoodFacroty implements IFoodFactory{
	@Override
	public AbsFood createFood(int type) {
		if (type==1) {
			return new Meat("猪肉");
		}else if (type==2) {
			return new Milk("特能输");
		}else if (type==3) {
			return new Bug("大虫子");
		}
		return null;
	}
}

public class FactoryMethod {
	public static void main(String[] args) {
		IFood food = new FoodFacroty().createFood(1);
		System.out.println(food);
		food.eat();
		
		IFood iFood = new Bug("虫子");//面向接口：解耦  耦合度  高内聚低耦合
		//封装、继承、多态
	}
}
